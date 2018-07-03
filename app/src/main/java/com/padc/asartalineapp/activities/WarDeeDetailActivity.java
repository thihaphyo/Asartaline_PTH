package com.padc.asartalineapp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.data.models.WarteeModel;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.utils.AppConstants;
import com.padc.asartalineapp.utils.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class WarDeeDetailActivity extends BaseActivity {

    @BindView(R.id.iv_backdrop)
    ImageView ivBackDrop;
    @BindView(R.id.tv_wartee_name)
    TextView tvWarTeeName;
    @BindView(R.id.tv_price_range)
    TextView tvPrice;
    @BindView(R.id.tv_wartee_description)
    TextView tvWarteeDescription;
    @BindView(R.id.et_additional_notes)
    EditText etAdditionalNotes;
    @BindView(R.id.btn_increase)
    Button btnIncrease;
    @BindView(R.id.btn_decrease)
    Button btnDecrease;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.btn_add_to_cart)
    Button btnAddToCart;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ctl)
    CollapsingToolbarLayout collapsingToolbarLayout;
    private int count = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardee_detail);
        ButterKnife.bind(this, this);
        String warDeeId = getIntent().getStringExtra(AppConstants.WARDEE_ID);
        WarDeeVO warDee = WarteeModel.getObjectReference().getWarDeeById(warDeeId);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        etAdditionalNotes.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                tvCount.setText(String.valueOf(count));

            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 0 ){
                    count--;
                }
                tvCount.setText(String.valueOf(count));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bindData(warDee);

    }

    @SuppressLint("StringFormatInvalid")
    private void bindData(WarDeeVO warDee) {

        GlideApp.with(ivBackDrop.getContext())
                .load(warDee.getImages().get(2))
                .placeholder(R.drawable.placeholder_dishes)
                .into(ivBackDrop);

        tvWarTeeName.setText(warDee.getName());
        tvPrice.setText(getString(R.string.format_price, warDee.getPriceRangeMax()));
        tvWarteeDescription.setText(warDee.getGeneralTaste().get(0).getTasteDesc());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
