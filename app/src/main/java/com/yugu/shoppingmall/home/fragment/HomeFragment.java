package com.yugu.shoppingmall.home.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.yugu.shoppingmall.base.BaseFragment;

/**
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment {

    private final static String TAG = HomeFragment.class.getSimpleName();

    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("首页");
        Log.e(TAG,"主页面的Fragment的数据被初始化了");
    }
}