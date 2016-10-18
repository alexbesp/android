package com.example.alexanderbespalov.exampleintent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by alexander.bespalov on 13.10.2016.
 */
public class LastActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);

    }

    public void onBack(View v) {
        finish();
    }
}
