package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/27.
 */
public class GuideUrgency extends Activity {
    private ImageView urgencyImage;
    private ImageView nourgencyImage;
    private Button mButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part_urgency);
        init();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void init() {
        this.urgencyImage = (ImageView)findViewById(R.id.guide_urgency_iv_own);
        this.nourgencyImage = (ImageView)findViewById(R.id.guide_urgency_iv_rent);
        this.mButton = (Button) findViewById(R.id.guide_urgency_iv_back);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


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
