package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dabu.dai.R;


public class GuideFill extends Activity {

    private Button submitButton;
    private Button lastButton;
    private EditText mEditText;
    private EditText nameEditText;

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
                Intent intent = new Intent(GuideFill.this , TestActivity.class);
                startActivity(intent);
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
