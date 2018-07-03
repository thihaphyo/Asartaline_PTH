package com.padc.asartalineapp.viewholders;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.delegates.DashboardDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/2/18.
 */
public class SerachBannerViewHolder extends BaseDashboardViewHolder {
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;

    private DashboardDelegate mDelegate;

    public SerachBannerViewHolder(View itemView, DashboardDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = delegate;
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mDelegate.onSearch(v.getText().toString());
                    return true;
                }
                return false;
            }
        });

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onSearch(etSearch.getText().toString());
            }
        });

    }

}
