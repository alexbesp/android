package com.example.alexanderbespalov.trymoxy.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.alexanderbespalov.trymoxy.R;
import com.example.alexanderbespalov.trymoxy.presentation.presenter.HelloWorldPresenter;
import com.example.alexanderbespalov.trymoxy.presentation.view.HelloWorldView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HelloWorldActivity extends MvpAppCompatActivity implements HelloWorldView {

    @InjectPresenter
    HelloWorldPresenter mHelloWorldPresenter;



    private TextView mHelloWorldTextView;

    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);

        ButterKnife.bind(this);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHelloWorldTextView.setText("Нажата кнопка 1");
            }
        });




        mHelloWorldTextView = (TextView) findViewById(R.id.activity_hello_world_text_view_message);
    }


    @OnClick(R.id.button2)
    public void settext(View view) {
        mHelloWorldTextView.setText("Нажата кнопка 2");
    }
    @Override
    public void showMessage(int message) {
        mHelloWorldTextView.setText(message);
    }


    // button2.setOnClickListener(this);
//    public void clickButton3(View view) {
//        mHelloWorldTextView.setText("Нажата кнопка 3");
//    }
//    @Override
//    public void onClick(View view) {
//        mHelloWorldTextView.setText("Нажата кнопка 2");
//    }
}
