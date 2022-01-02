package com.example.maru.utils;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import androidx.test.rule.ActivityTestRule;

import com.example.maru.di.DI;
import com.example.maru.ui_meeting_list.ListMeetingActivity;

import org.junit.Before;
import org.junit.Rule;


public class CreateMeetingAction {
    private ListMeetingActivity mActivity;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityRule =
            new ActivityTestRule<>(ListMeetingActivity.class);

    @Before
    public void setup() {
        DI.getNewInstanceApiService();
        mActivity = mActivityRule.getActivity();
        assertThat(mActivity, notNullValue());
    }



}
