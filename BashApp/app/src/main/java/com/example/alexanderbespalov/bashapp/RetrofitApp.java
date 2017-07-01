package com.example.alexanderbespalov.bashapp;

import android.app.Application;

import com.example.alexanderbespalov.bashapp.util.UmoriliApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexander.bespalov on 30.06.2017.
 */

public class RetrofitApp extends Application {
    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;
    private Gson gson;
    @Override
    public void onCreate() {
        super.onCreate();
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
}
