package com.example.myapplication.data.source.remote.response.rover;

import com.google.gson.annotations.*;

public class RoverResponse {

    @Expose
    @SerializedName("id")
    private final int id;

    @Expose
    @SerializedName("name")
    private final String name;

    @Expose
    @SerializedName("landing_date")
    private final String landing_date;

    @Expose
    @SerializedName("launch_date")
    private final String launch_date;

    @Expose
    @SerializedName("status")
    private final String status;

    public RoverResponse(int id, String name, String landing_date, String launch_date, String status) {
        this.id = id;
        this.name = name;
        this.landing_date = landing_date;
        this.launch_date = launch_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public String getStatus() {
        return status;
    }

}
