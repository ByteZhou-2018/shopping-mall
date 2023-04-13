package com.yugu.shoppingmall;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
>>>>>>> 79bdca5 (first commit)

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
<<<<<<< HEAD
=======
        //两秒钟进入MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //启动MainActivity主页面，这段代码将在主线程执行
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                //关闭当前页面（结束WelcomeActivity）
                finish();
            }
        }, 2000);
>>>>>>> 79bdca5 (first commit)
    }
}