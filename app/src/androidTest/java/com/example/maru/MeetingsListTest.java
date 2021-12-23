package com.example.maru;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.UiController;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static com.example.maru.utils.RecyclerViewItemCountAssertion.withItemCount;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import com.example.maru.di.DI;
import com.example.maru.model.Meeting;
import com.example.maru.service.DummyMeetingGenerator;
import com.example.maru.ui_meeting_list.ListMeetingActivity;
import com.example.maru.utils.DeleteButtonAction;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MeetingsListTest {

    private static int ITEMS_COUNT = 3;
    private ListMeetingActivity mActivity;
    private Meeting meetingName;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule =
            new ActivityTestRule(ListMeetingActivity.class);

    @Before
    public void setup() {
        DI.getNewInstanceApiService();
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void myMeetingsList_shouldNotBeEmpty() {
        onView(withId(R.id.list_meetings))
                .check(matches(hasMinimumChildCount(1)));
    }


    @Test
    public void myMeetingList_deleteAction_shouldRemoveItem() {
        onView(withId(R.id.list_meetings)).check(withItemCount(ITEMS_COUNT));
        onView(withId(R.id.list_meetings))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteButtonAction()));
        onView((withId(R.id.list_meetings)))
                .check(withItemCount(ITEMS_COUNT - 1));
        }

    @Test
    public void clickOnAddMeeting_shouldOpenAddActivity() {
        onView(withId(R.id.create_meeting)).perform(click());
        onView(withId(R.id.add_meeting)).check(matches(isDisplayed()));
    }

    @Test
    public void createMeeting_shouldCreate() {
        int initialMeetingCount = DummyMeetingGenerator.DUMMY_MEETINGS.size();

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
