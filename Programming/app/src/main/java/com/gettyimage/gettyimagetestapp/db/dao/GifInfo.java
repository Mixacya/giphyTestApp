package com.gettyimage.gettyimagetestapp.db.dao;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GifInfo extends RealmObject {

    @PrimaryKey
    private long realmId;
    private String title;
    private String url;
    private String type;
    private String width;
    private String height;
    private String size;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
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
}
