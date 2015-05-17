package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

//跳过输入，方便测试


                if(isMobileNO(phoneNumber)) {
                    Intent intent  = new Intent(Register.this , GuidePart1Activity.class);
                    Register.this.startActivity(intent);
                    Register.this.finish();
                } else {
                    Toast.makeText(Register.this,
                            "手机号码不合法",
                            Toast.LENGTH_LONG).show();
                }

            }

        });

    }


    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
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


}
