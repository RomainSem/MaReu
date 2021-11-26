package com.example.maru.service;

import com.example.maru.model.Meeting;
import com.example.maru.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService{
    private List<Meeting> meetings = DummyMeetingGenerator.generateMeetings();
    private List<Room> rooms = RoomGenerator.generateRooms();


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
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    @Override
    public void setIsOccupied(long roomNumber, boolean isOccupied) {
        for(Room r: rooms) {
            if(r.getRoomNumber()== roomNumber) {
                r.setIsOccupied(isOccupied);
            }
        }
    }
}
