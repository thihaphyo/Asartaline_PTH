package com.padc.asartalineapp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.asartalineapp.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/5/18.
 */
abstract public class BaseResponse {

    @SerializedName("code")
    protected int code;
    @SerializedName("message")
    protected String message;
    @SerializedName("apiVersion")
    protected String apiVersion;

    abstract public boolean isResponseOK();


}
