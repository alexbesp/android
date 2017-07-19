package com.example.alexanderbespalov.mvpedu.ui.adapters.main.bashOrg;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.example.alexanderbespalov.mvpedu.ui.fragment.bashOrg.BashOrgFragment;

/**
 * Created by alexander.bespalov on 03.07.2017.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] {"Новое", "Бездна"};


    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return BashOrgFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
