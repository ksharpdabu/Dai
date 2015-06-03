package com.dabu.dai.business;

import android.content.Context;

import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.util.Log;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.List;


/**
 * Created by HIPAA on 2015/6/2.
 */
public class Connector {
    private  final String address = "http://192.168.2.11:8080/exercise-services/activities/";
    Context mContext ;



    Connector (Context context) {
        mContext = context;

    }

    public  String Create(List<NameValuePair> parameters) {



        HttpClient httpclient = new DefaultHttpClient();

        String code = null ;
        try {
            String  createurl =  address + "create";

            HttpPost createRequest = new HttpPost(createurl);


            createRequest.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");

            createRequest.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);



            HttpResponse response = httpclient.execute(createRequest);


            String readJSON = getJSON(response);

            try{
                code  = (new JSONObject(readJSON)).getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }




        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetworkOnMainThreadException e) {
            e.printStackTrace();
        }

        return code;

    }



    public  JSONObject Show(List<NameValuePair> parameters) {

        JSONObject json = null;

        HttpClient httpclient = new DefaultHttpClient();


        try {
            String  createurl =  address + "show";

            HttpPost createRequest = new HttpPost(createurl);


            createRequest.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");

            createRequest.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);



            HttpResponse response = httpclient.execute(createRequest);


            String readJSON = getJSON(response);

            Log.e("show result", readJSON);

            try{
                json  = new JSONObject(readJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }




        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NetworkOnMainThreadException e) {
            e.printStackTrace();
        }

        return json;

    }


    public String CreateDetail(List<NameValuePair> parameters) {

        HttpClient httpclient = new DefaultHttpClient();

        String code = null ;
        try {
            String createurl = address + "person";

            HttpPost createRequest = new HttpPost(createurl);

            createRequest.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");

            createRequest.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);


            HttpResponse response = httpclient.execute(createRequest);

            String readJSON = getJSON(response);
            Log.e("CreateDetail readjson",readJSON);

            try{
                code  = (new JSONObject(readJSON)).getString("code");
            } catch (JSONException e) {
                e.printStackTrace();
            }



        }  catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return code;
    }


//从response中获取json
    public String getJSON(HttpResponse response) {
        StringBuilder builder = new StringBuilder();
        int statuscode = response.getStatusLine().getStatusCode();
        try {

            Log.e("statuscode",String.valueOf(statuscode));

            if (statuscode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = null;

                content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);

                }
            } else {
                Log.e("getJson result", "Failedet JSON object");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        Log.e("response", builder.toString());
        return builder.toString();

    }
}
