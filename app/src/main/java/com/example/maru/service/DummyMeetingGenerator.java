package com.example.maru.service;

import android.content.res.Resources;

import androidx.annotation.StringRes;

import com.example.maru.R;
import com.example.maru.model.Meeting;
import com.example.maru.model.Room;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
    public static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting(0, "La fin du monde",
                    "Peach",
                    "randommail@hotmail.fr",
                    LocalDate.of(2021,12,6),
                    LocalDateTime.of(
                    LocalDate.now(),
                    LocalTime.of(12,30)),
            LocalDateTime.of(
                    LocalDate.now(),
                    LocalTime.of(13,15))
            ),
            new Meeting(0, "La fin du monde",
                    "Mario",
                    "randommail@hotmail.fr",
                    LocalDate.of(2021,12,6),
                    LocalDateTime.of(
                            LocalDate.now(),
                            LocalTime.of(12,30)),
                    LocalDateTime.of(
                            LocalDate.now(),
                            LocalTime.of(13,15))
            )
    );

    static List<Meeting> generateMeetings() { return new ArrayList<>(DUMMY_MEETINGS); }

}
