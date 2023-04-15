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
 * 分类Fragment
 */
public class TypeCartFragment extends BaseFragment {

    private final static String TAG = TypeCartFragment.class.getSimpleName();

    private TextView textView;

    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        Log.e(TAG, "分类页面的Fragment的UI被初始化了");
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        textView.setText("分类");
        Log.e(TAG, "分类页面的Fragment的数据被初始化了");
    }

}