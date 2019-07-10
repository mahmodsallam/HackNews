package com.mahmoud.mostafa.hacknews.ui.main;

import java.util.ArrayList;

public interface MainMvpView {

    void showError(String error);

    void setupListView(ArrayList<String> ids);
}
