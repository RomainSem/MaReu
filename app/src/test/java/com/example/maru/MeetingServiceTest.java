package com.example.maru;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.DummyMeetingGenerator;
import com.example.maru.service.MeetingApiService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MeetingServiceTest {

    private MeetingApiService service;


    @Before
    public void setup() { service = DI.getNewInstanceApiService(); }

    @Test
    public void getMeetingsWithSuccess() {
        List<Meeting> meetings = service.getMeetings();
        List<Meeting> expectedMeetings = DummyMeetingGenerator.DUMMY_MEETINGS;
        MatcherAssert.assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    @Test
    public void deleteMeetingWithSuccess() {
        int taille = service.getMeetings().size();
        Meeting meetingToDelete = service.getMeetings().get(0);
        service.deleteMeeting(meetingToDelete);
        assertEquals(taille - 1, service.getMeetings().size());
    }

    @Test
    public void createMeetingWithSuccess() {
        Meeting meetingToCreate = service.createMeeting(new Meeting(2, "Réunion D",
                "Wario",
                "glergke@hotmail.fr; " + "jnjngjuerhn@gmail.fr",
                LocalDate.of(2021,6,15),
                LocalTime.of(16,30),
                LocalTime.of(17,0)));
        assertTrue(service.getMeetings().contains(meetingToCreate));
    }

    @Test
    public void filterByDateWithSuccess() {
        List<Meeting> meetings = service.filterByDate(LocalDate.of(2022,1,2));
        assertEquals(1, meetings.size());
    }

    @Test
    public void filterByRoomWithSuccess() {
        String roomName = "Peach";
        List<Meeting> meetings = service.filterByRoom(roomName);
        assertEquals(2, meetings.size());
    }
}