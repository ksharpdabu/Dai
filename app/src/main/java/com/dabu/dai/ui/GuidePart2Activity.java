package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.dabu.dai.R;
import com.dabu.dai.business.Controller;



/**
 * Created by HIPAA on 2015/4/24.
 */
public class GuidePart2Activity extends Activity {

    private ImageView car;
    private ImageView bus;
    private Button mbutton;
    public Controller mController = new Controller(this );


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part2);
        init();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public void init() {
        car = (ImageView) findViewById(R.id.guide_vehicle_iv_car);
        bus = (ImageView) findViewById(R.id.guide_vehicle_iv_bus);
        mbutton = (Button) findViewById(R.id.guide_vehicle_iv_back);


        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();

            }
        });


        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mController.savePreferences("car", "有车");

                Animation alpha = AnimationUtils.loadAnimation(GuidePart2Activity.this, R.anim.right_out);
                carAnim(alpha);
                car.startAnimation(alpha);


            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mController.savePreferences("car", "无车");

                Animation alpha = AnimationUtils.loadAnimation(GuidePart2Activity.this, R.anim.right_out);
                //设置动画监听器，确保在执行完动画后在切换到新的Activity
                carAnim(alpha);
                bus.startAnimation(alpha);

            }
        });


    }


    public void carAnim(Animation alpha) {

        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(GuidePart2Activity.this, GuidePart3Activity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
