package com.tisson.newapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tisson.newapp.activity.BasicActivity;
import com.tisson.newapp.R;
import com.tisson.newapp.fragment.inter.OnFragmentInteractionListener;


public class MoreFragment extends BasicFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private BasicFragment[] bFragments = new BasicFragment[]{
            AndroidFragment.newInstance(),
            OpenSourceFragment.newInstance(),
            BigDataFragment.newInstance(),
            AIFragment.newInstance()
    };

    public MoreFragment() {

        // Required empty public constructor
    }


    private ViewPager mViewPager;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    /*android tab index*/
    public final int ANDROID_INDEX = 0;

    /*open source tab index*/
    public final int OPEN_SOURCE_INDEX = 1;

    /*big data tab index*/
    public final int BIG_DATA_INDEX = 2;

    /*ai tab index*/
    public final int AI_INDEX = 3;


    /**
     * @return 返回布局
     */
    @Override
    protected int getLayout() {
        return R.layout.fragment_more;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        TabLayout tabLayout = findView(R.id.fragment_more_tl_tab_layout);

        mViewPager = findView(R.id.fragment_more_vp_viewPager);
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(mActivity.getSupportFragmentManager());


        mViewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.removeAllTabs();


        /*android*/
//        TabLayout.Tab androidTab = tabLayout.newTab();
//        androidTab.setText(R.string.tab_android);
//        tabLayout.addTab(androidTab, ANDROID_INDEX, true);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_android),ANDROID_INDEX,true);


        /*open source*/
//        TabLayout.Tab openSourceTab = tabLayout.newTab();
//        openSourceTab.setText(R.string.tab_open_source);
//        tabLayout.addTab(openSourceTab, OPEN_SOURCE_INDEX);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_open_source),OPEN_SOURCE_INDEX);


        /*big data*/
//        TabLayout.Tab bigDataTab = tabLayout.newTab();
//        bigDataTab.setText(R.string.tab_big_data);
//        tabLayout.addTab(bigDataTab, BIG_DATA_INDEX);.setText(R.string.tab_big_data)

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_big_data),BIG_DATA_INDEX);


        /*ai*/
//        TabLayout.Tab AITab = tabLayout.newTab();
//        AITab.setText(R.string.tab_ai);
//        tabLayout.addTab(AITab, AI_INDEX);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_ai),AI_INDEX);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getActivity(), tab.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        /*默认选中android*/
        tabLayout.getTabAt(ANDROID_INDEX).select();


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private BasicActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        TODO
        mActivity = (BasicActivity) context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return bFragments[position];
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return bFragments.length;
        }


    }


}
