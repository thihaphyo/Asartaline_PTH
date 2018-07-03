package com.padc.asartalineapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.delegates.DashboardDelegate;
import com.padc.asartalineapp.viewholders.BaseDashboardViewHolder;
import com.padc.asartalineapp.viewholders.FoodCategoryViewHolder;
import com.padc.asartalineapp.viewholders.SerachBannerViewHolder;
import com.padc.asartalineapp.viewholders.WarteeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public class DashboardAdapter extends RecyclerView.Adapter<BaseDashboardViewHolder> {

    private final int BANNER_VIEW = 1;
    private final int FOOD_CAT_OFFER_VIEW = 2;
    private final int RESTURANT_CARD_VIEW = 3;
    private List<WarDeeVO> mWarDeeList;
    private DashboardDelegate mDelegate;

    public DashboardAdapter(DashboardDelegate delegate) {
        mWarDeeList = new ArrayList<>();
        mDelegate = delegate;
    }

    @NonNull
    @Override
    public BaseDashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case BANNER_VIEW:
                View view = inflater.inflate(R.layout.view_holder_search_banner, parent, false);
                return new SerachBannerViewHolder(view,mDelegate);
            case FOOD_CAT_OFFER_VIEW:
                View categoryVirew = inflater.inflate(R.layout.view_holder_food_cat, parent, false);
                return new FoodCategoryViewHolder(categoryVirew,mDelegate);
            case RESTURANT_CARD_VIEW:
                View warTeeView = inflater.inflate(R.layout.view_holder_war_tee, parent, false);
                return new WarteeViewHolder(warTeeView,mDelegate);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull BaseDashboardViewHolder holder, int position) {

        if(position > 1){
            holder.bindData(mWarDeeList.get(position-2));
        }

    }

    @Override
    public int getItemCount() {
        if(mWarDeeList.size() == 0){
            return 0;
        }
        return mWarDeeList.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return BANNER_VIEW;
            case 1:
                return FOOD_CAT_OFFER_VIEW;
            default:
                return RESTURANT_CARD_VIEW;
        }
    }

    public void setWarDeeList(List<WarDeeVO> warDeeList) {

        mWarDeeList = warDeeList;
        notifyDataSetChanged();
    }
}
