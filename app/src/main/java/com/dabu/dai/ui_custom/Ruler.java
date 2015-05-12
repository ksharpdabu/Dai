package com.dabu.dai.ui_custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/20.
 */
public abstract class Ruler extends RelativeLayout {
    protected ImageView a;

    public Ruler(Context paramContext, int i) {
        super(paramContext);
        init(i);
    }

    public Ruler(Context paramContext, AttributeSet paramAttributeSet,int i) {
        super(paramContext, paramAttributeSet);
        init(i);
    }

    public Ruler(Context paramContext, AttributeSet paramAttributeSet, int paramInt,int i) {
        super(paramContext, paramAttributeSet, paramInt);
        init(i);
    }


    protected void init(int i) {
        if( i == 0) {


            //显示尺子scrollView
            View localView = LayoutInflater.from(getContext()).inflate(R.layout.ruler_vt_srollview, null);

            this.a = ((ImageView) localView.findViewById(R.id.ruler_value_iv));
            this.a.setImageResource(R.drawable.guide_ruler_vertical_value_boss);


            //显示尺子背景图片
            View rulerBgView = LayoutInflater.from(getContext()).inflate(R.layout.ruler_vertical_bg, null);


            addView(rulerBgView);
            addView(localView);
        } else if(i == 1) {
            //显示尺子scrollView
            View localView = LayoutInflater.from(getContext()).inflate(R.layout.ruler_hz_scrollview, null);

            //显示尺子背景图片
            View rulerBgView = LayoutInflater.from(getContext()).inflate(R.layout.ruler_horizontal_bg, null);


            addView(rulerBgView);
            addView(localView);

        }
    }

    public void a(int paramInt) {
        this.a.setImageResource(paramInt);
    }

    public void a(int paramInt1, int paramInt2) {
        scrollTo(paramInt1, paramInt2);
    }
}