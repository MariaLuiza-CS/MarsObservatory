package com.example.myapplication.data.source.remote;

import com.example.myapplication.data.source.remote.response.photo.PhotoResponseComplete;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaService {
    @GET("api/v1/rovers/curiosity/photos?sol=1000&camera=mast&")
    Call<PhotoResponseComplete> getMarsValues(@Query("api_key") String apiKey);
}
