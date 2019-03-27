package com.example.mobileproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance
{

    private static Retrofit retrofit;
    private static final String BREACHES_URL = "https://haveibeenpwned.com/api/v2/breaches";

    public static Retrofit getRetrofitInstance()
    {
        if (retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BREACHES_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;


    }
}
