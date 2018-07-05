package com.padc.asartalineapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.adapters.SearchResultAdapter;
import com.padc.asartalineapp.data.models.WarteeModel;
import com.padc.asartalineapp.events.ApiErrorEvent;
import com.padc.asartalineapp.events.SuccessSearchWarDeeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyo Thiha on 7/6/18.
 */
public class SearchWarDeeActivity extends BaseActivity {

    @BindView(R.id.rv_search_results)
    RecyclerView rvSearchResults;
    private SearchResultAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_wardee);
        ButterKnife.bind(this, this);
        rvSearchResults.setLayoutManager(new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false));
        adapter = new SearchResultAdapter();
        rvSearchResults.setAdapter(adapter);
        WarteeModel.getObjectReference().searchWarDeeList();
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

    @Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetApi(SuccessSearchWarDeeEvent event) {

        adapter.setWarDeeList(event.getmWarDeeList(),event.getMinPrice(),event.getMaxPrice());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorGetApi(ApiErrorEvent errorEvent) {

        Snackbar.make(rvSearchResults, errorEvent.getErrMessage(), Snackbar.LENGTH_INDEFINITE).show();

    }
}
