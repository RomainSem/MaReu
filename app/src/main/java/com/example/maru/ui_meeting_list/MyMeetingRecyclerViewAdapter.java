package com.example.maru.ui_meeting_list;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.maru.databinding.ItemviewMeetingBinding;
import com.example.maru.model.Meeting;
import com.example.maru.service.MeetingApiService;
import com.example.maru.utils.DateTimeHelper;
import java.util.List;


public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private List<Meeting> mMeetings;
    MeetingApiService mApiService;


    public MyMeetingRecyclerViewAdapter(List<Meeting> meetings, MeetingApiService mApiService) {
        mMeetings = meetings;
        this.mApiService = mApiService;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(ItemviewMeetingBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);

        holder.binding.subject.setText(meeting.getSubject());
        holder.binding.time.setText(DateTimeHelper.timeToString(meeting.getStartOfMeeting()));
        holder.binding.roomName.setText(meeting.getRoom());
        holder.binding.emails.setText(meeting.getMail());


        holder.binding.deleteButton.setOnClickListener(view -> {
            mApiService.deleteMeeting(meeting);
            notifyItemRemoved(getItemCount());
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemviewMeetingBinding binding;




        public ViewHolder(ItemviewMeetingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

}
