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
public class FirstHello extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_hello, container, false);

//        TextView tv = (TextView) v.findViewById(R.id.tvFragFirst);
//        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static FirstHello newInstance(String text) {

        FirstHello f = new FirstHello();
        Bundle b = new Bundle();
        b.putString("msg", text);

//        f.setArguments(b);

        return f;
    }
}
