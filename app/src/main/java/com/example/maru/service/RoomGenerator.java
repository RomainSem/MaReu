package com.example.maru.service;

import com.example.maru.R;
import com.example.maru.model.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class RoomGenerator {
    public static List<Room> ROOMS = Arrays.asList(
            new Room(0, false),
            new Room(1, false),
            new Room(2, false),
            new Room(3, false),
            new Room(4, false),
            new Room(5, false),
            new Room(6, false),
            new Room(7, false),
            new Room(8, false),
            new Room(9, false),
            new Room(10, false)
    );

    static List<Room> generateRooms() {
        return new ArrayList<>(ROOMS);
    }
}
