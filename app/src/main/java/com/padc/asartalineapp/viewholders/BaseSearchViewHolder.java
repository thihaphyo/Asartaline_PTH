package com.padc.asartalineapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padc.asartalineapp.data.vos.WarDeeVO;

/**
 * Created by Phyo Thiha on 7/6/18.
 */
public abstract class BaseSearchViewHolder extends RecyclerView.ViewHolder {

    public BaseSearchViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(WarDeeVO warDee) {
    }

    public void bindData(int size,int min,int max){

    }
}
