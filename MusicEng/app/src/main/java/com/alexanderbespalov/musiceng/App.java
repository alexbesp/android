package com.alexanderbespalov.musiceng;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alexander.bespalov on 14.07.2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("MusicDb")
                .build();
        Realm.setDefaultConfiguration(config);
    }
}
