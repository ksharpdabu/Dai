package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;


public class GuideFill extends Activity {

    private Button submitButton;
    private Button lastButton;
    private EditText mEditText;
    private EditText nameEditText;

    public Controller mController = new Controller(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_anim_fill_id);
        init();
    }


    public void init() {
        mEditText = (EditText)findViewById(R.id.idno_et);
        nameEditText = (EditText)findViewById(R.id.id_name_et);
        submitButton = (Button)findViewById(R.id.guide_btn_step_sumbit);
        lastButton  = (Button)findViewById(R.id.guide_btn_step_last);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.savePreferences("id_card", mEditText.getText().toString().trim());
                mController.savePreferences("name", nameEditText.getText().toString().trim());
                mController.savePreferences("time", String.valueOf(System.currentTimeMillis()));

                List<NameValuePair> parameters = new ArrayList<NameValuePair>();
                MyApplication myApplication = (MyApplication) getApplicationContext();

                parameters = mController.setDetail(myApplication.getPhnum(),myApplication.getPass());
                Log.e("密码和帐号",myApplication.getPhnum()+myApplication.getPass());

                if(mController.CreateDetail(parameters)) {
                    Toast.makeText(getApplicationContext(), "申请成功", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(GuideFill.this , TestActivity.class);
                    startActivity(intent);
                }





            }
        });

        lastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideFill.this , GuideUrgency.class);
                startActivity(intent);
            }
        });

    }

}
