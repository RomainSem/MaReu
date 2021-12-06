package com.example.maru.model;

import android.widget.DatePicker;

import java.time.LocalDateTime;
import java.util.Objects;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


public class Meeting {

    /** Identifier */
    private long id;

    private DatePicker date;

    /** Start of meeting */
    private LocalDateTime startOfMeeting;

    /** End of meeting */
    private LocalDateTime endOfMeeting;

    /** Room name */
    private String room;

    /** Email  */
    private String mail;

    /** Subject */
    private String subject;

    /** Constructor */
    public Meeting(long id,String subject, String room, String mail, LocalDateTime startOfMeeting, LocalDateTime endOfMeeting ) {
        this.id = id;
        this.subject = subject;
        this.room = room;
        this.mail = mail;
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

    public LocalDateTime getStartOfMeeting() {
        return startOfMeeting;
    }

    public void setStartOfMeeting(LocalDateTime startOfMeeting) {
        this.startOfMeeting = startOfMeeting;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDateTime getEndOfMeeting() {
        return endOfMeeting;
    }

    public void setEndOfMeeting(LocalDateTime endOfMeeting) {
        this.endOfMeeting = endOfMeeting;
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
