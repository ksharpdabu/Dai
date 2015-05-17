package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/24.
 */
public class GuidePart3Activity extends Activity {
    private ImageView houseImage;
    private ImageView nohouseImage;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part3);
        init();
    }


    public void init() {
        houseImage = (ImageView)findViewById(R.id.guide_house_iv_own);
        nohouseImage = (ImageView)findViewById(R.id.guide_house_iv_rent);

        houseImage.setClickable(true);
        nohouseImage.setClickable(true);


        houseImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidePart3Activity.this , GuidePart4Activity.class);
                startActivity(intent);
            }
        });


        nohouseImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidePart3Activity.this , GuidePart4Activity.class);
                startActivity(intent);
            }
        });



    }
}
