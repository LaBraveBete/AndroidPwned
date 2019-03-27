package com.example.mobileproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public class EndPoint {

    public interface GetDataService {

        @GET("/photos")
        Call<List<DataModel>> getAllPhotos();
    }
}
