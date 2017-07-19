package com.example.alexanderbespalov.mvpedu.ui.activity.main;

import android.app.Application;
import android.content.Context;

import com.example.alexanderbespalov.mvpedu.api.UmoriliApi;
import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexander.bespalov on 28.06.2017.
 */

public class MyApp extends Application {

    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;
    private Gson gson;

    private static Context context;



    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

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

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://umorili.herokuapp.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class);
    }

    public static UmoriliApi getApi() {
        return  umoriliApi;
    }

    public static Context getContext() {
        return context;
    }
}
