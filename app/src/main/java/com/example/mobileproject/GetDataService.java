package com.example.mobileproject;

import com.example.mobileproject.Model.DataBreachesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService
    {

            @GET("breaches")//breaches
            Call<List<DataBreachesModel>> getAllBreaches();


    }
