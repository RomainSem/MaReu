package com.example.maru.service;

import com.example.maru.model.Meeting;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(

            new Meeting(1, "Secret Project",
                    "Mario",
                    "randommail@hotmail.fr" + "; " + "machin@hotmail.com; " + "adrien@hotmail.com; " + "laurie@hotmail.com; ",
                    LocalDate.of(2021,12,6),
                    LocalTime.of(14,30),
                    LocalTime.of(15,0)),

            new Meeting(0, "AA game",
                    "Peach",
                    "romain@hotmail.fr",
                    LocalDate.of(2021,12,4),
                    LocalTime.of(13,15),
                    LocalTime.of(13,45)),

            new Meeting(1, "Project 13",
                    "Mario",
                    "randommail@hotmail.fr" + "; " + "machin@hotmail.com; " + "adrien@hotmail.com; " + "laurie@hotmail.com; ",
                    LocalDate.of(2022,1,2),
                    LocalTime.of(14,30),
                    LocalTime.of(15,0)),

            new Meeting(2, "Iphone Pro 42",
                    "Luigi",
                    "maxime@hotmail.fr" + "; " + "alexandre@gmail.fr",
                    LocalDate.of(2021,12,4),
                    LocalTime.of(14,30),
                    LocalTime.of(15,0)),

            new Meeting(0, "Triple A game",
                                "Peach",
                                "romain@hotmail.fr",
                        LocalDate.of(2021,12,5),
                    LocalTime.of(13,15),
                            LocalTime.of(13,45))

    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_MEETINGS); }

}
