package com.dabu.dai.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dabu.dai.R;
import com.dabu.dai.ui_custom.MyHzScrollView;


/**
 * Created by HIPAA on 2015/4/24.
 */
public class GuidePart4Activity extends Activity {
    private Button buttonNext;
    private Button buttonPre;
    private MyHzScrollView scrollView1;
    private TextView incomeValue;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part4);
        init();
    }


    public void init() {
        this.buttonPre = (Button)findViewById(R.id.guide_btn_step_last);
        this.buttonNext = (Button)findViewById(R.id.guide_btn_step_next);
        this.incomeValue = (TextView)findViewById(R.id.guide_money_tv_number);

        //获取尺子滑动的距离
        scrollView1 = (MyHzScrollView) findViewById(R.id.hzScrollView);
        scrollView1.setHzScrollViewListener(
                new MyHzScrollView.OnHzScrollChangedListener() {

                    @Override
                    public void onScrollChanged(MyHzScrollView view, int l, int t, int oldl, int oldt) {



                        // 将滑动距离进行百分制划分，与图片刻度对其
                        float value =  (float)l / 660  ;
                        int value2 = (int) (value*100);
                        if(value2 <=55) {
                            value2 = value2+1;
                        }

                        incomeValue.setText(String.valueOf(value2) );
//                        Toast.makeText(getContext(), String.valueOf(value2), Toast.LENGTH_LONG).show();
                    }

                }

        );




        buttonNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GuidePart4Activity.this , GuideUrgency.class);
                startActivity(intent);
            }
        });
    }






}





