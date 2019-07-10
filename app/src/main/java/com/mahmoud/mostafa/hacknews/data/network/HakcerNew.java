package com.mahmoud.mostafa.hacknews.data.network;

import com.google.gson.JsonArray;
import com.mahmoud.mostafa.hacknews.data.pojos.Story;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;

public class HakcerNew implements HackerNewsApi {

    HackerNewsApi hackerNewsApi;

    public HakcerNew() {
        Retrofit instance = RetrofitInstance.getInstance();
        hackerNewsApi = instance.create(HackerNewsApi.class);

    }

    @Override
    public Call<JsonArray> getStoriesIds() {
        return hackerNewsApi.getStoriesIds();
    }

    @Override
    public Observable<Story> getStoryDetails(String id) {
        return hackerNewsApi.getStoryDetails(id);
    }
}
