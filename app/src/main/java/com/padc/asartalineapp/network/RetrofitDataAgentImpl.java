package com.padc.asartalineapp.network;

import com.padc.asartalineapp.events.ApiErrorEvent;
import com.padc.asartalineapp.events.SuccessGetWarDeeEvent;
import com.padc.asartalineapp.events.SuccessSearchWarDeeEvent;
import com.padc.asartalineapp.network.responses.GetWarDeeResponse;
import com.padc.asartalineapp.network.responses.SearchWarDeeResponse;
import com.padc.asartalineapp.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class RetrofitDataAgentImpl implements AsarTalineDataAgent {

    private static RetrofitDataAgentImpl objectReference;

    private AsarTalineApi mTheApi;

    private final String API_EMPTY_ERROR = "Empty in response body!";


    private RetrofitDataAgentImpl() {

        final OkHttpClient mOkHttpClinet = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClinet)
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mTheApi = retrofit.create(AsarTalineApi.class);

    }

    public static RetrofitDataAgentImpl getObjectReference() {

        if (objectReference == null) {
            objectReference = new RetrofitDataAgentImpl();
        }
        return objectReference;
    }


    @Override
    public void loadWarDee(String accessToken) {

        Call<GetWarDeeResponse> warDeeApiCall = mTheApi.loadWarTee(accessToken);
        warDeeApiCall.enqueue(new Callback<GetWarDeeResponse>() {
            @Override
            public void onResponse(Call<GetWarDeeResponse> call, Response<GetWarDeeResponse> response) {
                GetWarDeeResponse getWarDeeResponse = response.body();
                if (getWarDeeResponse != null && getWarDeeResponse.isResponseOK()) {
                    SuccessGetWarDeeEvent event = new SuccessGetWarDeeEvent(getWarDeeResponse.getAstlWarDee());
                    EventBus.getDefault().post(event);
                } else {

                    if (getWarDeeResponse == null) {

                        ApiErrorEvent event = new ApiErrorEvent(API_EMPTY_ERROR);
                        EventBus.getDefault().post(event);

                    } else {

                        ApiErrorEvent event = new ApiErrorEvent(getWarDeeResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetWarDeeResponse> call, Throwable t) {

                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);

            }
        });
    }

    @Override
    public void searchWarDee(String accessToken
            , String tasteType, String suited
            , int minPrice, int maxPrice
            , boolean isNearBy, String currentTownship
            , String currentLat, String currentLng) {

        Call<SearchWarDeeResponse> searchWarDeeApiCall = mTheApi.searchWarDee(accessToken, tasteType
                , suited, minPrice, maxPrice
                , isNearBy, currentTownship
                , currentLat, currentLng);

        searchWarDeeApiCall.enqueue(new Callback<SearchWarDeeResponse>() {
            @Override
            public void onResponse(Call<SearchWarDeeResponse> call, Response<SearchWarDeeResponse> response) {
                SearchWarDeeResponse searchWarDeeResponse = response.body();
                if (searchWarDeeResponse != null && searchWarDeeResponse.isResponseOK()) {

                    SuccessSearchWarDeeEvent event = new SuccessSearchWarDeeEvent(searchWarDeeResponse.getSearchResults()
                            , searchWarDeeResponse.getMinPrice()
                            , searchWarDeeResponse.getMaxPrice());
                    EventBus.getDefault().post(event);
                } else {
                    if (searchWarDeeResponse == null) {

                        ApiErrorEvent errorEvent = new ApiErrorEvent("Empty in Response!");
                        EventBus.getDefault().post(errorEvent);

                    } else {
                        ApiErrorEvent errorEvent = new ApiErrorEvent(searchWarDeeResponse.getMessage());
                        EventBus.getDefault().post(errorEvent);
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchWarDeeResponse> call, Throwable t) {

                ApiErrorEvent errorEvent = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);

            }
        });

    }
}
