package com.example.myapplication.data.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiService {
    private static NasaService INSTANCE;

    public static NasaService getInstance() {
        if (INSTANCE == null) {

            String baseUrl = "https://api.nasa.gov/mars-photos/";

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            INSTANCE = retrofit.create(NasaService.class);
        }
        return INSTANCE;
    }
}
