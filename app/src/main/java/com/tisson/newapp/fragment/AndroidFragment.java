package com.tisson.newapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tisson.newapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends BasicFragment {

    public static AndroidFragment newInstance() {
        AndroidFragment fragment = new AndroidFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_android;
    }

    @Override
    protected void initView() {

    }

}
