package com.example.alexanderbespalov.myapplication2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alexander.bespalov on 13.10.2016.
 */
public class LastActivity extends Activity {

    private TextView txtLogin;
    private TextView txtPassword;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtPassword = (TextView) findViewById(R.id.txtPassword);

        txtLogin.setText(getIntent().getStringExtra("login"));
        txtPassword.setText(getIntent().getStringExtra("pass"));
    }

    public void back (View v) {
        finish();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

    }


}
