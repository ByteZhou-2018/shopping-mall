package com.yugu.shoppingmall.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.indicator.CircleIndicator;
import com.yugu.shoppingmall.bannerUtil.*;


import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.config.BannerConfig;
import com.yugu.shoppingmall.R;
import com.yugu.shoppingmall.bannerUtil.InfoBean;
import com.yugu.shoppingmall.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private final static String TAG = HomeFragment.class.getSimpleName();

    private EditText tv_search_home;
    private TextView tv_message_home;
    private RecyclerView rv_home;
    private ImageView ib_top;

    private  ArrayList<InfoBean> banners;


    public HomeFragment() {
        //v1,v2这些是轮播图片，可用自己本地的替换掉。
        banners = new ArrayList<>();
        banners.add(new InfoBean(R.drawable.welcome));
        banners.add(new InfoBean(R.drawable.welcome));
        banners.add(new InfoBean(R.drawable.welcome));
        banners.add(new InfoBean(R.drawable.welcome));
    }


    @Override
    public View initView() {
        Log.e(TAG,"主页面的Fragment的UI被初始化了");
        View view = View.inflate(mContext,R.layout.activity_home_fragment,null);
        //初始化布局控件
        tv_search_home = (EditText) view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        rv_home = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);

        //设置点击事件
        ib_top.setOnClickListener(this);
        tv_search_home.setOnClickListener(this);
        tv_message_home.setOnClickListener(this);

//       //初始化banner
//        banners = new ArrayList<>();
//        banners.add(new InfoBean(R.drawable.welcome));
//        banners.add(new InfoBean(R.drawable.welcome));
//        banners.add(new InfoBean(R.drawable.welcome));
//        banners.add(new InfoBean(R.drawable.welcome));


        return view;
    }


    @Override
    public void initData() {
        super.initData();
        Log.e(TAG,"主页面的Fragment的数据被初始化了");


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_top: //置顶的监听
                rv_home.scrollToPosition(0);
                break;
            case R.id.tv_search_home:  //搜索的监听
                tv_search_home.setText("");
                Toast.makeText(mContext,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_message_home: //消息监听
                Toast.makeText(mContext,"进入消息中心",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.activity_home_fragment, container, false);
        Banner banner = inflate.findViewById(R.id.banner);

        //添加生命周期
        banner.addBannerLifecycleObserver(this)
                .setAdapter(new BannerViewAdapter(banners, this))
                //添加指示器
                .setIndicator(new CircleIndicator(getContext()));
        return inflate;
    }

}