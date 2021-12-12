package com.example.maru.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static DateTimeFormatter getTimeFormatter() {
        return DateTimeFormatter.ofPattern("HH:mm");
    }

    public static String timeToString (LocalTime time) {
        return time.format(getTimeFormatter());
    }

    public static  DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("d/MM/yyyy");
    }

    public static String dateToString (LocalDate date) {
        return date.format(getDateFormatter());
    }

    /*public static String stringToDate(String dateString, LocalDate meetingDate) {
        LocalDate date;
        return "fa";
    }*/

}

