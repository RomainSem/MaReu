package com.example.maru.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;



import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Spinner;

import android.widget.Toast;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddMeetingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ActivityAddMeetingBinding binding;
    private MeetingApiService mApiService;
    private Spinner spinnerRoom;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        spinnerRoom = findViewById(R.id.spinner_room);

        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.room_choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRoom.setAdapter(adapter); //TODO SPINNER
        spinnerRoom.setOnItemSelectedListener(this);

        binding.startTime.setOnClickListener(v -> buttonSelectTime("debut"));
        binding.endTime.setOnClickListener(v -> buttonSelectTime("fin"));
        binding.create.setOnClickListener(v -> onSubmit());


    }

    private void buttonSelectTime(String debutfin) {
        MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build();
        timePicker.show(getSupportFragmentManager(), "fragment tag");
        timePicker.addOnPositiveButtonClickListener(view -> {
            int startHour = timePicker.getHour();
            int startMinute = timePicker.getMinute();
            int endHour = timePicker.getHour();
            int endMinute = timePicker.getMinute();
            if(debutfin == "debut") {
                binding.startTime.setText(startHour + ":" + startMinute);
            }
            else if (debutfin == "fin"){
                if(endHour < startHour) {
                    binding.endTime.setError("End meeting time cannot happen before start meeting time");
                }
                binding.endTime.setText(endHour + ":" + endMinute);
                }

        });

        }


    private void onSubmit() {
        String subject = binding.meetingSubject.getText().toString();
        String email = binding.participants.getText().toString();
        LocalDateTime startTime = LocalDateTime.parse(binding.startTime.toString());
        LocalDateTime endTime = LocalDateTime.parse(binding.endTime.getText().toString());
        String roomName = binding.spinnerRoom.toString();
        LocalDate date = LocalDate.parse(binding.date.getText().toString());


        if (subject.isEmpty()) {
            binding.meetingSubject.setError("Please type a subject");
            return;
        }
        if (email.isEmpty()) {
            binding.participants.setError("Please enter at least one email");
            return;
        }

        mApiService.createMeeting(new Meeting(System.currentTimeMillis(),subject, roomName, email, date, startTime, endTime));
        Toast.makeText(this, "Meeting created", Toast.LENGTH_SHORT).show();
        finish();
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

    public static void navigate (FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}

