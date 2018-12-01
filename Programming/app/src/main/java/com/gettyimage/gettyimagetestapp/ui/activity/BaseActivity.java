package com.gettyimage.gettyimagetestapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        onViewCreated();
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract void onViewCreated();

    public void hideKeyboard(View view) {
        InputMethodManager imm =
                (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
