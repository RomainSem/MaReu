package com.example.maru.service;

import com.example.maru.model.Meeting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService{
    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();



    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }





    @Override
    public void deleteMeeting(Meeting pMeeting) {
        meetings.remove(pMeeting);
    }

    @Override
    public Meeting createMeeting(Meeting pMeeting) {
        meetings.add(pMeeting);
        return pMeeting;
    }

    @Override
    public List<Meeting> filterByRoom(String meetingRoom) {
        List<Meeting> filteredList = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getRoom().equals(meetingRoom)) {
                filteredList.add(meeting);
            }
        }
        return filteredList;
    }

    @Override
    public List<Meeting> filterByDate(LocalDate meetingDate) {
        List<Meeting> filteredList = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getDate().equals(meetingDate)) {
                filteredList.add(meeting);
            }
        }
        System.out.println("REGARDE ICI " + filteredList.size());
        return filteredList;
    }

}
