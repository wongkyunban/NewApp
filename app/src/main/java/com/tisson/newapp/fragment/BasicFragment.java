package com.tisson.newapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BasicFragment extends Fragment {

     private View mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(mView == null){

//            mView = LayoutInflater.from(context).inflate(getLayout(),null);
        }
    }

   @Nullable
    @Override
    final public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

       mView = inflater.inflate(getLayout(),container,false);

       return mView;
   }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View>T findView(int resId){
        return (T)mView.findViewById(resId);
    }

    /**
     *
     * @return layout id
     */
    protected abstract int getLayout();

    /**
     * 初始化视图
     */
    protected abstract void initView();
}
