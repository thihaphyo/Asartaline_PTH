package com.padc.asartalineapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.viewholders.BaseDashboardViewHolder;
import com.padc.asartalineapp.viewholders.FoodCategoryViewHolder;
import com.padc.asartalineapp.viewholders.SerachBannerViewHolder;
import com.padc.asartalineapp.viewholders.WarteeViewHolder;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public class DashboardAdapter extends RecyclerView.Adapter<BaseDashboardViewHolder> {

    private final int BANNER_VIEW = 1;
    private final int FOOD_CAT_OFFER_VIEW = 2;
    private final int RESTURANT_CARD_VIEW = 3;

    @NonNull
    @Override
    public BaseDashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case BANNER_VIEW :
                View view = inflater.inflate(R.layout.view_holder_search_banner,parent,false);
                return new SerachBannerViewHolder(view);
            case FOOD_CAT_OFFER_VIEW:
                View categoryVirew = inflater.inflate(R.layout.view_holder_food_cat,parent,false);
                return new FoodCategoryViewHolder(categoryVirew);
            case RESTURANT_CARD_VIEW:
                View warTeeView = inflater.inflate(R.layout.view_holder_war_tee,parent,false);
                return new WarteeViewHolder(warTeeView);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull BaseDashboardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 17;
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
}
