package com.tisson.newapp.fragment;


import android.support.v4.app.Fragment;


import com.tisson.newapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BigDataFragment extends BasicFragment {

    public static BigDataFragment newInstance() {
        BigDataFragment fragment = new BigDataFragment();
        return fragment;
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_big_data;
    }

    @Override
    protected void initView() {

    }

}
