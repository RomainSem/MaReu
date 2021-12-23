package com.example.maru.service;

import com.example.maru.model.Meeting;

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

}
