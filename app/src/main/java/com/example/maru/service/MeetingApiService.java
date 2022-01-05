package com.example.maru.service;

import com.example.maru.model.Meeting;

import java.time.LocalDate;
import java.time.LocalTime;
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
    void deleteMeeting(int position);


    /**
     * Create a meeting
     * @return
     */
    Meeting createMeeting(Meeting meeting);

    List<Meeting> filterByRoom(String meetingRoom);

    List<Meeting> filterByDate(LocalDate meetingDate);

}
