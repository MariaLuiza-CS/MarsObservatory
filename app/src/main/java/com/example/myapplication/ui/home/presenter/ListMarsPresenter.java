package com.example.myapplication.ui.home.presenter;

import com.example.myapplication.data.model.MarsData;
import com.example.myapplication.data.source.remote.ApiService;
import com.example.myapplication.data.source.remote.mapper.MarsMapper;
import com.example.myapplication.data.source.remote.response.photo.PhotoResponseComplete;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMarsPresenter implements ListMarsContract.ListMarsPresenter {
    private ListMarsContract.ListMarsView view;

    public ListMarsPresenter(ListMarsContract.ListMarsView view ){
        this.view = view;
    }

    @Override
    public void getMarsInformation() {
        ApiService.getInstance()
                .getMarsValues("sSA5U2cRcre7n2wA0DvRN4f0CShWNKTvAC6PrlQi")
                .enqueue(new Callback<PhotoResponseComplete>() {
                    @Override
                    public void onResponse(Call<PhotoResponseComplete> call, Response<PhotoResponseComplete> response) {
                        if (response.isSuccessful()) {
                            final List<MarsData> marsDataList =
                                    MarsMapper.fromResponseToModel(response.body().getPhotosList());
                            view.showMarsInformation(marsDataList);
                        } else {
                            view.showApiError();
                        }
                    }

                    @Override
                    public void onFailure(Call<PhotoResponseComplete> call, Throwable t) {

                        view.showApiError();
                    }
                });
    }

    @Override
    public void destroyView() {
        this.view = null;
    }
}
