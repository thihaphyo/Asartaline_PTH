package com.padc.asartalineapp.events;

import com.padc.asartalineapp.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class SuccessGetWarDeeEvent {

    private List<WarDeeVO> mWarDeeList;

    public SuccessGetWarDeeEvent(List<WarDeeVO> mWarDeeList) {
        this.mWarDeeList = mWarDeeList;
    }

    public List<WarDeeVO> getmWarDeeList() {
        return mWarDeeList;
    }
}
