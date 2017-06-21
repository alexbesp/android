package com.example.alexanderbespalov.mynewapp.asyncTask;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyNewAsyncTask extends AsyncTask<Void, Void, Void> {

    private static MyNewAsyncTask instance;
    private static Context context;

    public static MyNewAsyncTask getInstance(Context context) {
        if (instance == null) {
            instance = new MyNewAsyncTask();
            instance.execute();
        }
        setContext(context);
        return instance;
    }

    private void printInfo() {
        Log.i("[DEV_MODE]", "CODE: " + this.hashCode() + " | " + context.hashCode());
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            for (int i = 0; i <= 5; i++) {
                Log.i("[MY_TASK]", "Task is working...");
                if (isCancelled()) {
                    return null;
                }

                TimeUnit.SECONDS.sleep(2);
                printInfo();
            }
        } catch (InterruptedException e) {
             e.printStackTrace();
        }


        return null;
    }

    public static void setContext(Context context) {
        MyNewAsyncTask.context = context;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        instance = null;
    }
}
