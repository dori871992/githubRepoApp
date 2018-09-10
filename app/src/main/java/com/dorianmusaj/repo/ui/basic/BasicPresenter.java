package com.dorianmusaj.repo.ui.basic;

public class BasicPresenter implements MvpBasicPresenter {

    private MvpBasicView basicView;

    public BasicPresenter(MvpBasicView basicView) {
        this.basicView = basicView;
    }

    @Override
    public void onAttach(MvpBasicView mvpView) {
        basicView = mvpView;
    }

    @Override
    public void onDetach() {
        basicView = null;
    }

    @Override
    public void handleApiError(String error) {

    }


}
