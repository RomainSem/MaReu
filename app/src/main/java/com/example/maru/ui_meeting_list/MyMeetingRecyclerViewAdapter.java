package com.example.maru.ui_meeting_list;

import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.maru.databinding.ItemviewMeetingBinding;
import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.R;

import com.example.maru.service.DummyMeetingApiService;
import com.example.maru.service.MeetingApiService;
import com.example.maru.utils.DateTimeHelper;


import java.util.List;


public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;
    MeetingApiService mApiService;


    public MyMeetingRecyclerViewAdapter(List<Meeting> meetings, MeetingApiService mApiService) {
        mMeetings = meetings;
        this.mApiService = mApiService;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_meeting, parent, false);
        return new ViewHolder(ItemviewMeetingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);

        holder.binding.subject.setText(meeting.getSubject());
        holder.binding.time.setText(DateTimeHelper.timeToString(meeting.getStartOfMeeting()));
        holder.binding.roomName.setText(meeting.getRoom());
        holder.binding.emails.setText(meeting.getMail());

        holder.binding.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiService = DI.getMeetingApiService();
                mApiService.deleteMeeting(meeting);
                Toast.makeText(view.getContext(), "igejzrighjei", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemviewMeetingBinding binding;



        public ViewHolder(ItemviewMeetingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }

    }
}
