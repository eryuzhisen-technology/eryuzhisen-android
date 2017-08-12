package com.eryuzhisen.android.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.adapter.WecomeAdapter;
import com.eryuzhisen.android.contract.WecomeContract;
import com.eryuzhisen.android.presenter.WecomePresenter;
import com.eryuzhisen.android.widget.MyPageIndicator;
import com.na.mvp.base.NaBaseActivity;

public class WecomeActivity extends NaBaseActivity<WecomePresenter> implements WecomeContract.View, View.OnClickListener{

    private ViewPager vpList;
    private MyPageIndicator piIndicator;
    private Button btStart;
    private WecomeAdapter mAdapter;

    @Override
    protected int getContentId() {
        return R.layout.activity_wecome;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.wecome;
    }

    @Override
    protected void onInit() {
        super.onInit();
        vpList = (ViewPager) findViewById(R.id.vpList);
        piIndicator = (MyPageIndicator) findViewById(R.id.piIndicator);
        btStart = (Button) findViewById(R.id.btStart);
        mAdapter = new WecomeAdapter();
        piIndicator.setSelectedDrawable(R.drawable.page_indicator_selected);
        piIndicator.setNormalDrawable(R.drawable.page_indicator_unselected);
        piIndicator.setCount(mAdapter.getCount());
        vpList.setAdapter(mAdapter);
        vpList.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                piIndicator.setSelection(position);
            }

            @Override
            public void onPageSelected(int position) {
                if(position == mAdapter.getCount() - 1){
//                    piIndicator.setVisibility(View.GONE);
                    btStart.setVisibility(View.VISIBLE);
                } else {
//                    piIndicator.setVisibility(View.VISIBLE);
                    btStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onListener() {
        super.onListener();
        btStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btStart: {
                finish();
                break;
            }
            default: {
                break;
            }
        }
    }

}
