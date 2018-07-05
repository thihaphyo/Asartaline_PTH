package com.padc.asartalineapp.network;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public interface AsarTalineDataAgent {

    void loadWarDee(String accessToken);

    void searchWarDee(String accessToken
            , String tasteType
            , String suited
            , int minPrice
            , int maxPrice
            , boolean isNearBy
            , String currentTownship
            , String currentLat
            , String currentLng);
}
