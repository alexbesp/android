package com.example.alexanderbespalov.bashapp.util;

import com.example.alexanderbespalov.bashapp.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexander.bespalov on 30.06.2017.
 */

public interface UmoriliApi {
    @GET("api/get") Call<List<PostModel>> getData(@Query("name") String resourseName, @Query("num") int count);
}
