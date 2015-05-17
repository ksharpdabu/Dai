package com.dabu.dai.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dabu.dai.R;
import com.dabu.dai.ui_custom.BoldTextView;
import com.dabu.dai.ui_custom.Boss;
import com.dabu.dai.ui_custom.MyScrollView;
import com.dabu.dai.ui_custom.RulerVertical;
import com.dabu.dai.ui_custom.Worker;


/**
 * Created by HIPAA on 2015/4/20.
 */
public class GuidePart1Activity extends Activity {


    private RulerVertical incomeRuler;
    private Boss boss;
    private Worker worker;
    private View bossCharater;
    private View workerCharater;
    private View incomeLayout;
    private View cityLayout;
    private View headLayout;
    private View guidestep;
    private TextView cityName;
    private TextView valuePrefix;
    private TextView iamBoss;
    private TextView iamWorker;

    private BoldTextView incomeValue;
    private ImageView imageLocation;
    private ImageView bossBody;
    private ImageView workerBody;

    private Button buttonNext;
    private Button buttonPre;


    private MyScrollView scrollView1;

    private int i = 1;
    private View.OnClickListener listener1;
    private View.OnClickListener listener2;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.guide_anim_part1);
        init();
    }


    public void init()
    {

        this.incomeRuler = (RulerVertical)findViewById(R.id.guide_income_ruler);
        this.headLayout = findViewById(R.id.guide_character_split_headline);
        this.incomeLayout = findViewById(R.id.guide_income_layout_text);
        this.cityLayout = findViewById(R.id.guide_city_layout_where);
        this.imageLocation = (ImageView)findViewById(R.id.guide_city_iv_location);
        this.cityName = (TextView)findViewById(R.id.guide_city_tv_city_name);
        this.iamBoss = (TextView)findViewById(R.id.guide_character_tv_i_am_boss);
        this.iamWorker = (TextView)findViewById(R.id.guide_character_tv_i_am_worker);
        this.valuePrefix = (TextView)findViewById(R.id.guide_income_tv_value_prefix);
        this.guidestep = findViewById(R.id.guide_layout_steps);

        this.incomeValue = (BoldTextView)findViewById(R.id.guide_income_tv_value);
        this.incomeValue.setVisibility(View.INVISIBLE);
        this.scrollView1 = (MyScrollView) findViewById(R.id.vtScrollView);

        this.boss = new Boss( findViewById(R.id.guide_character_layout_boss));
        this.bossBody = this.boss.getIvBody();
        this.bossBody.setVisibility(View.INVISIBLE);
        this.worker = new Worker( findViewById(R.id.guide_character_layout_worker));
        this.workerBody = this.worker.getIvBody();
        this.workerBody.setVisibility(View.INVISIBLE);
        this.incomeRuler.setVisibility(View.INVISIBLE);
        this.headLayout.setVisibility(View.INVISIBLE);
        this.cityLayout.setVisibility(View.INVISIBLE);
        this.incomeLayout.setVisibility(View.INVISIBLE);
        this.imageLocation.setVisibility(View.INVISIBLE);
        this.guidestep.setVisibility(View.INVISIBLE);

        this.buttonPre = (Button)findViewById(R.id.guide_btn_step_last);
        this.buttonNext = (Button)findViewById(R.id.guide_btn_step_next);





        bossClick();
        workerClick();


    }

    public void bossClick() {
        //点击boss头像
        boss.getIvHead().setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bossBody.setVisibility(View.VISIBLE);
//                设置不可点击
                boss.getIvHead().setClickable(false);
                worker.getIvHead().setVisibility(View.GONE);
                iamWorker.setVisibility(View.GONE);
                iamBoss.setVisibility(View.GONE);






                Animation alpha = AnimationUtils.loadAnimation(GuidePart1Activity.this,R.anim.my_character_down);
                bossCharater = findViewById(R.id.guide_character_layout_boss);
                bossCharater.startAnimation(alpha);

                incomeLayout.setVisibility(View.VISIBLE);
                incomeRuler.setVisibility(View.VISIBLE);
                guidestep.setVisibility(View.VISIBLE);
                incomeValue.setVisibility(View.VISIBLE);




                listener2 = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(GuidePart1Activity.this, GuidePart2Activity.class);
                        startActivity(intent);


                    }
                };


                listener1 = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        incomeRuler.setVisibility(View.INVISIBLE);
                        incomeLayout.setVisibility(View.INVISIBLE);
                        cityLayout.setVisibility(View.VISIBLE);
                        imageLocation.setVisibility(View.VISIBLE);

                        Animation alpha = AnimationUtils.loadAnimation(GuidePart1Activity.this, R.anim.my_boss_scale);
                        bossCharater.startAnimation(alpha);

                        buttonNext.setOnClickListener(listener2);
                    }
                };
                buttonNext.setOnClickListener(listener1);

                incomeValue.setText("100");

                scrollView1.setScrollViewListener(
                        new MyScrollView.OnScrollChangedListener() {

                            @Override
                            public void onScrollChanged(MyScrollView view, int l, int t, int oldl, int oldt) {

                                // 将滑动距离进行百分制划分，与图片刻度对其
                                float value =  (float)t / 660  ;
                                int value2 = 100- (int) (value*100);
                                if( value2 == 0) {
                                    value2 = value2+1;
                                }
                                incomeValue.setText(String.valueOf(value2));
//                                Toast.makeText(getApplicationContext(), String.valueOf(value2), Toast.LENGTH_LONG).show();
                            }
                        }
                );

            }
        });
    }

    public void workerClick() {
        //点击worker头像
        worker.getIvHead().setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                workerBody.setVisibility(View.VISIBLE);
//                设置不可点击
                worker.getIvHead().setClickable(false);
                boss.getIvHead().setVisibility(View.GONE);
                iamWorker.setVisibility(View.GONE);
                iamBoss.setVisibility(View.GONE);






                Animation alpha = AnimationUtils.loadAnimation(GuidePart1Activity.this,R.anim.my_character_up);
                workerCharater = findViewById(R.id.guide_character_layout_worker);
                workerCharater.startAnimation(alpha);



                ImageView imageView = (ImageView) findViewById(R.id.ruler_value_iv);
                imageView.setImageResource(R.drawable.guide_ruler_vertical_value_worker);


                incomeLayout.setVisibility(View.VISIBLE);
                incomeRuler.setVisibility(View.VISIBLE);
                incomeValue.setVisibility(View.VISIBLE);
                guidestep.setVisibility(View.VISIBLE);



                listener2 = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(GuidePart1Activity.this, GuidePart2Activity.class);
                        startActivity(intent);


                    }
                };


                listener1 = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        incomeRuler.setVisibility(View.INVISIBLE);
                        incomeLayout.setVisibility(View.INVISIBLE);
                        cityLayout.setVisibility(View.VISIBLE);
                        imageLocation.setVisibility(View.VISIBLE);

                        Animation alpha = AnimationUtils.loadAnimation(GuidePart1Activity.this, R.anim.my_worker_scale);
                        workerCharater.startAnimation(alpha);

                        buttonNext.setOnClickListener(listener2);
                    }
                };
                buttonNext.setOnClickListener(listener1);




                scrollView1.setScrollViewListener(
                        new MyScrollView.OnScrollChangedListener() {

                            @Override
                            public void onScrollChanged(MyScrollView view, int l, int t, int oldl, int oldt) {
                                BoldTextView boldTextView =  (BoldTextView) findViewById(R.id.guide_income_tv_value);
                                // 将滑动距离进行百分制划分，与图片刻度对其
                                float value =  (float)t / 660  ;
                                int value2 = 50- (int) (value*50);
                                if( value2 == 0) {
                                    value2 = value2+1;
                                }
                                incomeValue.setText(String.valueOf(value2));
//                                Toast.makeText(getApplicationContext(), String.valueOf(value2), Toast.LENGTH_LONG).show();
                            }
                        }
                );


            }
        });
    }



}
