package com.example.alexanderbespalov.mynewapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by alexander.bespalov on 24.10.2016.
 */
public class MyLifeCycleService extends Service {

    private static final String TAG = "MyLifeCycleServiceTag";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Сервис начал создание - onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Сервис начинает запуск - onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Сервис уничтожается - onDestroy()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }


}
