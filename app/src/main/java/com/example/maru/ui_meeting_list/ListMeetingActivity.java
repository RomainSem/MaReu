package com.example.maru.ui_meeting_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;

import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListMeetingActivity extends AppCompatActivity {

    public Toolbar mToolbar;
    public FloatingActionButton btnCreate;
    public ImageButton btnFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);
        mToolbar = findViewById(R.id.toolbar);
        btnCreate = findViewById(R.id.create_meeting);
        btnFilter = findViewById(R.id.filter_button);
        getSupportActionBar().hide();

        btnFilter.setOnClickListener(view -> finish() );

        btnCreate.setOnClickListener(view -> AddMeetingActivity.navigate(this));
    }
}