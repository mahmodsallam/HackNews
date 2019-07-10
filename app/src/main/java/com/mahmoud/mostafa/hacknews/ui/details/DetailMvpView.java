package com.mahmoud.mostafa.hacknews.ui.details;

public interface DetailMvpView {
    void setupWebView(String url);

    void setUpTitle(String title);
    void showErrorMessage (String message ) ;
}