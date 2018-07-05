package com.padc.asartalineapp.network;

import com.padc.asartalineapp.network.responses.GetWarDeeResponse;
import com.padc.asartalineapp.network.responses.SearchWarDeeResponse;
import com.padc.asartalineapp.utils.AppConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public interface AsarTalineApi {

    @FormUrlEncoded
    @POST(AppConstants.API_GET_WARTEE)
    Call<GetWarDeeResponse> loadWarTee(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken
    );

    @FormUrlEncoded
    @POST(AppConstants.API_SEARCH_WARDEE)
    Call<SearchWarDeeResponse> searchWarDee(
            @Field(AppConstants.PARAM_ACCESS_TOKEN) String accessToken,
            @Field(AppConstants.PARAM_TASTE_TYPE) String tasteType,
            @Field(AppConstants.PARAM_SUITED) String suited,
            @Field(AppConstants.PARAM_MIN_PRICE) int minPrice,
            @Field(AppConstants.PARAM_MAX_PRICE) int maxPrice,
            @Field(AppConstants.PARAM_IS_NEARBY) boolean isNearBy,
            @Field(AppConstants.PARAM_CURRENT_TOWNSHIP) String currentTownship,
            @Field(AppConstants.PARAM_CURRENT_LAT) String currentLat,
            @Field(AppConstants.PARAM_CURRENT_LNG) String currentLng
    );
}
