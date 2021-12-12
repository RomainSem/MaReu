package com.example.maru.service;

import com.example.maru.model.Meeting;

import java.util.List;

/** Meeting API Client */
public interface MeetingApiService {

    /**
     * Get All my Meetings
     * @return {@link List}
     */
    List<Meeting> getMeetings();



    /**
     * Deletes a meeting
     */
    void deleteMeeting(Meeting meeting);

    /**
     * Create a meeting
     */
    void createMeeting(Meeting meeting);

}
