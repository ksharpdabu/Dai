package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/27.
 */
public class GuideUrgency extends Activity {
    private ImageView urgencyImage;
    private ImageView nourgencyImage;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part_urgency);
        init();
    }


    public void init() {
        this.urgencyImage = (ImageView)findViewById(R.id.guide_urgency_iv_own);
        this.nourgencyImage = (ImageView)findViewById(R.id.guide_urgency_iv_rent);


        nourgencyImage.setClickable(true);
        nourgencyImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideUrgency.this , GuideFill.class);
                startActivity(intent);
            }
        });



    }
}
