/*
package com.example.alexanderbespalov.mvpedu.ui.adapters.main.bashOrg;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.arellomobile.mvp.MvpDelegate;
import com.arellomobile.mvp.MvpFragment;

*/
/**
 * Created by alexander.bespalov on 03.07.2017.
 *//*


public abstract class MvpFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private MvpDelegate<? extends MvpFragmentStatePagerAdapter> mvpDelegate;
    private MvpDelegate<?> parentDelegate;
    private String childId;


    public MvpFragmentStatePagerAdapter(FragmentManager fm, MvpDelegate<?> parentDelegate, String childId) {
        super(fm);
        this.parentDelegate = parentDelegate;
        this.childId = childId;

        getMvpDelegate().onCreate();
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    public MvpDelegate<? extends MvpFragmentStatePagerAdapter> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new MvpDelegate<>(this);
            mvpDelegate.setParentDelegate(parentDelegate, childId);
        }
        return mvpDelegate;
    }
}
*/
