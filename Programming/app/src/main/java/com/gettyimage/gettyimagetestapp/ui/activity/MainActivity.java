package com.gettyimage.gettyimagetestapp.ui.activity;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.gettyimage.gettyimagetestapp.R;
import com.gettyimage.gettyimagetestapp.db.dao.SearchHistory;
import com.gettyimage.gettyimagetestapp.mvp.presenter.MainPresenter;
import com.gettyimage.gettyimagetestapp.mvp.view.MainView;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.rest.dto.SearchImagesResponse;
import com.gettyimage.gettyimagetestapp.ui.activity.BaseActivity;
import com.gettyimage.gettyimagetestapp.ui.adapter.GifAdapter;
import com.gettyimage.gettyimagetestapp.ui.adapter.HistoryAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.rv_items)
    RecyclerView rvItems;
    @BindView(R.id.loading)
    ConstraintLayout loading;

    @InjectPresenter
    MainPresenter presenter;

    private GifAdapter adapter;
    private List<Data> data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewCreated() {
        data = new ArrayList<>();
        adapter = new GifAdapter(data);
        rvItems.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.historyShow();
//        rvItems.setAdapter(adapter);
        etSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);
        etSearch.setSingleLine();
        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                final String search = etSearch.getText().toString().trim();
                if (search != null && !search.isEmpty()) {
                    presenter.searchGif(search);
                }
                hideKeyboard(etSearch);
                return true;
            }
            return false;
        });
    }

    @Override
    public void showImageList(@Nullable final List<Data> dataList) {
        this.data.clear();
        if (dataList != null) {
            data.addAll(dataList);
        }
        rvItems.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showHistoryList(@Nullable final List<SearchHistory> searchHistoryList) {
        HistoryAdapter adapter = new HistoryAdapter(searchHistoryList);
        rvItems.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.GONE);
    }
}
