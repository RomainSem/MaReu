package com.example.maru.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ActivityAddMeetingBinding binding;
    private MeetingApiService mApiService;
    private Spinner spinnerRoom;

    private CheckBox checkBoxIsSpinnerMode;
    private CheckBox checkBoxIs24HView;
    private int lastSelectedHour;
    private int lastSelectedMinute;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);

        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.room_choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoom.setAdapter(adapter);
        spinnerRoom.setOnItemSelectedListener(this);
        onSubmit();

    }

    @Override
    public void onClick(View view) {
        if(view == binding.create) {
            onSubmit();
        }
        if(view == binding.startTime) {
            buttonSelectTime();
        }
        if(view == binding.endTime) {
            buttonSelectTime();
        }
    }

    private void buttonSelectTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                AddMeetingActivity.this,
                (timePicker, i, i1) -> {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(0, 0, 0, lastSelectedHour, lastSelectedMinute);

                },12, 0, true);

        }


    private void onSubmit() {
        String subject = binding.meetingSubject.getText().toString();
        String email = binding.participants.getText().toString();
        String startTime = binding.startTime.getText().toString();
        String endTime = binding.endTime.getText().toString();
        String roomName = binding.spinnerRoom.toString();


        if (subject.isEmpty()) {
            binding.meetingSubject.setError("Please type a subject");
            return;
        }
        if (email.isEmpty()) {
            binding.participants.setError("Please enter at least one email");
            return;
        }

        mApiService.createMeeting(new Meeting(System.currentTimeMillis(),subject, roomName, email, startTime, endTime));
        Toast.makeText(this, "Meeting created", Toast.LENGTH_SHORT).show();
        finish();
    }

    public static void navigate (FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static DateTimeFormatter getTimeFormatter() {
        return DateTimeFormatter.ofPattern("HH:mm");
    }

    public static String timeToString (LocalDateTime time) {
        return time.format(getTimeFormatter());
    }
}

