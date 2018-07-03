package com.padc.asartalineapp.viewholders;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.delegates.DashboardDelegate;
import com.padc.asartalineapp.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public class WarteeViewHolder extends BaseDashboardViewHolder {

    @BindView(R.id.tv_wartee_name)
    TextView tvWarteeName;
    @BindView(R.id.tv_taste)
    TextView tvTaste;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.iv_wartee_cover)
    ImageView ivWarteeCover;
    @BindView(R.id.cv_wartee)
    CardView cvWarTee;

    private WarDeeVO mWarDee;

    private DashboardDelegate mDelegate;

    public WarteeViewHolder(View itemView,DashboardDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
        ButterKnife.bind(this, itemView);
        cvWarTee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapWarTeeItem(mWarDee);
            }
        });
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void bindData(WarDeeVO warDeeVO) {
        super.bindData(warDeeVO);
        mWarDee = warDeeVO;

        tvWarteeName.setText(mWarDee.getName());
        tvTaste.setText(mWarDee.getGeneralTaste().get(0).getTaste());
        tvPrice.setText(tvPrice.getContext()
                .getString(R.string.format_price_range, mWarDee.getPriceRangeMin()
                        , mWarDee.getPriceRangeMax()));

        GlideApp.with(ivWarteeCover.getContext())
                .load(mWarDee.getImages().get(0))
                .placeholder(R.drawable.placeholder_dishes)
                .centerCrop()
                .into(ivWarteeCover);


    }
}
