package com.example.alexanderbespalov.mvpedu.ui.activity.bashOrg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;


import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.bashOrg.BashOrgView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.bashOrg.BashOrgPresenter;


import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexanderbespalov.mvpedu.ui.adapters.main.bashOrg.MyPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BashOrgActivity extends MvpAppCompatActivity implements BashOrgView {
    public static final String TAG = "BashOrgActivity";
    @InjectPresenter
    BashOrgPresenter bashOrgPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, BashOrgActivity.class);
        return intent;
    }

    @BindView(R.id.tabLayout_bash) TabLayout tabLayout;
    @BindView(R.id.toolbar_bash) Toolbar toolbar;
    @BindView(R.id.pager_bash) ViewPager viewPager;


    MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bash_org);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setTitle("Bash Org");

    }

    @Override
    public void setUpAdapter() {
    }



}
