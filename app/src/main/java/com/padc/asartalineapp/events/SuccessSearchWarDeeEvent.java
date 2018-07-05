package com.padc.asartalineapp.events;

import com.padc.asartalineapp.data.vos.WarDeeVO;

import java.util.List;

/**
 * Created by Phyo Thiha on 7/5/18.
 */
public class SuccessSearchWarDeeEvent {

    private List<WarDeeVO> mWarDeeList;

    private int minPrice, maxPrice;

    public SuccessSearchWarDeeEvent(List<WarDeeVO> mWarDeeList, int minPrice, int maxPrice) {
        this.mWarDeeList = mWarDeeList;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public List<WarDeeVO> getmWarDeeList() {
        return mWarDeeList;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }
}
