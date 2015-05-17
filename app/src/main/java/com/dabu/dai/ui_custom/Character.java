package com.dabu.dai.ui_custom;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by HIPAA on 2015/4/20.
 */
public class Character {
    protected ImageView mIvBody;
    protected ImageView mIvHead;
    protected View mLayout;
    protected View mRootView;
    protected int mType;

    public Character() {
    }

    public Character(View paramView) {
        this.mRootView = paramView;
    }

    public View findViewById(int paramInt) {
        if (this.mRootView != null)
            return this.mRootView.findViewById(paramInt);
        return null;
    }

    public ImageView getIvBody() {
        return this.mIvBody;
    }

    public ImageView getIvHead() {
        return this.mIvHead;
    }

    public View getLayout() {
        return this.mLayout;
    }


}

