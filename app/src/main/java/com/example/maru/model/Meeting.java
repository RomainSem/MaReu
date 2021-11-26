package com.example.maru.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Meeting {

    /** Identifier */
    private final long id;

    /** Start of meeting */
    private LocalDateTime startOfMeeting;

    /** End of meeting */
    private LocalDateTime endOfMeeting;

    /** Room */
    private Room roomNumber;

    /** Email  */
    private String mail;

    /** Subject */
    private String subject;

    /** Constructor */
    public Meeting(long id, LocalDateTime startOfMeeting, LocalDateTime endOfMeeting, Room roomNumber, String mail, String subject) {
        this.id = id;
        this.startOfMeeting = startOfMeeting;
        this.endOfMeeting = endOfMeeting;
        this.roomNumber = roomNumber;
        this.mail = mail;
        this.subject = subject;
    }

    /** Getters and Setters */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartOfMeeting() {
        return startOfMeeting;
    }

    public void setStartOfMeeting(LocalDateTime startOfMeeting) {
        this.startOfMeeting = startOfMeeting;
    }

    public LocalDateTime getEndOfMeeting() {
        return endOfMeeting;
    }

    public void setEndOfMeeting(LocalDateTime endOfMeeting) {
        this.endOfMeeting = endOfMeeting;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
