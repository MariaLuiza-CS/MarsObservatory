package com.example.myapplication.data.source.remote.response.photo;

import com.example.myapplication.data.source.remote.response.camera.CameraResponse;
import com.example.myapplication.data.source.remote.response.rover.RoverResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoResponse {

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("sol")
    private int sol;

    @Expose
    @SerializedName("img_src")
    private String img_src;

    @Expose
    @SerializedName("earth_date")
    private String earth_date;

    @Expose
    @SerializedName("camera")
    private CameraResponse cameraResponse;

    @Expose
    @SerializedName("rover")
    private RoverResponse roverResponse;

    public PhotoResponse(int id, int sol, CameraResponse cameraResponse, RoverResponse roverResponse, String img_src, String earth_date) {
        this.id = id;
        this.sol = sol;
        this.cameraResponse = cameraResponse;
        this.roverResponse = roverResponse;
        this.img_src = img_src;
        this.earth_date = earth_date;
    }

    public int getId() {
        return id;
    }

    public int getSol() {
        return sol;
    }

    public CameraResponse getCameraResponse() {
        return cameraResponse;
    }

    public RoverResponse getRoverResponse() {
        return roverResponse;
    }

    public String getImg_src() {
        return img_src;
    }

    public String getEarth_date() {
        return earth_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSol(int sol) {
        this.sol = sol;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }

    public void setCameraResponse(CameraResponse cameraResponse) {
        this.cameraResponse = cameraResponse;
    }

    public void setRoverResponse(RoverResponse roverResponse) {
        this.roverResponse = roverResponse;
    }

}
