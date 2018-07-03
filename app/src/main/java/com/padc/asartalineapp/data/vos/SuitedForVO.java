package com.padc.asartalineapp.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class SuitedForVO {

    @SerializedName("suitedForId")
    private String suitedForId;
    @SerializedName("suitedFor")
    private String suitedFor;
    @SerializedName("suitedForDesc")
    private String suitedForDesc;

    public String getSuitedForId() {
        return suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }
}
