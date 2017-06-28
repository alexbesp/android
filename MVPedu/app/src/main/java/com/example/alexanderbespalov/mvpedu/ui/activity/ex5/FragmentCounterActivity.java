package com.example.alexanderbespalov.mvpedu.ui.activity.ex5;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.ui.fragment.ex5.CounterFragment;

public class FragmentCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_counter);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction
                    .add(R.id.first_container, getFragment(0xffFF80AB))
                    .add(R.id.second_container, getFragment(0xffCCFF90))
                    .commit();
        }
    }

    private Fragment getFragment(int color) {
        CounterFragment fragment = new CounterFragment();
        Bundle args = new Bundle();
        args.putInt("argColor", color);
        fragment.setArguments(args);
        return fragment;
    }
}
