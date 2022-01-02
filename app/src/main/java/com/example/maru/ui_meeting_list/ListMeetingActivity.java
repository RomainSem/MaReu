package com.example.maru.ui_meeting_list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.databinding.ActivityListMeetingBinding;
import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;
import com.example.maru.utils.DateTimeHelper;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class ListMeetingActivity extends AppCompatActivity {

    private ActivityListMeetingBinding binding;
    private Spinner roomInput;
    private List<Meeting> meetings;
    private RecyclerView mRecyclerView;
    private MeetingApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        apiService = DI.getMeetingApiService();
        initList();

        binding.createMeeting.setOnClickListener(v -> AddMeetingActivity.navigate(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_meeting_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem pItem) {
        switch (pItem.getItemId()) {
            case R.id.option_1_date:
                openDateDialog();
                return true;
            case R.id.option_2_room:
                openRoomDialog();
                return true;
            case R.id.option_3_reset:
                initList();
            default:
                return super.onOptionsItemSelected(pItem);
        }
    }

    private void initList() {
        meetings = apiService.getMeetings();
        mRecyclerView = binding.listMeetings;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetings, apiService));
    }

    private void openRoomDialog() {
        AlertDialog.Builder mBuilder =
                new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
        roomInput = (Spinner) mView.findViewById(R.id.dialog_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.room_choice, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomInput.setAdapter(adapter);

        mBuilder.setView(mView)
                .setTitle("Choose a room")
                .setNegativeButton("Cancel", (dialogInterface, i) -> {})
                .setPositiveButton("Filter", (dialogInterface, i) -> {
                    String mRoom = roomInput.getSelectedItem().toString();
                    meetings = apiService.filterByRoom(mRoom);
                    mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetings, apiService));
                });
        mBuilder.create().show();
    }

    private void openDateDialog() {
        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        datePicker.show(getSupportFragmentManager(), "DATEPICKER");
        datePicker.addOnPositiveButtonClickListener(selection -> {
            LocalDate pickedDate = Instant.ofEpochMilli((long) datePicker.getSelection())
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            apiService.filterByDate(pickedDate);
            meetings = apiService.filterByDate(pickedDate);
            mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(meetings, apiService));
        });
    }
}



