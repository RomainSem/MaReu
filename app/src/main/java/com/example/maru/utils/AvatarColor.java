package com.example.maru.utils;


import android.widget.Spinner;

public class AvatarColor {
    private static int meetingColor;

    public static int getRoomColor(String roomName) {
        if(roomName.equals("Peach")) {
            meetingColor = 0xFFEF5350;
        }
        if(roomName.equals("Mario")) {
            meetingColor = 0xFFEC407A;
        }
        if(roomName.equals("Luigi")) {
            meetingColor = 0xFFAB47BC;
        }
        if(roomName.equals("Toad")) {
            meetingColor = 0xFF7E57C2;
        }
        if(roomName.equals("Kirby")) {
            meetingColor = 0xFF5C6BC0;
        }
        if(roomName.equals("Zelda")) {
            meetingColor = 0xFF42A5F5;
        }
        if(roomName.equals("Link")) {
            meetingColor = 0xFF26C6DA;
        }
        if(roomName.equals("Yoshi")) {
            meetingColor = 0xFF26A69A;
        }
        if(roomName.equals("Wario")) {
            meetingColor = 0xFF66BB6A;
        }
        if(roomName.equals("Donkey")) {
            meetingColor = 0xFFFFEB3B;
        }
        return meetingColor;
    }
}
