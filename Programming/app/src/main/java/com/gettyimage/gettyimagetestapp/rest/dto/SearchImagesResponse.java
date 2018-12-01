package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SearchImagesResponse {

    @SerializedName("data")
    private List<Data> data;
    @SerializedName("pagination")
    private Pagination pagination;
    @SerializedName("meta")
    private Meta meta;

    public List<Data> getData() {
        return data;
    }

    public void setData(final List<Data> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(final Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(final Meta meta) {
        this.meta = meta;
    }
}
