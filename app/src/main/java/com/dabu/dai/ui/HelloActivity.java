package com.dabu.dai.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.dabu.dai.R;

/**
 * Created by HIPAA on 2015/5/13.
 */
public class HelloActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_layout);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return FirstHello.newInstance("FirstFragment, Instance 1");
                case 1:
                    return SecondHello.newInstance("SecondFragment, Instance 1");
                case 2:
                    return ThirdHello.newInstance("ThirdFragment, Instance 1");
                case 3:
                    return FourthHello.newInstance("ThirdFragment, Instance 1");
                default:
                    return ThirdHello.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
