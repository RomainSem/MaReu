package com.example.maru.model;

public class Room {

    private String room;
    private int roomNumber;
    private boolean isOccupied;

    public Room(int roomNumber){
        this.room = "Room";
        this.roomNumber = roomNumber;
        this.isOccupied = false;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}
