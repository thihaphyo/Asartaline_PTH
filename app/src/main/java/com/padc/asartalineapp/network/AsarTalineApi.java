package com.padc.asartalineapp.network;

import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.network.responses.GetWarDeeResponse;
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
}
