package com.padc.asartalineapp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.asartalineapp.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/5/18.
 */
public class SearchWarDeeResponse extends BaseResponse {

    @SerializedName("tasteType")
    private String tasteType;
    @SerializedName("suited")
    private String suited;
    @SerializedName("minPrice")
    private int minPrice;
    @SerializedName("maxPrice")
    private int maxPrice;
    @SerializedName("isNearBy")
    private String isNearBy;
    @SerializedName("currentTownship")
    private String currentTownship;
    @SerializedName("currentTLat")
    private String currentTLat;
    @SerializedName("currentLng")
    private String currentLng;
    @SerializedName("searchResults")
    private List<WarDeeVO> searchResults;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getTasteType() {
        return tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public String getIsNearBy() {
        return isNearBy;
    }

    public String getCurrentTownship() {
        return currentTownship;
    }

    public String getCurrentTLat() {
        return currentTLat;
    }

    public String getCurrentLng() {
        return currentLng;
    }

    public List<WarDeeVO> getSearchResults() {
        return searchResults;
    }

    @Override
    public boolean isResponseOK() {
        return code == 200 && searchResults.size() > 0;
    }
}
