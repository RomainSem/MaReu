package com.example.maru.service;

import androidx.annotation.StringRes;

import com.example.maru.model.Meeting;
import com.example.maru.model.Room;

import java.util.List;

/** Meeting API Client */
public interface MeetingApiService {

    /**
     * Get All my Meetings
     * @return {@link List}
     */
    List<Meeting> getMeetings();

    List<Room>  getOccupiedRooms();

    List<Room> getRooms();

    /**
     * Deletes a meeting
     */
    void deleteMeeting(Meeting meeting);

    /**
     * Create a meeting
     */
    void createMeeting(Meeting meeting);

    void setIsOccupied(@StringRes int name, boolean isOccupied);
}
