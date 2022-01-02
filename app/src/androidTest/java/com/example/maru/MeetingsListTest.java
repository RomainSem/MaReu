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
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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

    private ListMeetingActivity mActivity;
    int initialMeetingCount = DummyMeetingGenerator.DUMMY_MEETINGS.size();

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
        onView(withId(R.id.list_meetings))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteButtonAction()));
        onView((withId(R.id.list_meetings)))
                .check(withItemCount(initialMeetingCount - 1));
        }

    @Test
    public void clickOnAddMeeting_shouldOpenAddActivity() {
        onView(withId(R.id.create_meeting)).perform(click());
        onView(withId(R.id.add_meeting)).check(matches(isDisplayed()));
    }

    @Test
    public void filterMeetingByDate_shouldWork() {
        onView(withId(R.id.filter_menu_activity_main)).perform(click());
        onView(withText("By Date")).perform(click());
        onView(withText("OK")).perform(click());
        onView(withId(R.id.list_meetings)).check(withItemCount(initialMeetingCount - 4));
    }

    @Test
    public void filterMeetingByRoom_shouldWork() {
        onView(withId(R.id.filter_menu_activity_main)).perform(click());
        onView(withText("By Room")).perform(click());
        onView(withText("FILTER")).perform(click());
        onView(withId(R.id.list_meetings)).check(withItemCount(initialMeetingCount - 3));
    }
}
