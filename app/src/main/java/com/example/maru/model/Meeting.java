package com.example.maru.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;



public class Meeting implements Serializable {

    /** Identifier */
    private long id;

    private LocalDate date;

    /** Start of meeting */
    private LocalTime startOfMeeting;

    /** End of meeting */
    private LocalTime endOfMeeting;

    /** Room name */
    private String room;

    /** Email  */
    private String mail;

    /** Subject */
    private String subject;

    /** Constructor */
    public Meeting(long id,String subject, String room, String mail, LocalDate date, LocalTime startOfMeeting, LocalTime endOfMeeting ) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.mail = mail;
        this.date = date;
        this.startOfMeeting = startOfMeeting;
        this.endOfMeeting = endOfMeeting;


    }

    /** Getters and Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getStartOfMeeting() {
        return startOfMeeting;
    }

    public void setStartOfMeeting(LocalTime startOfMeeting) {
        this.startOfMeeting = startOfMeeting;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalTime getEndOfMeeting() {
        return endOfMeeting;
    }

    public void setEndOfMeeting(LocalTime endOfMeeting) {
        this.endOfMeeting = endOfMeeting;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
