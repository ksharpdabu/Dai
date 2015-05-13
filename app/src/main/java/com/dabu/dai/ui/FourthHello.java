package com.dabu.dai.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabu.dai.R;

/**
 * Created by HIPAA on 2015/5/13.
 */
public class FourthHello extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fourth_hello, container, false);



        View apply = (View)v.findViewById(R.id.help_viewpager_btn_start);

        apply.setOnClickListener( new View.OnClickListener() {
            public void  onClick(View v) {
                Intent intent = new Intent( getActivity() , Register.class);
                startActivity(intent);

            }
        });

        return v;
    }


}
