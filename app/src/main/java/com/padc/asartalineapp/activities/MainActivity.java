package com.padc.asartalineapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.adapters.DashboardAdapter;
import com.padc.asartalineapp.data.models.WarteeModel;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.delegates.DashboardDelegate;
import com.padc.asartalineapp.events.ApiErrorEvent;
import com.padc.asartalineapp.events.SuccessGetWarDeeEvent;
import com.padc.asartalineapp.utils.AppConstants;
import com.padc.asartalineapp.viewpods.EmptyViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements DashboardDelegate {

    private DashboardAdapter mAdapter;
    @BindView(R.id.rv_asar__taline)
    RecyclerView rvAsarTaline;
    @BindView(R.id.swl)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.vp_empty)
    EmptyViewPod vpEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);



        swipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.colorPrimary)
                , getResources().getColor(R.color.colorPrimaryDark)
                , getResources().getColor(R.color.primaryText));

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mAdapter = new DashboardAdapter(this);
        rvAsarTaline.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvAsarTaline.setAdapter(mAdapter);
        swipeRefreshLayout.setRefreshing(true);
        WarteeModel.getObjectReference().loadWarTeeList();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WarteeModel.getObjectReference().loadWarTeeList();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {
        vpEmpty.setVisibility(View.GONE);
        mAdapter.setWarDeeList(event.getmWarDeeList());
        swipeRefreshLayout.setRefreshing(false);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onApiError(ApiErrorEvent event) {
        vpEmpty.setVisibility(View.VISIBLE);
        vpEmpty.setEmptyData(R.drawable.ic_error_placeholder,
                getString(R.string.format_error, "ဝါးတီး မ်ား ကို ေလာ ေလာ ဆယ္ မျပ ႏိုင္ ေသး ပါ"));
        Snackbar.make(rvAsarTaline, event.getErrMessage(), Snackbar.LENGTH_INDEFINITE).show();
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onTapWarTeeItem(WarDeeVO warDee) {
        Log.d("onTapWarTeeItem", warDee.getWarDeeId());
        Intent intent = new Intent(getApplicationContext(), WarDeeDetailActivity.class);
        intent.putExtra(AppConstants.WARDEE_ID, warDee.getWarDeeId());
        startActivity(intent);
    }

    @Override
    public void onSearch(String query) {

        Log.d("onSearch", query);
        Intent intent = new Intent(getApplicationContext(),SearchWarDeeActivity.class);
        startActivity(intent);

    }

    @Override
    public void onTapCategory(String category) {

        Log.d("onTapCategory", category);

    }


}
