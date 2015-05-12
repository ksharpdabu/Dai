package com.dabu.dai.ui_custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by HIPAA on 2015/4/22.
 */
public class MyScrollView extends ScrollView  {

    private OnScrollChangedListener scrollViewListener    ;


    public MyScrollView(Context context) {
        super(context);
        setScrollBar();
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScrollBar();
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setScrollBar();

    }



    //设置接口来暴露方法
    public interface OnScrollChangedListener {
        void onScrollChanged(MyScrollView view, int l, int t, int oldl, int oldt);

    }



    public void setScrollViewListener(OnScrollChangedListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }



    //设置不显示滚动条
    public void setScrollBar() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
    }


//    protected int computeVtScrollOffset() {
//        return computeVerticalScrollOffset();
//    }


    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(  l,   t,   oldl,   oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this,  l,   t,   oldl,   oldt);
        }
    }
}
