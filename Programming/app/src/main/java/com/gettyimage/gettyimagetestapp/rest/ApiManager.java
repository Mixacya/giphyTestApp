package com.gettyimage.gettyimagetestapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    public static class SingletonHolder {
        private static final ApiManager instance = new ApiManager();
    }

    private static final String BASE_URL = "https://api.giphy.com";

    private Retrofit retrofit;
    private GettyImageApi gettyImageApi;

    private ApiManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiManager getInstance() {
        return SingletonHolder.instance;
    }

    public GettyImageApi getGettyImageApi() {
        if (gettyImageApi == null) {
            gettyImageApi = retrofit.create(GettyImageApi.class);
        }
        return gettyImageApi;
    }

}
