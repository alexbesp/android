package com.example.alexanderbespalov.myfragmentapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private One_Fragment one_fragment;
    private Two_Fragment two_fragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Switch isBackStack;
    private ProgressBar progressBar;
    private TextView textProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        initFragmentFour();
        one_fragment = new One_Fragment();
        two_fragment = new Two_Fragment();
        isBackStack = (Switch)  findViewById(R.id.switchBackStack);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textProgress = (TextView) findViewById(R.id.textProgress);
    }

    private void initFragmentFour() {
        transaction = manager.beginTransaction();

        transaction.add(R.id.container2, new FourFragment());

        transaction.commit();
    }

//    public void onClickBtnFragment(View view) {
//        EditText editText = (EditText) findViewById(R.id.text);
//        TextView textView = (TextView) findViewById(R.id.textViewFrag);
//        textView.setText(editText.getText());
//    }

    public  void onClickFragment (View view) {
        transaction = manager.beginTransaction();

        switch (view.getId()) {
            case R.id.btnAdd :
                if (manager.findFragmentByTag(one_fragment.TAG) == null) {
                    transaction.add(R.id.container, one_fragment, one_fragment.TAG);
                }
                break;
            case R.id.btnRemove :
                if (manager.findFragmentByTag(one_fragment.TAG) != null) {
                    transaction.remove(one_fragment);
                }    if (manager.findFragmentByTag(two_fragment.TAG) != null) {
                    transaction.remove(two_fragment);
                }
                break;
            case R.id.btnReplace :
                if (manager.findFragmentByTag(one_fragment.TAG) != null) {
                    transaction.replace(R.id.container, two_fragment, two_fragment.TAG);
                }                if (manager.findFragmentByTag(two_fragment.TAG) != null) {
                    transaction.replace(R.id.container, one_fragment, one_fragment.TAG);
                }
        }
        if (isBackStack.isChecked()) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public void onProgressButton(View view) {
        new MyProgressBarAsyncTask().execute();
    }

    class MyProgressBarAsyncTask extends AsyncTask<Void, Integer, Void> {

        private int progressBarvalue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Начало процесса", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(MainActivity.this, "Процесс окончен", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            textProgress.setText(values[0] + " % ");

        }


        @Override
        protected Void doInBackground(Void... params) {
            while(progressBarvalue < 100) {
                progressBarvalue++;
                publishProgress(progressBarvalue);
                SystemClock.sleep(200);
            }
            return null;
        }
    }
    
}
