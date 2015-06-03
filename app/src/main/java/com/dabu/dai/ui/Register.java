package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;


/**
 * Created by HIPAA on 2015/5/13.
 */
public class Register extends Activity {

    // 定义保存的Preferences名称
    private static final String PREF_NAME = "pref_haodai";
    // 定义保存在Preferences中数据的key
    private static final String PREF_KEY = "pref_phoneNumber";

    private Button loginButton;
    private TextView textView;
    private EditText editText;


    public Controller mController = new Controller(this );

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_new_register);




        Animation alpha = AnimationUtils.loadAnimation(Register.this, R.anim.registersheet_in);

        findViewById(R.id.register_sheet).startAnimation(alpha);

        editText = (EditText) findViewById(R.id.register_contact_et) ;
        loginButton = (Button) findViewById(R.id.register_confirm_btn);
        textView = (TextView) findViewById(R.id.register_prompt_tv);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取用户输入的手机号码
                String phoneNumber = editText.getText().toString().trim();

                MyApplication myApplication = (MyApplication) Register.this.getApplicationContext();
                myApplication.setPass("123456");
                myApplication.setPhnum(phoneNumber);
                Log.e("密码和帐号", myApplication.getPhnum() + myApplication.getPass());






                if(Controller.isMobileRight(phoneNumber)  ){

//       为了方便测试
                    boolean flag = mController.CreatePerson(phoneNumber , "123456");
                    if(flag) {

                        Toast.makeText(Register.this,
                                "登录成功",
                                Toast.LENGTH_LONG).show();

//                        if (mController.isFirstApply())
                        if(true)
                        {

                            Intent intent = new Intent(Register.this, GuidePart1Activity.class);
                            Register.this.startActivity(intent);
                            Register.this.finish();
                        } else {
                            Intent intent = new Intent(Register.this, TestActivity.class);
                            Register.this.startActivity(intent);
                            Register.this.finish();

                        }
                    } else  {
                        Toast.makeText(Register.this,
                                "发送失败",
                                Toast.LENGTH_LONG).show();
                    }



                } else {
                    Toast.makeText(Register.this,
                            "手机号码不合法",
                            Toast.LENGTH_LONG).show();
                }

            }

        });

    }






}
