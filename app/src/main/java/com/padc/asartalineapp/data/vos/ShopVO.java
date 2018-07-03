package com.padc.asartalineapp.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class ShopVO {

    @SerializedName("shopByDistanceId")
    private String shopByDistanceId;
    @SerializedName("mealShop")
    private MealShopVO mealShop;
    @SerializedName("distanceInFeet")
    private double distanceInFeet;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public double getDistanceInFeet() {
        return distanceInFeet;
    }
}