package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Pagination {

    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("count")
    private int count;
    @SerializedName("offset")
    private int offset;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(final int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(final int offset) {
        this.offset = offset;
    }
}
