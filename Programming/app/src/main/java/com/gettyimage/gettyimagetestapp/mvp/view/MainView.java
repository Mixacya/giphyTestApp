package com.gettyimage.gettyimagetestapp.mvp.view;

import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpView;
import com.gettyimage.gettyimagetestapp.db.dao.SearchHistory;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.rest.dto.SearchImagesResponse;

import java.util.List;

public interface MainView extends MvpView {

    void showImageList(@Nullable final List<Data> dataList);
    void showHistoryList(@Nullable final List<SearchHistory> searchHistoryList);

    void showLoading();
    void hideLoading();

}
