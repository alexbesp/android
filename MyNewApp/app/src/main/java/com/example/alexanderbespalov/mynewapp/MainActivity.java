package com.example.alexanderbespalov.mynewapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.alexanderbespalov.mynewapp.asyncTask.MyNewAsyncTask;
import com.example.alexanderbespalov.mynewapp.service.MyLifeCycleService;
import com.example.alexanderbespalov.mynewapp.service.MyService;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private int progressBarValue = 0;
    private ProgressBar progressBar;
    private TextView textProgress;
    MyAsyncTask task;
    private MyNewAsyncTask newTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar =  (ProgressBar) findViewById(R.id.progressBar);
        textProgress = (TextView) findViewById(R.id.textProgress);
        task = new MyAsyncTask();
        newTask = MyNewAsyncTask.getInstance(this);
        startService(new Intent(this, MyService.class));
    }

    public void onStartTask(View view) {
        newTask.execute();
    }

    public void onCancelTast(View view) {
        newTask.cancel(false);
    }

    public void onStatusTask(View view) {
        Toast.makeText(this, newTask.getStatus().toString(), Toast.LENGTH_SHORT).show();
    }

    public void onProgressButton (View view) {
        new MyProgressBarAsyncTask().execute();
    }

    public void onShowMessage(View view) throws ExecutionException, InterruptedException {
        task.execute();
        String text = task.get();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    class MyAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            return "Hello";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }


    class MyProgressBarAsyncTask extends AsyncTask <Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            while (progressBarValue < 100) {
                progressBarValue++;
                publishProgress(progressBarValue);
                SystemClock.sleep(200);
            }
            return  null;
        }

        @Override
        protected void onPreExecute() {
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
            textProgress.setText(values[0] + " %");
        }
    }

     public void startService(View view) {
        startService(new Intent(this, MyLifeCycleService.class));
     }

     public void stopService(View viev) {
        stopService(new Intent(this,MyLifeCycleService.class));
     }
}
