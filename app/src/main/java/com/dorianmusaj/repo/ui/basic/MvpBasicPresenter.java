package com.dorianmusaj.repo.ui.basic;

public interface MvpBasicPresenter {

    void onAttach(MvpBasicView mvpView);

    void onDetach();

    void handleApiError(String error);


}
