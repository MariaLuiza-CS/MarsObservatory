package com.example.myapplication.data.source.remote.response.camera;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CameraResponse {

    @Expose
    @SerializedName("id")
    private final int id;

    @Expose
    @SerializedName("name")
    private final String name;

    @Expose
    @SerializedName("rover_id")
    private final int rover_id;

    @Expose
    @SerializedName("full_name")
    private final String full_name;

    public CameraResponse(int id, String name, int rover_id, String full_name) {
        this.id = id;
        this.name = name;
        this.rover_id = rover_id;
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRover_id() {
        return rover_id;
    }

    public String getFull_name() {
        return full_name;
    }

}
