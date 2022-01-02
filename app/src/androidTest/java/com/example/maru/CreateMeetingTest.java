package com.example.maru;


import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.DummyMeetingGenerator;
import com.example.maru.ui_meeting_list.ListMeetingActivity;
import com.google.android.material.textfield.TextInputEditText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.example.maru.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(AndroidJUnit4.class)
public class CreateMeetingTest {

    private ListMeetingActivity mActivity;
    int initialMeetingCount = DummyMeetingGenerator.DUMMY_MEETINGS.size();

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule =
            new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setUp() {
        DI.getNewInstanceApiService();
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void createMeeting_shouldCreate() {
        Meeting expectedMeeting = new Meeting(10, "Project 5", "Peach",
                "link@hotmail.fr; " + "zelda@hotmail.fr",
                LocalDate.now(), LocalTime.now(), LocalTime.now().plusMinutes(45));

        onView(withId(R.id.create_meeting)).perform(click());
        onView(withId(R.id.meeting_subject)).perform(typeText(expectedMeeting.getSubject()));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.participants)).perform(typeText(expectedMeeting.getMail()));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.createButton)).perform(click());
        onView(withId(R.id.list_meetings)).check(withItemCount(initialMeetingCount + 1) );
    }
}