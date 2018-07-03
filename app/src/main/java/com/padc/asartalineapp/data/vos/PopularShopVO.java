package com.padc.asartalineapp.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class PopularShopVO {

    @SerializedName("shopByPopularityId")
    private String shopByDistanceId;
    @SerializedName("mealShop")
    private MealShopVO mealShop;

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }
}
