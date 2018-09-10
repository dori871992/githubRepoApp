package com.dorianmusaj.repo.ui.basic;

public interface MvpBasicView {

    void loadingStarted();
    void loadingFinished(String error);
    boolean isNetworkConnected();
}
