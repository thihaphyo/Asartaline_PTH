package com.padc.asartalineapp.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.WindowManager;

import com.padc.asartalineapp.R;
import com.padc.asartalineapp.adapters.DashboardAdapter;
import com.padc.asartalineapp.data.models.WarteeModel;
import com.padc.asartalineapp.data.vos.WarDeeVO;
import com.padc.asartalineapp.delegates.DashboardDelegate;
import com.padc.asartalineapp.events.ApiErrorEvent;
import com.padc.asartalineapp.events.SuccessGetWarDeeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements DashboardDelegate {

    private DashboardAdapter mAdapter;
    @BindView(R.id.rv_asar__taline)
    RecyclerView rvAsarTaline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mAdapter = new DashboardAdapter(this);
        rvAsarTaline.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvAsarTaline.setAdapter(mAdapter);

        WarteeModel.getObjectReference().loadWarTeeList();


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

        mAdapter.setWarDeeList(event.getmWarDeeList());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onApiError(ApiErrorEvent event) {

        Snackbar.make(rvAsarTaline, event.getErrMessage(), Snackbar.LENGTH_INDEFINITE).show();

    }

    @Override
    public void onTapWarTeeItem(WarDeeVO warDee) {
        Log.d("onTapWarTeeItem", warDee.getWarDeeId());
    }

    @Override
    public void onSearch(String query) {

        Log.d("onSearch", query);

    }

    @Override
    public void onTapCategory(String category) {

        Log.d("onTapCategory", category);

    }
}
