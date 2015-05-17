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

    // ���屣���Preferences����
    private static final String PREF_NAME = "pref_haodai";
    // ���屣����Preferences�����ݵ�key
    private static final String PREF_KEY = "pref_phoneNumber";

    private Button loginButton;
    private TextView textView;
    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //ȥ��Activity�����״̬��
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
                //��ȡ�û�������ֻ�����
                String phoneNumber = editText.getText().toString().trim();

//�������룬�������


                if(isMobileNO(phoneNumber)) {
                    Intent intent  = new Intent(Register.this , GuidePart1Activity.class);
                    Register.this.startActivity(intent);
                    Register.this.finish();
                } else {
                    Toast.makeText(Register.this,
                            "�ֻ����벻�Ϸ�",
                            Toast.LENGTH_LONG).show();
                }

            }

        });

    }


    /**
     * ��֤�ֻ���ʽ
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188
        ��ͨ��130��131��132��152��155��156��185��186
        ���ţ�133��153��180��189����1349��ͨ��
        �ܽ��������ǵ�һλ�ض�Ϊ1���ڶ�λ�ض�Ϊ3��5��8������λ�õĿ���Ϊ0-9
        */
        String telRegex = "[1][358]\\d{9}";//"[1]"�����1λΪ����1��"[358]"����ڶ�λ����Ϊ3��5��8�е�һ����"\\d{9}"��������ǿ�����0��9�����֣���9λ��
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }


}
