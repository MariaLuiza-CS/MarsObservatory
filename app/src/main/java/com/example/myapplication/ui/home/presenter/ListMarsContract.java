package com.example.myapplication.ui.home.presenter;

import com.example.myapplication.data.model.MarsData;

import java.util.List;

public interface ListMarsContract {

    interface ListMarsView {

        void showMarsInformation(List<MarsData> marsData);

        void showApiError();
    }

    interface ListMarsPresenter {

        void getMarsInformation();

        void destroyView();
    }
}
