package com.padc.asartalineapp.viewholders;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.asartalineapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/6/18.
 */
public class BannerViewHolder extends BaseSearchViewHolder {

    @BindView(R.id.iv_backdrop)
    ImageView ivBackDrop;
    @BindView(R.id.tv_search_result)
    TextView tvSearchResult;
    @BindView(R.id.tv_price_range)
    TextView tvPriceRange;

    public BannerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void bindData(int size, int min, int max) {
        super.bindData(size, min, max);
        tvSearchResult.setText(tvSearchResult.getContext()
                .getString(R.string.format_price_search_count, size));
        tvPriceRange.setText(tvPriceRange.getContext()
                .getString(R.string.format_price_search, min, max));

    }
}
