package com.example.mobileproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService
    {

            @GET("photos")//breaches
            Call<List<DataModel>> getAllBreaches();


    }
