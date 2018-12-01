package com.gettyimage.gettyimagetestapp.rest;

import com.gettyimage.gettyimagetestapp.rest.dto.SearchImagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GettyImageApi {

    @GET(" /v1/gifs/search")
    Call<SearchImagesResponse> searchImages(@Query("api_key") String apiKey,
                                            @Query("q") String searchName);

}
