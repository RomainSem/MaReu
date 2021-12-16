package com.example.maru.utils;

import android.widget.Spinner;

public class RoomColor {
    private String room;
    private int meetingColor;

    public int getRoomColor(Spinner spinner) {
        switch (room) {
            case "Peach":
                meetingColor = 0xFFEF5350;
                break;
            case "Mario":
                meetingColor = 0xFFAB47BC;
                break;
            case "Luigi":
                meetingColor = 0xFF7E57C2;
                break;
            case "Zelda":
                meetingColor = 0xFF5C6BC0;
                break;
            case "Link":
                meetingColor = 0xFF42A5F5;
                break;
            case "Yoshi":
                meetingColor = 0xFF26C6DA;
                break;
            case "Wario":
                meetingColor = 0xFF26A69A;
                break;
            case "Toad":
                meetingColor = 0xFF66BB6A;
                break;
            case "Donkey":
                meetingColor = 0xFFFFEB3B;
                break;
            case "Kirby":
                meetingColor = 0xFFEC407A;
                break;
        }
        return meetingColor;
    }
}
