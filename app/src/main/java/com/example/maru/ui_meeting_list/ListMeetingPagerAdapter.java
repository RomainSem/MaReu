package com.example.maru.ui_meeting_list;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.maru.ui_meeting_list.MeetingFragment;


public class ListMeetingPagerAdapter extends FragmentPagerAdapter {

    public ListMeetingPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return MeetingFragment.newInstance();
            default :
                return null;
        }
    }

    /**
     * @return the number of pages
     */
    @Override
    public int getCount() {
        return 2;
    }
}