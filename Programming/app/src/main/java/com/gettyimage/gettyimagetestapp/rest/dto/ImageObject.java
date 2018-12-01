package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ImageObject {

    @SerializedName("original")
    private ImageResponse original;

    public ImageResponse getOriginal() {
        return original;
    }

    public void setOriginal(final ImageResponse original) {
        this.original = original;
    }
}
