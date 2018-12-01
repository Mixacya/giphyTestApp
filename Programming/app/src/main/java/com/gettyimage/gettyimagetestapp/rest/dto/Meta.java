package com.gettyimage.gettyimagetestapp.rest.dto;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Meta {

    @SerializedName("status")
    private int status;
    @SerializedName("msg")
    private String msg;
    @SerializedName("response_id")
    private String responseId;

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(final String responseId) {
        this.responseId = responseId;
    }
}
