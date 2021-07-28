package com.example.myapplication.data.source.remote.mapper;

import com.example.myapplication.data.model.MarsData;
import com.example.myapplication.data.source.remote.response.photo.PhotoResponse;

import java.util.ArrayList;
import java.util.List;

public class MarsMapper {

    public static List<MarsData> fromResponseToModel(List<PhotoResponse> photoResponseList) {
        List<MarsData> marsDataList = new ArrayList<>();

        for (PhotoResponse photoResponse : photoResponseList) {
            final MarsData marsData = new MarsData(
                    photoResponse.getEarth_date(),
                    photoResponse.getImg_src(),
                    photoResponse.getCameraResponse(),
                    photoResponse.getRoverResponse());
            marsDataList.add(marsData);
        }
        return marsDataList;
    }
}
