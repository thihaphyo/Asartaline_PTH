package com.padc.asartalineapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.viewholders.BannerViewHolder;
import com.padc.asartalineapp.viewholders.BaseSearchViewHolder;
import com.padc.asartalineapp.viewholders.SearchWarDeeResultViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phyo Thiha on 7/6/18.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<BaseSearchViewHolder> {

    private List<WarDeeVO> mWarDeeList;
    private final int BANNER_VIEW = 1;
    private final int DATA_VIEW = 2;
    private int warDeeListSize = 0;
    private int minPrice = 0;
    private int maxPrice = 0;

    public SearchResultAdapter() {

        mWarDeeList = new ArrayList<>();

    }

    @NonNull
    @Override
    public BaseSearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == BANNER_VIEW) {
            View view = layoutInflater.inflate(R.layout.view_holder_banner, parent, false);
            return new BannerViewHolder(view);
        }
        View view = layoutInflater.inflate(R.layout.view_holder_war_dee_card, parent, false);
        return new SearchWarDeeResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseSearchViewHolder holder, int position) {

        if (position > 0) {
            holder.bindData(mWarDeeList.get(position - 1));
        } else {
            holder.bindData(warDeeListSize,minPrice,maxPrice);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER_VIEW;
        }
        return DATA_VIEW;
    }

    @Override
    public int getItemCount() {
        return mWarDeeList.size() + 1;
    }

    public void setWarDeeList(List<WarDeeVO> warDeeList, int minPrice, int maxPrice) {

        this.mWarDeeList = warDeeList;
        this.warDeeListSize = warDeeList.size();
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        notifyDataSetChanged();

    }
}
