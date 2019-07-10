package com.mahmoud.mostafa.hacknews.data.network;

import com.google.gson.JsonArray;
import com.mahmoud.mostafa.hacknews.data.pojos.Story;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HackerNewsApi {
    @GET("topstories.json?print=pretty")
    Call<JsonArray> getStoriesIds();

    @GET("item/{id}.json?print=pretty")
    Observable<Story> getStoryDetails(@Path("id") String id);

}
