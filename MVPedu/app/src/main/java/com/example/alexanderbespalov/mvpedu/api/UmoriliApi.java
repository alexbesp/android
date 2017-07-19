package com.example.alexanderbespalov.mvpedu.api;

import com.example.alexanderbespalov.mvpedu.model.bashOrg.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexander.bespalov on 05.07.2017.
 */

public interface UmoriliApi {
    @GET("api/get") Call<List<PostModel>> getData(@Query("name") String resourseName, @Query("num") int count);
}
