package com.padc.asartalineapp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/6/18.
 */
public class SearchWarDeeResultViewHolder extends BaseSearchViewHolder {

    @BindView(R.id.iv_wardee_hero)
    ImageView ivWarDeeHero;
    @BindView(R.id.tv_taste_desc)
    TextView tvTasteDesc;
    @BindView(R.id.tv_wartee_name)
    TextView tvWarDeeName;
    @BindView(R.id.tv_max_price)
    TextView tvMaxPrice;
    @BindView(R.id.tv_taste)
    TextView tvTaste;
    @BindView(R.id.tv_rating)
    TextView tvRating;
    private WarDeeVO mWarDee;

    public SearchWarDeeResultViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bindData(WarDeeVO warDee) {
        super.bindData(warDee);
        mWarDee = warDee;

        GlideApp.with(ivWarDeeHero.getContext())
                .load(mWarDee.getImages().get(0))
                .placeholder(R.drawable.placeholder_dishes)
                .centerCrop()
                .into(ivWarDeeHero);

        tvTasteDesc.setText(mWarDee.getGeneralTaste().get(0).getTasteDesc());
        tvWarDeeName.setText(mWarDee.getName());
        tvMaxPrice.setText(String.valueOf(mWarDee.getPriceRangeMax()));
        tvTaste.setText(mWarDee.getGeneralTaste().get(0).getTaste().replace(" ", ","));

    }
}
