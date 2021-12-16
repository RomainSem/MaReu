package com.example.maru.service;

import com.example.maru.model.Meeting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(

            new Meeting(0, "Le début du monde",
                    "Peach",
                    "romain@hotmail.fr",
                    LocalDate.of(2021,12,6),
                    LocalTime.of(13,15),
                    LocalTime.of(13,45)),

            new Meeting(0, "La fin du monde",
                    "Mario",
                    "randommail@hotmail.fr" + "; " + "machin@hotmail.com",
                    LocalDate.of(2021,12,6),
                    LocalTime.of(14,30),
                    LocalTime.of(15,0))

    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_MEETINGS); }

}
