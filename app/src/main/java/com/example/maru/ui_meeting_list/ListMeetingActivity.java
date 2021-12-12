package com.example.maru.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.databinding.ActivityListMeetingBinding;
import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListMeetingActivity extends AppCompatActivity {

    private ActivityListMeetingBinding binding;
    private List<Meeting> meetings;
    private MeetingApiService apiService = DI.getMeetingApiService();
    ListMeetingPagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListMeetingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mPagerAdapter = new ListMeetingPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mPagerAdapter);
        getSupportActionBar().hide();

        binding.filterButton.setOnClickListener(v -> finish() ); //TODO FILTER

        binding.createMeeting.setOnClickListener(v -> AddMeetingActivity.navigate(this));
    }
}