package com.example.alexanderbespalov.mvpedu.presentation.presenter.ex1;



import android.os.AsyncTask;

import com.example.alexanderbespalov.mvpedu.R;
import com.example.alexanderbespalov.mvpedu.presentation.view.ex1.ShowMsgView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

@InjectViewState
public class ShowMsgPresenter extends MvpPresenter<ShowMsgView> {
    public ShowMsgPresenter() {
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                sleepSecond();
                return null;
            }

            private void sleepSecond() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ignore) {
                }
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                getViewState().showMessage(R.string.hello_world);
            }
        };
        asyncTask.execute();
    }
}
