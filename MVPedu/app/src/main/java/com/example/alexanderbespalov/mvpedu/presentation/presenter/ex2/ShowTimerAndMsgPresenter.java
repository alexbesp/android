package com.example.alexanderbespalov.mvpedu.presentation.presenter.ex2;


import android.os.AsyncTask;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex2.ShowTimerAndMsgView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

@InjectViewState
public class ShowTimerAndMsgPresenter extends MvpPresenter<ShowTimerAndMsgView> {
    public ShowTimerAndMsgPresenter() {
        AsyncTask<Void, Integer, Void> asyncTask = new AsyncTask<Void, Integer, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                for (int i = 5; i > 0; i--) {
                    publishProgress(i);
                    sleepSecond();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                getViewState().setTimer(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().hideTimer();
                getViewState().showMessage(R.string.hello_world);
            }

            private void sleepSecond() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        asyncTask.execute();
    }
}
