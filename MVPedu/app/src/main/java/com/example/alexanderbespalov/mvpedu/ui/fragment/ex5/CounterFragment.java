package com.example.alexanderbespalov.mvpedu.ui.fragment.ex5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex5.CounterView;
import com.example.alexanderbespalov.mvpedu.presentation.presenter.ex5.CounterPresenter;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CounterFragment extends MvpAppCompatFragment implements CounterView {
    public static final String TAG = "CounterFragment";
    @InjectPresenter // (type = PresenterType.GLOBAL, tag = "counterPresenter") // uncomment to make it global! (ex6)
    CounterPresenter mCounterPresenter;
    @BindView(R.id.tv_counter) TextView counterTextView;
    @BindView(R.id.btn_counter) Button counterButton;

    public static CounterFragment newInstance() {
        CounterFragment fragment = new CounterFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);

    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState) {
        view.setBackgroundColor(getArguments().getInt("argColor"));
        ButterKnife.bind(this, view);
        counterButton.setOnClickListener(v -> mCounterPresenter.onPlusClick());

    }


    @Override
    public void showCount(int count) {
        counterTextView.setText(String.valueOf(count));
    }
}
