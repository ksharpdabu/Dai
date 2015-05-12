package com.dabu.dai.ui_ccustom;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HIPAA on 2015/4/20.
 */
public class BoldTextView extends TextView {

    private TextPaint paint;

    public BoldTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        getPaint().setFakeBoldText(true);
    }



    public BoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        getPaint().setFakeBoldText(true);
    }


    public BoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        getPaint().setFakeBoldText(true);
    }
}
