package com.padc.asartalineapp.data.models;

import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.events.SuccessGetWarDeeEvent;
import com.padc.asartalineapp.network.AsarTalineDataAgent;
import com.padc.asartalineapp.network.RetrofitDataAgentImpl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class WarteeModel {

    private static WarteeModel objectReference;

    private AsarTalineDataAgent mDataAgent;

    private static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private Map<String, WarDeeVO> mDatarepo;

    private WarteeModel() {

        mDataAgent = RetrofitDataAgentImpl.getObjectReference();
        mDatarepo = new HashMap<>();
        EventBus.getDefault().register(this);

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

    public WarDeeVO getWarDeeById(String warDeeId) {
        return mDatarepo.get(warDeeId);
    }

    private void setDataRepo(List<WarDeeVO> warDeeList) {

        for (WarDeeVO warDeeVO : warDeeList) {
            mDatarepo.put(warDeeVO.getWarDeeId(), warDeeVO);
        }
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessWarDee(SuccessGetWarDeeEvent successGetWarDeeEvent) {

        setDataRepo(successGetWarDeeEvent.getmWarDeeList());

    }


}
