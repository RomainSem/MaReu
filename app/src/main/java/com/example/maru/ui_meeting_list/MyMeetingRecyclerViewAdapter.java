package com.example.maru.ui_meeting_list;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maru.model.Meeting;
import com.example.maru.R;
import com.example.maru.model.Meeting;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.SimpleTimeZone;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;


    public MyMeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_meeting, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Meeting meeting = mMeetings.get(position);




    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView subject;
        public final TextView time;
        public final TextView roomName;
        public final TextView emails;



        public ViewHolder(View view) {
            super(view);
            subject = view.findViewById(R.id.subject);
            time = view.findViewById(R.id.time);
            roomName = view.findViewById(R.id.room_name);
            emails = view.findViewById(R.id.emails);


        }

        public void displayMeetings(Meeting meeting) {
            subject.setText(meeting.getSubject());
          //  time.setText(AddMeetingActivity.getTimeFormatter()); //TODO
            roomName.setText(meeting.getRoom());
            emails.setText(meeting.getMail());
        }
    }
}
