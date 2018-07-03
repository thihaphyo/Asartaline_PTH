package com.padc.asartalineapp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class WarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste;
    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;
    @SerializedName("priceRangeMin")
    private int priceRangeMin;
    @SerializedName("priceRangeMax")
    private int priceRangeMax;
    @SerializedName("matchWarDeeList")
    private List<MatchWarDeeVO> matchWarDeeList;
    @SerializedName("shopByDistance")
    private List<ShopVO> shopByDistance;
    @SerializedName("shopByPopularitys")
    private List<PopularShopVO> shopByPopularity;


    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<MatchWarDeeVO> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public List<ShopVO> getShopByDistance() {
        return shopByDistance;
    }

    public List<PopularShopVO> getShopByPopularity() {
        return shopByPopularity;
    }
}
