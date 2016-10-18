package com.example.alexanderbespalov.toastcheck;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by alexander.bespalov on 13.10.2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    public void onShow(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Здесь был саня", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void onPosition(View view) {
        Context context = getApplicationContext();
        Configuration configuration = getResources().getConfiguration();

        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(context, "Это портретный вид", Toast.LENGTH_SHORT).show();
        }
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(context, "Это альбомный вид", Toast.LENGTH_SHORT).show();
        }

    }
}