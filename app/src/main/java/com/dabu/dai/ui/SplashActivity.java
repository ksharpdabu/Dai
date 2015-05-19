package com.dabu.dai.ui;


import android.app.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;

import java.util.ResourceBundle;


/**
 *
 *
 */
public class SplashActivity extends Activity {
    // 判断是否第一次使用app
//    boolean isFirstIn = false;

    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;

    private final int SPLASH_DELAY_MILLIS = 2000; // 延迟2s

    private Controller mController = new Controller( this);

//    private static final String SHAREDPREFERENCES_NAME = "first_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        whereGo(mController.isFirstRun() , mController.detectNetwork());
    }


    /**
     * Handler:跳转到不同界面
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



//      private void isFirstRun() {
//
//        // 读取SharedPreferences中需要的数据
//        // 使用SharedPreferences来记录程序的是否是第一次运行
//        SharedPreferences preferences = getSharedPreferences(
//                SHAREDPREFERENCES_NAME, MODE_PRIVATE);
//
//        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
//        isFirstIn = preferences.getBoolean("isFirstIn", true);
//
//        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
//        if (isFirstIn) {
//            // 使用Handler的postDelayed方法，2秒后执行跳转到MainActivity
//
//            preferences.edit().putBoolean("isFirstIn", false).commit();
//            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
//
//
//        } else {
//            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
//        }
//
//
//    }

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



    private void  whereGo(boolean first , boolean network) {

        if (network) {

            if (first) {
                mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
            } else {
                mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
            }

        } else {
            showAlertDialog(this, "无网络连接",
                    "请先连接网络", false);
//            Toast.makeText(this,"无网络", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Function to display simple Alert Dialog
     * @param context - application context
     * @param title - alert dialog title
     * @param message - alert message
     * @param status - success/failure (used to set icon)
     * */
    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
//        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }
}





