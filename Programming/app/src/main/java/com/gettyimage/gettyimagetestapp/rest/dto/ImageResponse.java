package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ImageResponse {

    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;
    @SerializedName("size")
    private String size;
    @SerializedName("frames")
    private String frames;

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(final String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(final String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(final String size) {
        this.size = size;
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(final String frames) {
        this.frames = frames;
    }
}
