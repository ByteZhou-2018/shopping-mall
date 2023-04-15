package com.yugu.shoppingmall.home.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.yugu.shoppingmall.R;
import com.yugu.shoppingmall.base.BaseFragment;

/**
 * 购物车Fragment
 */
public class ShoppingCartFragment extends BaseFragment {

    private final static String TAG = ShoppingCartFragment.class.getSimpleName();

    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        Log.e(TAG, "购物车页面的Fragment的UI被初始化了");
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("购物车");
        Log.e(TAG, "购物车页面的Fragment的数据被初始化了");
    }

}