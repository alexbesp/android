package com.example.alexanderbespalov.exampleintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by alexander.bespalov on 13.10.2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void goToNewActivity (View view) {
        Intent intent = new Intent(this, LastActivity.class);
        startActivity(intent);
    }
}
