package com.gettyimage.gettyimagetestapp.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.gettyimage.gettyimagetestapp.mvp.model.MainModel;
import com.gettyimage.gettyimagetestapp.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private MainModel model;

    public MainPresenter() {
        model = new MainModel(this);
    }

    public void searchGif(final String search) {
        getViewState().showLoading();
        model.getResponse(search);

    }

    public void historyShow() {
        model.showHistory();
    }

    public void hideLoading() {
        getViewState().hideLoading();
    }

}
