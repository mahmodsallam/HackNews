package com.mahmoud.mostafa.hacknews.ui.main;

import com.google.gson.JsonArray;
import com.mahmoud.mostafa.hacknews.data.network.HakcerNew;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainMvpPresenter {

    MainMvpView mainMvpView;
    HakcerNew hackerNewsApi;

    public MainPresenter(MainMvpView mainMvpView) {
        this.mainMvpView = mainMvpView;
        hackerNewsApi = new HakcerNew();

    }

    @Override
    public void getStoriesIds() {
        hackerNewsApi.getStoriesIds().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                JsonArray result = response.body();
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < result.size(); i++) {
                    list.add(result.get(i).toString());
                }
                mainMvpView.setupListView(list);
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                mainMvpView.showError(t.getMessage());
            }
        });

    }
}
