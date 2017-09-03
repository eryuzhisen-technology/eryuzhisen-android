package com.eryuzhisen.android.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.MainContract;
import com.eryuzhisen.android.fragment.CollectFragment;
import com.eryuzhisen.android.fragment.FindFragment;
import com.eryuzhisen.android.fragment.MessageFragment;
import com.eryuzhisen.android.fragment.MyselfFragment;
import com.eryuzhisen.android.presenter.MainPresenter;
import com.na.mvp.base.NaBaseActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends NaBaseActivity<MainPresenter> implements MainContract.View, View.OnClickListener {
    private final static String FragmentFind = "find";
    private final static String FragmentCollect = "collect";
    private final static String FragmentWriting = "writing";
    private final static String FragmentMsg = "msg";
    private final static String FragmentMe = "me";
    private String currentFragment = FragmentFind;

    private ImageView ivFind;
    private ImageView ivCollect;
    private ImageView ivWriting;
    private ImageView ivMsg;
    private ImageView ivMe;

    private Map<String, MainItem> mainItemMap;


    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.main;
    }

    @Override
    protected void onInit() {
        super.onInit();
        ivFind = (ImageView) findViewById(R.id.ivFind);
        ivCollect = (ImageView) findViewById(R.id.ivCollect);
        ivWriting = (ImageView) findViewById(R.id.ivWriting);
        ivMsg = (ImageView) findViewById(R.id.ivMsg);
        ivMe = (ImageView) findViewById(R.id.ivMe);

        if (mainItemMap == null) {
            mainItemMap = new HashMap<String, MainItem>(5);
        }
        mainItemMap.clear();
        MainItem item = new MainItem(R.mipmap.main_icon_find, R.mipmap.main_icon_find_down);
        item.setView(ivFind);
        item.setType(FragmentFind);
        mainItemMap.put(FragmentFind, item);

        item = new MainItem(R.mipmap.main_icon_collect, R.mipmap.main_icon_collect_down);
        item.setView(ivCollect);
        item.setType(FragmentCollect);
        mainItemMap.put(FragmentCollect, item);

//        MainItem item = new MainItem(FragmentFind, R.mipmap.main_icon_writing, R.mipmap.main_icon_writing);
//        mainItemMap.add(item);

        item = new MainItem(R.mipmap.main_icon_msg, R.mipmap.main_icon_msg_down);
        item.setView(ivMsg);
        item.setType(FragmentMsg);
        mainItemMap.put(FragmentMsg, item);

        item = new MainItem(R.mipmap.main_icon_me, R.mipmap.main_icon_me_down);
        item.setView(ivMe);
        item.setType(FragmentMe);
        mainItemMap.put(FragmentMe, item);
        onChangeFragment(currentFragment);

    }


    @Override
    protected void onListener() {
        super.onListener();
        ivFind.setOnClickListener(this);
        ivCollect.setOnClickListener(this);
        ivWriting.setOnClickListener(this);
        ivMsg.setOnClickListener(this);
        ivMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String fragment = null;
        boolean isCheckLogin = true;
        switch (view.getId()) {
            case R.id.ivFind: {
                fragment = FragmentFind;
                isCheckLogin = false;
                break;
            }
            case R.id.ivCollect: {
                fragment = FragmentCollect;
                break;
            }
            case R.id.ivWriting: {
//                fragment = FragmentWriting;
                enterWriting();
                break;
            }
            case R.id.ivMsg: {
                fragment = FragmentMsg;
                break;
            }
            case R.id.ivMe: {
                fragment = FragmentMe;
                break;
            }
            default: {
                break;
            }
        }

        onChangeFragment(fragment);
        if(isCheckLogin){
            if(presenter != null){
                presenter.checkLogin(this);
            }
        }
    }

    private void enterWriting() {

    }

    private void onChangeFragment(String fragment) {
        if (!TextUtils.isEmpty(fragment)) {
            MainItem lastItem = getFragmentItem(currentFragment);
            if (lastItem != null) {
                lastItem.unselected();
            }
            currentFragment = fragment;

            MainItem nextItem = getFragmentItem(currentFragment);
            if (nextItem != null) {
                nextItem.selected();
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if(lastItem.getFragment() != null){
                transaction.hide(lastItem.getFragment());
            }

            if(nextItem.getFragment() == null){
                transaction.add(R.id.llFragments, nextItem.createFragment());
            } else {
                transaction.show(nextItem.getFragment());
            }

            transaction.commit();
        }
    }

    private MainItem getFragmentItem(String fragment) {
        MainItem item = null;
        if (!TextUtils.isEmpty(fragment)) {
            item = mainItemMap.get(fragment);
        }
        return item;
    }

    private class MainItem {
        private String type;
        private int resDefult;
        private int resSelected;
        private ImageView view;
        private Fragment fragment;

        public MainItem(int resDefult, int resSelected) {

            this.resDefult = resDefult;
            this.resSelected = resSelected;
        }

        public void setView(ImageView view) {
            this.view = view;
        }

        public void selected() {
            this.view.setImageResource(resSelected);
        }

        public void unselected() {
            this.view.setImageResource(resDefult);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public Fragment createFragment() {
            if(fragment == null){
                if(type.equals(FragmentFind)){
                    fragment = FindFragment.newInstance();
                } else if(type.equals(FragmentCollect)){
                    fragment = CollectFragment.newInstance();
                }
                else if(type.equals(FragmentMsg)){
                    fragment = MessageFragment.newInstance();
                }
                else if(type.equals(FragmentMe)){
                    fragment = MyselfFragment.newInstance();
                }
            }
            return fragment;
        }
    }
}
