package com.dabu.dai.ui_custom;

import android.view.View;
import android.widget.ImageView;

import com.haodai.quickloan.R;

/**
 * Created by HIPAA on 2015/4/20.
 */
public class Worker extends Character {
    public Worker(View paramView)
    {
        super(paramView);
        this.mType = 0;
        this.mLayout = findViewById(R.id.guide_character_layout_worker);
        this.mIvHead = ((ImageView)findViewById(R.id.guide_character_iv_worker_head));
        this.mIvBody = ((ImageView)findViewById(R.id.guide_character_iv_worker_body));
    }
}