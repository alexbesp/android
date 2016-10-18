package com.example.alexanderbespalov.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alexander.bespalov on 13.10.2016.
 */
public class MainActivity extends Activity  {

    private EditText login;
    private EditText password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        password.getText().clear();
        login.getText().clear();
        login.requestFocus();
    }

    public void sendData(View v) {
        if (password.getText().toString().equals("sa")) {
            Intent intent = new Intent(this, LastActivity.class);
            intent.putExtra("login", login.getText().toString());
            intent.putExtra("pass", password.getText().toString());
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(this, "Не-а", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0 );
            toast.show();
        }


    }
}
