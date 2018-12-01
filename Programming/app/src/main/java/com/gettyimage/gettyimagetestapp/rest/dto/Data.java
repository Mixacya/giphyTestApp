package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Data {

    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("url")
    private String url;
    @SerializedName("title")
    private String title;
    @SerializedName("images")
    private ImageObject image;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public ImageObject getImage() {
        return image;
    }

    public void setImage(final ImageObject image) {
        this.image = image;
    }
}
