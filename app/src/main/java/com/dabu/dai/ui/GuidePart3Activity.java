package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;


/**
 * Created by HIPAA on 2015/4/24.
 */
public class GuidePart3Activity extends Activity {
    private ImageView houseImage;
    private ImageView nohouseImage;
    private Button mButton;
    public Controller mController = new Controller(this );


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part3);
        init();
    }


    public void init() {
        houseImage = (ImageView)findViewById(R.id.guide_house_iv_own);
        nohouseImage = (ImageView)findViewById(R.id.guide_house_iv_rent);
        mButton = (Button) findViewById(R.id.guide_house_iv_back);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidePart3Activity.this , GuidePart2Activity.class);
                startActivity(intent);
                finish();
            }
        });

        houseImage.setClickable(true);
        nohouseImage.setClickable(true);


        houseImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.savePreferences("house", "有房");

                Intent intent = new Intent(GuidePart3Activity.this , GuidePart4Activity.class);
                startActivity(intent);
            }
        });


        nohouseImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.savePreferences("house", "无房");
                Intent intent = new Intent(GuidePart3Activity.this , GuidePart4Activity.class);
                startActivity(intent);
            }
        });



    }
}
