package com.example.myapplication.data.model;

import com.example.myapplication.data.source.remote.response.camera.CameraResponse;
import com.example.myapplication.data.source.remote.response.rover.RoverResponse;

public class MarsData {

    private final String earthDate;
    private final String imgCamera;
    private final CameraResponse cameraResponse;
    private final RoverResponse roverResponse;

    public MarsData(String earthDate, String imgCamera, CameraResponse cameraResponse, RoverResponse roverResponse) {
        this.earthDate = earthDate;
        this.imgCamera = imgCamera;
        this.cameraResponse = cameraResponse;
        this.roverResponse = roverResponse;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public String getImgCamera() {
        return imgCamera;
    }

    public CameraResponse getCameraResponse() {
        return cameraResponse;
    }

    public RoverResponse getRoverResponse() {
        return roverResponse;
    }

}
