package com.dabu.dai.ui;

import android.app.Application;

/**
 * Created by HIPAA on 2015/6/2.
 */
public class MyApplication extends Application {

    private String pass;
    private String  phnum;

    public String getPhnum() {
        return phnum;
    }

    public void setPhnum(String phnum) {
        this.phnum = phnum;
    }



    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    @Override
    public  void onCreate() {
        super.onCreate();
    }


    @Override
    public  void onTerminate() {
        super.onTerminate();
    }
}
