package com.gettyimage.gettyimagetestapp.ui.viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gettyimage.gettyimagetestapp.R;
import com.gettyimage.gettyimagetestapp.db.dao.GifInfo;
import com.gettyimage.gettyimagetestapp.db.dao.SearchHistory;
import com.gettyimage.gettyimagetestapp.rest.dto.Data;
import com.gettyimage.gettyimagetestapp.rest.dto.ImageObject;
import com.gettyimage.gettyimagetestapp.ui.GlideHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_gif)
    ImageView ivGif;

    public HistoryViewHolder(@NonNull final View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindImageObject(final SearchHistory data) {
        tvTitle.setText(data != null ? data.getSearchWord() : "-");
        final String url = data != null ? data.getInfo().getUrl() : null;


        final Context context = ivGif.getContext();
        Glide.with(context)
                .applyDefaultRequestOptions(GlideHelper.getDefaultOptions(context))
                .asGif()
                .load(url)
                .into(ivGif);
    }
}
