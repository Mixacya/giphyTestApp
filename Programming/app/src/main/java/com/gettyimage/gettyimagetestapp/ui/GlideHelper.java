package com.gettyimage.gettyimagetestapp.ui;

import android.content.Context;

import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.gettyimage.gettyimagetestapp.R;

public final class GlideHelper {

    private static RequestOptions requestOptions;

    public static RequestOptions getDefaultOptions(final Context context) {
        if (requestOptions == null) {
            requestOptions = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .priority(Priority.HIGH);
        }
        return requestOptions;
    }

}
