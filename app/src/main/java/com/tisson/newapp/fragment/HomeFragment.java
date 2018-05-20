package com.tisson.newapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tisson.newapp.R;
import com.tisson.newapp.fragment.inter.OnFragmentInteractionListener;

import static android.support.design.widget.TabLayout.*;


public class HomeFragment extends BasicFragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    protected OnFragmentInteractionListener mListener;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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



    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }


    private RecyclerView mRv;

    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void initView() {



        mRv = (RecyclerView)findView(R.id.home_fragment_rl_home_recycler_view);

        mRv.setLayoutManager(new LinearLayoutManager(getContext()));

        HomeAdapter adapter = new HomeAdapter();
        mRv.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout)findView(R.id.home_fragment_srl_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // do something, such as re-request from server or other
//            TODO 加载数据的地方 ，完成后调用
                swipeRefreshLayout.setRefreshing(false);


            }
        });





    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        /**
         * pull data
         */
        pullData();

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
     * pull data
     */
    String[] data;
    private void pullData(){

        data = new String[]{"Hello world","hello I am wongkyunban","wongkyunban world","wongkyun test","test something","one hundred","88888","this is a new world","no one die,no one live"};
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{

        private View mView;
        public HomeViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        @SuppressWarnings("unchecked")
        private <T extends View>T findItemView(int resId){
            return (T)mView.findViewById(resId);
        }
    }

    public class HomeAdapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_fragment,parent,false);
            HomeViewHolder mVHolder = new HomeViewHolder(view);
            mVHolder.mView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {


                    String txt = ((TextView)v.findViewById(R.id.item_home_fragment_tv_content)).getText().toString();
                    Toast.makeText(getActivity(),txt,Toast.LENGTH_SHORT).show();
                }
            });
            return mVHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            HomeViewHolder vHolder = (HomeViewHolder)holder;
            TextView tv = vHolder.findItemView(R.id.item_home_fragment_tv_content);
            tv.setText(data[position]);
            ImageView iv = vHolder.findItemView(R.id.item_home_fragment_iv_image);

        }

        @Override
        public int getItemCount() {
            return data.length;
        }
    }

}
