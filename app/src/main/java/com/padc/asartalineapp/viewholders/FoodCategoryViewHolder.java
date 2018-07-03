package com.padc.asartalineapp.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.delegates.DashboardDelegate;
import com.padc.asartalineapp.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public class FoodCategoryViewHolder extends BaseDashboardViewHolder {

    @BindView(R.id.btn_chinese_food)
    ImageView btnChineseFood;
    @BindView(R.id.btn_tacos)
    ImageView btnTacos;
    @BindView(R.id.btn_burger)
    ImageView btnBurger;
    @BindView(R.id.btn_donuts)
    ImageView btnDonuts;
    private DashboardDelegate mDelegate;

    public FoodCategoryViewHolder(View itemView, DashboardDelegate dashboardDelegate) {
        super(itemView);
        mDelegate = dashboardDelegate;
        ButterKnife.bind(this, itemView);
        btnChineseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapCategory(AppConstants.CHINESE_FOOD);
            }
        });

        btnTacos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapCategory(AppConstants.TACOS_FOOD);
            }
        });

        btnBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapCategory(AppConstants.BURGER_FOOD);
            }
        });

        btnDonuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapCategory(AppConstants.DONUT_FOOD);
            }
        });

    }
}
