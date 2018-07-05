package com.padc.asartalineapp.delegates;

import com.padc.asartalineapp.data.vos.WarDeeVO;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public interface DashboardDelegate {

    void onTapWarTeeItem(WarDeeVO warDee);

    void onSearch(String query);

    void onTapCategory(String category);

}
