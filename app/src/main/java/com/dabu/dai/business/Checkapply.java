package com.dabu.dai.business;

import android.content.Context;


import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by HIPAA on 2015/6/4.
 */
public class Checkapply {


    public boolean isApplyOk(Context mContext,String phone ,String pass) {
        boolean result = false;

        Controller mController = new Controller(mContext);
        JSONObject json = mController.show(phone,pass);

        try {
            LocalDate currentDate = new LocalDate();



            String lastdateSt = json.getString("time");



            if( lastdateSt == null) {


                result = true;
            }else {
                LocalDate lastDate = new LocalDate(lastdateSt);

                int day = calculateDate(lastDate,currentDate);

                if(day > 14) {
                    result = true;
                }

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }



    public int calculateDate(LocalDate lastDate,LocalDate currentDate) {


        return Days.daysBetween(lastDate,currentDate).getDays();
    }



    public static boolean isCityOk(String city){
        boolean result = false;
        String[] cityArray = new String[]{"长沙","北京","武汉","西安","深圳"};

        for( int i = 0 ; i < cityArray.length; ++i) {
            if(city.equals(cityArray[i])) {
                result = true;
            }

        }

        return  result;

    }

}
