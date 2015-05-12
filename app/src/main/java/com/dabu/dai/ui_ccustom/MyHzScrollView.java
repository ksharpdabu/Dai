package com.dabu.dai.ui_ccustom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;


/**
 * Created by HIPAA on 2015/4/24.
 */
public class MyHzScrollView extends HorizontalScrollView {
    private OnHzScrollChangedListener HzScrollViewListener = null;


    public MyHzScrollView(Context context) {
        super(context);
        setScrollBar();
    }

    public MyHzScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setScrollBar();

    }

    public MyHzScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScrollBar();
    }

    //设置接口来暴露方法
    public interface OnHzScrollChangedListener {
        void onScrollChanged(MyHzScrollView view, int l, int t, int oldl, int oldt);

    }

    public void setHzScrollViewListener(OnHzScrollChangedListener HzScrollViewListener) {
        this.HzScrollViewListener = HzScrollViewListener;
    }

    //设置不显示滚动条
    public void setScrollBar() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
    }

    protected int computeVtScrollOffset() {
        return computeVerticalScrollOffset();
    }


    protected void onScrollChanged( int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t , oldl , oldl);
        if (HzScrollViewListener != null) {


            HzScrollViewListener.onScrollChanged(this, l, t , oldl , oldl);
        }
    }

}
