package com.example.alexanderbespalov.mvpedu.ui.activity.main;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alexander.bespalov on 28.06.2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Stetho.initializeWithDefaults(this);
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .schemaVersion(2) // Must be bumped when the schema changes
//                .migration(new MyMigration()) // Migration to run instead of throwing an exception
//                .build();
//        Realm.setDefaultConfiguration(config);
        Realm.init(this);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
    }
}
