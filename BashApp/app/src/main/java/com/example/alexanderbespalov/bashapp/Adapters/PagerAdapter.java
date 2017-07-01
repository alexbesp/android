package com.example.alexanderbespalov.bashapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by alexander.bespalov on 01.07.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        case 0:
            TabFragment1 tab1 = new TabFragment1();
            return tab1
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
