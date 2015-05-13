package com.dabu.dai.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabu.dai.R;

/**
 * Created by HIPAA on 2015/5/13.
 */
public class ThirdHello extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.third_hello, container, false);

        return v;
    }


}
