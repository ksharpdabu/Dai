package com.dabu.dai.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HIPAA on 2015/5/13.
 */
public class TestActivity extends Activity {

    private TextView mTextView;
    private Controller mController = new Controller(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.testtext);
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        MyApplication myApplication = (MyApplication) getApplicationContext();


        JSONObject json = mController.show(myApplication.getPhnum(),myApplication.getPass());

        try{
        String mstring = "电话号码:"+json.getString("phone")+"\n"+
                "工作:"+json.getString("job")+"\n"+
                "姓名:"+json.getString("name")+"\n"+
                "房产:"+json.getString("house")+"\n"+
                "汽车:"+json.getString("car")+"\n"+
                "身份证:"+json.getString("id_card")+"\n"+
                "月收入:"+json.getString("salary")+"\n"+
                "贷款城市:"+json.getString("city")+"\n"+
                "贷款金额:"+json.getString("creadit")+"\n"+
                "贷款时间:"+json.getString("time")+"\n";


            mTextView.setText(mstring);




            Log.e("mstring", mstring);
        } catch ( JSONException e) {
            e.printStackTrace();
        }



    }
}
