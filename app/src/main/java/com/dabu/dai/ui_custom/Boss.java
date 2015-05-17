package com.dabu.dai.ui_custom;

import android.view.View;
import android.widget.ImageView;

import com.dabu.dai.R;


/**
 * Created by HIPAA on 2015/4/20.
 */
public class Boss extends Character {
    public Boss(View paramView)
    {
        super(paramView);
        this.mType = 1;
        this.mLayout = findViewById(R.id.guide_character_layout_boss);
        this.mIvHead = (ImageView) findViewById(R.id.guide_character_iv_boss_head);
        this.mIvBody = (ImageView) findViewById(R.id.guide_character_iv_boss_body);
    }


}