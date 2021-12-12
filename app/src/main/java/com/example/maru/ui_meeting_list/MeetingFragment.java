package com.example.maru.ui_meeting_list;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maru.R;
import com.example.maru.databinding.ItemviewMeetingBinding;
import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;

import java.util.List;


public class MeetingFragment extends Fragment {

    private MeetingApiService mApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;


    public static MeetingFragment newInstance() {
        return new MeetingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getMeetingApiService();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meeting, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));


        return view;

    }

    private void initList() {
        mMeetings = mApiService.getMeetings();
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(mMeetings, mApiService));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}