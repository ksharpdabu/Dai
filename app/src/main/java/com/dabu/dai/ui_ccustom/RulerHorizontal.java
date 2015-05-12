package com.dabu.dai.ui_ccustom;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by HIPAA on 2015/4/24.
 */
public class RulerHorizontal extends Ruler {
//    private MyHzScrollView scrollView1;

    public RulerHorizontal(Context paramContext ) {
        super(paramContext,1);
//        getscrollValue();
    }

    public RulerHorizontal(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet,1);
//        getscrollValue();
    }




    //获取尺子滑动的距离
//    public void getscrollValue() {
//        scrollView1 = (MyHzScrollView) findViewById(R.id.hzScrollView);
//
//
//        scrollView1.setHzScrollViewListener(
//                new MyHzScrollView.OnHzScrollChangedListener() {
//                    public void onScrollChanged((MyScrollView view, int l, int t, int oldl, int oldt) {
//
//                        // 将滑动距离进行百分制划分，与图片刻度对其
//                        float value =  (float)l / 660  ;
//                        int value2 = (int) (value*100);
//                        if(value2 <=55) {
//                            value2 = value2+1;
//                        }
//
//                        Toast.makeText(getContext(), String.valueOf(value2), Toast.LENGTH_LONG).show();
//
//                    }
//
//
//                }
//
//        );
//    }
}
