package com.example.myapplication.data.source.remote.response.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoResponseComplete {

    @Expose
    @SerializedName("photos")
    private final List<PhotoResponse> photosList;

    public PhotoResponseComplete(List<PhotoResponse> photosList) {
        this.photosList = photosList;
    }

    public List<PhotoResponse> getPhotosList() {
        return photosList;
    }

}
