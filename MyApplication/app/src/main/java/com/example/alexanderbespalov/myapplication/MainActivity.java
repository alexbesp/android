package com.example.alexanderbespalov.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textWiew;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        textWiew = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textWiew.setText("Привет мир!");
            }
        });
    }

    public void sayHello(View view) {
        textWiew.setText("Привет!");
    }
}
