package com.padc.asartalineapp.data.models;

import com.padc.asartalineapp.network.AsarTalineDataAgent;
import com.padc.asartalineapp.network.RetrofitDataAgentImpl;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class WarteeModel {

    private static WarteeModel objectReference;

    private AsarTalineDataAgent mDataAgent;

    private static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private WarteeModel() {

        mDataAgent = RetrofitDataAgentImpl.getObjectReference();

    }

    public static WarteeModel getObjectReference() {

        if (objectReference == null) {
            objectReference = new WarteeModel();
        }
        return objectReference;
    }

    public void loadWarTeeList() {

        mDataAgent.loadWarDee(ACCESS_TOKEN);

    }
}
