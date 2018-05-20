package com.tisson.newapp.fragment;


import android.support.v4.app.Fragment;

import com.tisson.newapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenSourceFragment extends BasicFragment {

    public static OpenSourceFragment newInstance() {
        OpenSourceFragment fragment = new OpenSourceFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_open_source;
    }

    @Override
    protected void initView() {

    }

}
