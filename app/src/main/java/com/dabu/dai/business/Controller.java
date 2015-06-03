package com.dabu.dai.business;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HIPAA on 2015/5/19.
 */
public class Controller {

    private Context mContext ;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";


    // 判断是否第一次使用app
    boolean isFirstIn = false;



    //check firstrun end








    public  Controller(Context context){
        this.mContext = context;



    }




    /**
     * 判断是否第一次使用app
     */
    public  boolean  isFirstRun( ) {

        boolean result = false;
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的是否是第一次运行
        SharedPreferences preferences = mContext.getSharedPreferences(
                SHAREDPREFERENCES_NAME, mContext.MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstIn", true);

        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (isFirstIn) {
            // 使用Handler的postDelayed方法，2秒后执行跳转到MainActivity
            preferences.edit().putBoolean("isFirstIn", false).commit();
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 判断是否第一次申请
     */
    public  boolean  isFirstApply( ) {

        boolean result = false;
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的是否是第一次申请
        SharedPreferences preferences = mContext.getSharedPreferences(
                SHAREDPREFERENCES_NAME, mContext.MODE_PRIVATE);

        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstApply", true);


        if (isFirstIn) {
            preferences.edit().putBoolean("isFirstApply", false).commit();
            result = true;
        } else {
            result = false;
        }
        return result;
    }


    public  void savePreferences( String key, String value) {
        SharedPreferences preferences = mContext.getSharedPreferences(
                SHAREDPREFERENCES_NAME, mContext.MODE_PRIVATE);
        preferences.edit().putString(key, value).commit();


    }


    public String getPreferences(String key) {

        SharedPreferences preferences = mContext.getSharedPreferences(
                SHAREDPREFERENCES_NAME, mContext.MODE_PRIVATE);
        String result =  preferences.getString( key , "nothing");

        return result;

    }




    public boolean CreatePerson(String phone , String mPass) {
        boolean result = false;
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("phone" ,phone));
        parameters.add(new BasicNameValuePair("pass" ,mPass));

        Connector mConnector = new Connector(mContext);
        String code = mConnector.Create(parameters);
        if(code != null)
        { if( code.equals("1")) {
                    result = true;
          }

        }

        return result;
    }


    public List<NameValuePair> setDetail(String phone , String mPass) {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();

        String id_card = getPreferences("id_card");
        String name = getPreferences("name");
        String salary = getPreferences("salary");
        String time = getPreferences("time");
        String car = getPreferences("car");
        String house = getPreferences("house");
        String city = getPreferences("city");
        String creadit = getPreferences("creadit");
        String job = getPreferences("job");

        parameters.add(new BasicNameValuePair("phone" ,phone));
        parameters.add(new BasicNameValuePair("pass" ,mPass));
        parameters.add(new BasicNameValuePair("id_card" ,id_card));
        parameters.add(new BasicNameValuePair("name" ,name));
        parameters.add(new BasicNameValuePair("salary" ,salary));
        parameters.add(new BasicNameValuePair("time" ,time));
        parameters.add(new BasicNameValuePair("car" ,car));
        parameters.add(new BasicNameValuePair("house" ,house));
        parameters.add(new BasicNameValuePair("city" ,city));
        parameters.add(new BasicNameValuePair("creadit" ,creadit));
        parameters.add(new BasicNameValuePair("job" ,job));

        return parameters;


    }




    public boolean CreateDetail( List<NameValuePair> parameters) {


        Connector mConnector = new Connector(mContext);
        String code = mConnector.CreateDetail(parameters);
        if( code.equals("1")) {
            return true;
        } else {
            return false;
        }


    }


    public JSONObject show(String phone , String mPass) {

        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("phone" ,phone));
        parameters.add(new BasicNameValuePair("pass" ,mPass));

        Connector mConnector = new Connector(mContext);
        JSONObject json = mConnector.Show(parameters);



        return json;
    }






    /**
     * 判断是否联网
     */
    public boolean detectNetwork() {
        boolean result = false;

        ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        result = true;
                    }
        }
        return result;
    }


    /**
     * 验证手机格式
     */
    public static boolean isMobileRight(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
        联通：130、131、132、152、155、156、185、186
        电信：133、153、180、189、（1349卫通）
        总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
        */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    /**
     * 检查号码是否已经存在
     */
    public static boolean isPhoneExist(String mobiles) {
        return false;
    }

}

