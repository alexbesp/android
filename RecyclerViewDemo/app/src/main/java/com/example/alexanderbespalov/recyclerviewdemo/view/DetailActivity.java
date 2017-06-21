package com.example.alexanderbespalov.recyclerviewdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.alexanderbespalov.recyclerviewdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alexander.bespalov on 16.06.2017.
 */

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOUR = "EXTRA_COLOUR";

    @BindView(R.id.tv_message_body) TextView message;
    @BindView(R.id.tv_date_and_time_header) TextView dateAndTime;
    @BindView(R.id.cont_colored_background) View coloredBackground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent i = getIntent();
        String dateAndTimeExtra = i.getStringExtra(EXTRA_DATE_AND_TIME);
        String messageExtra = i.getStringExtra(EXTRA_MESSAGE);
        int colorResourseExtra = i.getIntExtra(EXTRA_COLOUR, 0);

        message.setText(messageExtra);
        dateAndTime.setText(dateAndTimeExtra);
        coloredBackground.setBackgroundColor(ContextCompat.getColor(this, colorResourseExtra));
    }
}
