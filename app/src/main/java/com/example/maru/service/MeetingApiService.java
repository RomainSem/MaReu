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
    void deleteMeeting(Meeting pMeeting);


    /**
     * Create a meeting
     * @return
     */
    Meeting createMeeting(Meeting pMeeting);

}
