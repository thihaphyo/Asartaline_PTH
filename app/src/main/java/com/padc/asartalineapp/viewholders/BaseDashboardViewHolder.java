package com.padc.asartalineapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padc.asartalineapp.data.vos.WarDeeVO;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public abstract class BaseDashboardViewHolder extends RecyclerView.ViewHolder {

    public BaseDashboardViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(WarDeeVO warDeeVO){



    }
}
