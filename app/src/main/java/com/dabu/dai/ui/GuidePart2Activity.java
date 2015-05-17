package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/24.
 */
public class GuidePart2Activity extends Activity {

    private ImageView car;
    private ImageView bus;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part2);
        init();
    }


    public void init() {
        car = (ImageView) findViewById(R.id.guide_vehicle_iv_car);
        bus = (ImageView) findViewById(R.id.guide_vehicle_iv_bus);


        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation alpha = AnimationUtils.loadAnimation(GuidePart2Activity.this, R.anim.right_out);
                carAnim(alpha);
                car.startAnimation(alpha);


            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
