package com.gettyimage.gettyimagetestapp.mvp.model;

import com.gettyimage.gettyimagetestapp.BuildConfig;
import com.gettyimage.gettyimagetestapp.db.DBManager;
import com.gettyimage.gettyimagetestapp.mvp.presenter.MainPresenter;
import com.gettyimage.gettyimagetestapp.rest.ApiManager;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.rest.dto.SearchImagesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainModel {

    private ApiManager apiManager = ApiManager.getInstance();
    private DBManager dbManager = DBManager.getInstance();

    private SearchImagesResponse searchResponse;
    private final MainPresenter presenter;

    public MainModel(final MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void getResponse(final String search) {

        apiManager.getGettyImageApi().searchImages(BuildConfig.GIPHY_API_KEY, search).enqueue(
            new Callback<SearchImagesResponse>() {
                @Override
                public void onResponse(final Call<SearchImagesResponse> call,
                                       final Response<SearchImagesResponse> response) {
                    searchResponse = response.body();
                    saveData(search);
                    presenter.getViewState().showImageList(searchResponse.getData());
                    presenter.hideLoading();
                }

                @Override
                public void onFailure(final Call<SearchImagesResponse> call, final Throwable t) {
                    presenter.hideLoading();
                }
            });
    }

    public void showHistory() {
        presenter.getViewState().showHistoryList(dbManager.getHistoryList());
    }

    private void saveData(final String search) {
        if (searchResponse != null) {
            final List<Data> dataList = searchResponse.getData();
            if (dataList != null && !dataList.isEmpty()) {
                dbManager.saveGif(dataList.get(0), search);
            }
        }
    }

}
