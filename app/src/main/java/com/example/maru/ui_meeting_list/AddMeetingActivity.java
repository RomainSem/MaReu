package com.example.maru.ui_meeting_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;
import com.example.maru.utils.DateTimeHelper;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class AddMeetingActivity extends AppCompatActivity {

    private ActivityAddMeetingBinding binding;
    List<Meeting> meetingList;
    MyMeetingRecyclerViewAdapter mAdapter;
    MeetingApiService mApiService;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        mApiService = DI.getMeetingApiService();


        binding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.room_choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerRoom.setAdapter(adapter);
        binding.spinnerRoom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.startTime.setOnClickListener(v -> buttonSelectTime("debut"));
        binding.endTime.setOnClickListener(v -> buttonSelectTime("fin"));
        binding.date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
        binding.startTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        binding.endTime.setText(LocalTime.now().plusMinutes(45).format(DateTimeFormatter.ofPattern("HH:mm")));
        binding.date.setOnClickListener(v -> buttonSelectDate());

        binding.createButton.setOnClickListener(view1 -> {
            onSubmit();
            Toast.makeText(getApplicationContext(), "Meeting created", Toast.LENGTH_SHORT).show();
        });



    }

    private void buttonSelectDate() {
        CalendarConstraints constraints = new CalendarConstraints.Builder()
                .setValidator(DateValidatorPointForward.now())
                .build();
        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(constraints)
                .build();
        datePicker.show(getSupportFragmentManager(), "DATEPICKER");
        datePicker.addOnPositiveButtonClickListener(selection -> {
            LocalDate localDate = Instant.ofEpochMilli((long) datePicker.getSelection())
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            binding.date.setText(DateTimeHelper.dateToString(localDate));
        });
    }



    private void buttonSelectTime(String debutfin) {
        MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build();
        timePicker.show(getSupportFragmentManager(), "TIMEPICKER");
        timePicker.addOnPositiveButtonClickListener(view -> {

            if(debutfin.equals("debut")) {
                LocalTime localTime = LocalTime.of(timePicker.getHour(), timePicker.getMinute());
                binding.startTime.setText(DateTimeHelper.timeToString(localTime));
            }
            else if (debutfin.equals("fin")){
                /*if(endHour < startHour) {
                    binding.endTime.setError("End meeting time cannot happen before start meeting time");
                }*/
                LocalTime localTime = LocalTime.of(timePicker.getHour(), timePicker.getMinute());
                binding.endTime.setText(DateTimeHelper.timeToString(localTime));
            }
        });
    }


    private void onSubmit() {
        String subject = binding.meetingSubject.getText().toString();
        String email = binding.participants.getText().toString();


            if (subject.isEmpty()) {
                binding.meetingSubject.setError("Please type a subject");
            }
            if (email.isEmpty()) {
                binding.participants.setError("Please enter at least one email");
            }
            else {
                generateMeeting();
            }

    }

    private void generateMeeting() {
       Meeting meeting =  new Meeting(
                System.currentTimeMillis(),
                binding.meetingSubject.getText().toString(),
                binding.spinnerRoom.getSelectedItem().toString(),
                binding.participants.getText().toString(),
                LocalDate.parse(binding.date.getText().toString(), DateTimeHelper.getDateFormatter()),
                LocalTime.parse(binding.startTime.getText().toString(), DateTimeHelper.getTimeFormatter()),
                LocalTime.parse(binding.endTime.getText().toString(), DateTimeHelper.getTimeFormatter()));

           mApiService.createMeeting(meeting);
           finish();

    }


    public static void navigate (FragmentActivity activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }


}

