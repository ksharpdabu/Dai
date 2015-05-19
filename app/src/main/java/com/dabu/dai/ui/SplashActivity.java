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
    // �ж��Ƿ��һ��ʹ��app
    boolean isFirstIn = false;

    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;

    private final int SPLASH_DELAY_MILLIS = 2000; // �ӳ�2s

    private static final String SHAREDPREFERENCES_NAME = "first_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        isFirstRun();
    }


    /**
     * Handler:��ת����ͬ����
     */
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
            super.handleMessage(msg);
        }
    };



    private void isFirstRun() {

        // ��ȡSharedPreferences����Ҫ������
        // ʹ��SharedPreferences����¼������Ƿ��ǵ�һ������
        SharedPreferences preferences = getSharedPreferences(
                SHAREDPREFERENCES_NAME, MODE_PRIVATE);

        // ȡ����Ӧ��ֵ�����û�и�ֵ��˵����δд�룬��true��ΪĬ��ֵ
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        // �жϳ�����ڼ������У�����ǵ�һ����������ת���������棬������ת��������
        if (isFirstIn) {
            // ʹ��Handler��postDelayed������2���ִ����ת��MainActivity

            preferences.edit().putBoolean("isFirstIn", false).commit();
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);


        } else {
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
        }


    }

    private void goGuide() {
        Intent intent = new Intent(SplashActivity.this, HelloActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }


    private void goHome() {
        Intent intent = new Intent(SplashActivity.this, Register.class);
        SplashActivity.this .startActivity(intent);
        SplashActivity.this.finish();
    }
}


