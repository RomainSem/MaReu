package com.example.maru.ui_meeting_list;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ListMeetingPagerAdapter extends FragmentPagerAdapter {
    public ListMeetingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     */

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return MeetingFragment.newInstance();
        }
        return null;
    }

    /**
     * @return the number of pages
     */
    @Override
    public int getCount() {
        return 1;
    }
}
