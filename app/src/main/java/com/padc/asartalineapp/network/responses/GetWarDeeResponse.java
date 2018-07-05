package com.padc.asartalineapp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.asartalineapp.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class GetWarDeeResponse extends BaseResponse {


    @SerializedName("astlWarDee")
    private List<WarDeeVO> astlWarDee;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<WarDeeVO> getAstlWarDee() {
        return astlWarDee;
    }

    @Override
    public boolean isResponseOK() {

        return code == 200 && astlWarDee.size() > 0;
    }
}
