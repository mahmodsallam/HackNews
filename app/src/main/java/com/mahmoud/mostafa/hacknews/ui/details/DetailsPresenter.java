package com.mahmoud.mostafa.hacknews.ui.details;

import com.mahmoud.mostafa.hacknews.data.network.HakcerNew;
import com.mahmoud.mostafa.hacknews.data.pojos.Story;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailMvpPresenter {
    DetailMvpView detailMvpView;
    HakcerNew hackerNewsApi;


    public DetailsPresenter(DetailMvpView detailMvpView) {
        this.detailMvpView = detailMvpView;
        hackerNewsApi = new HakcerNew();
    }

    @Override
    public void getStoryDetails(String id) {
        hackerNewsApi.getStoryDetails(id).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                new Consumer<Story>() {
                    @Override
                    public void accept(Story story) throws Exception {
                        detailMvpView.setUpTitle(story.getTitle());
                        detailMvpView.setupWebView(story.getUrl());

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        detailMvpView.showErrorMessage(throwable.getMessage());
                    }
                }

        );


    }
}
