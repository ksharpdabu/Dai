package com.dabu.dai.ui_custom;

import android.content.Context;
import android.util.AttributeSet;


/**
 * Created by HIPAA on 2015/4/20.
 */
public class RulerVertical extends Ruler{

//    private MyScrollView scrollView1;




    public RulerVertical(Context paramContext) {
        super(paramContext,0);
//        getscrollData();
    }

    public RulerVertical(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet, 0);
//        getscrollData();
    }

    //获取尺子滑动的距离
//    public void getscrollData() {
//
//        scrollView1 = (MyScrollView) findViewById(R.id.vtScrollView);

//
//        scrollView1.setScrollViewListener(
//             new MyScrollView.OnScrollChangedListener() {
//
//                 @Override
//                 public void onScrollChanged(MyScrollView view, int l, int t, int oldl, int oldt) {
//                      BoldTextView boldTextView =  (BoldTextView) findViewById(R.id.guide_income_tv_value);
//                     // 将滑动距离进行百分制划分，与图片刻度对其
//                     float value =  (float)t *(view.getMaxScrollAmount()/100)  ;
//
//                     int value2 =  (int)(100F-value/20);
//
//                     string = String.valueOf(value2);
//
//
//
//
//                     Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();
//                 }
//             }
//        );
//
//    }




}