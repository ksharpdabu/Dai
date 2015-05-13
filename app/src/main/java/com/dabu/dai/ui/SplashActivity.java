package com.dabu.dai.ui;


import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.dabu.dai.R;


/**
 *
 *
 */
public class SplashActivity extends Activity {

    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;

    private final int SPLASH_DELAY_MILLIS = 2000; // 延迟2s
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        init();
    }


    /**
     * Handler:跳转到不同界面
     */
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    private void init() {

            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);


    }

    private void goGuide() {
        Intent intent = new Intent(SplashActivity.this, HelloActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }
}


