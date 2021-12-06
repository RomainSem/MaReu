package com.example.maru.service;

import androidx.annotation.StringRes;

import com.example.maru.model.Meeting;
import com.example.maru.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService{
    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();
    private List<Room> rooms = new ArrayList<>();


    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    @Override
    public List<Room> getOccupiedRooms() {
        List<Room> occupiedRooms = new ArrayList<>();
        for(Room r: rooms) {
            if(r.isOccupied()){
                occupiedRooms.add(r);
            }
        }
        return occupiedRooms;
    }

    @Override
    public List<Room> getRooms() {
        return rooms;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public void setIsOccupied(@StringRes int name, boolean isOccupied) {
        for(Room r: rooms) {
            if(r.getName() == name) {
                r.setOccupied(isOccupied);
            }
        }
    }
}
