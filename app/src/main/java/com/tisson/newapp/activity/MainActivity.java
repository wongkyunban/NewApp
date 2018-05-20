package com.tisson.newapp.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.tisson.newapp.R;
import com.tisson.newapp.fragment.HomeFragment;
import com.tisson.newapp.fragment.LiveFragment;
import com.tisson.newapp.fragment.MessageFragment;
import com.tisson.newapp.fragment.MoreFragment;
import com.tisson.newapp.fragment.inter.OnFragmentInteractionListener;

public class MainActivity extends BasicActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnFragmentInteractionListener {

    private TextView mTextMessage;
    private Toolbar toolbar;
    private Fragment[] fragments = new Fragment[4];


    /*home fragemnt index*/
    private final int HOME_INDEX = 0;

    /*more fragment index*/
    private final int MORE_INDEX = 1;

    /*message fragment index*/
    private final int MESSAGE_INDEX = 2;

    /*live fragment index*/
    private final int LIVE_INDEX = 3;

    /*记录当前fragment的index*/
    private int tempFragmentIndex = -1;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle(R.string.title_home);

                    addFragment(HOME_INDEX);

                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle(R.string.title_dashboard);
                    addFragment(MORE_INDEX);


                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle(R.string.title_notifications);
                    addFragment(MESSAGE_INDEX);

                    return true;
                case R.id.navigation_live:
                    toolbar.setTitle(R.string.title_live);
                    addFragment(LIVE_INDEX);

                    return true;
            }
            return false;
        }
    };


    /**
     * add the fragment that index specified
     * @param index
     */

    private void addFragment(int index){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        /**
         * 相等说明，当前fragnt is that you want.
         */
        if(tempFragmentIndex == index) return;

        /**
         * update the current index of fragment
         */
        tempFragmentIndex = index;

        if(transaction == null) return;

        hideFragment(fragments,transaction);


        if(fragments[index] == null){
            switch(index){
                case HOME_INDEX:
                    fragments[HOME_INDEX] = HomeFragment.newInstance("home", "home");
                    transaction.add(R.id.main_fl_container,fragments[HOME_INDEX]).commit();

                    return;
                case MORE_INDEX:
                    fragments[MORE_INDEX] = MoreFragment.newInstance("home1", "home1");
                    transaction.add(R.id.main_fl_container,fragments[MORE_INDEX]).commit();

                    return;
                case MESSAGE_INDEX:
                    fragments[MESSAGE_INDEX] = MessageFragment.newInstance("home2","home2");
                    transaction.add(R.id.main_fl_container,fragments[MESSAGE_INDEX]).commit();

                    return;
                case LIVE_INDEX:
                    fragments[LIVE_INDEX] = LiveFragment.newInstance("home2","home2");
                    transaction.add(R.id.main_fl_container,fragments[LIVE_INDEX]).commit();

                    return;
            }
        }


        transaction.show(fragments[index]);
        transaction.commit();

    }


    /*隐藏所有的fragment*/
    private void hideFragment(Fragment[] fragments,FragmentTransaction transaction){
        if( transaction == null || fragments.length == 0) return;

        for(Fragment f :fragments){
            if(f != null){
                transaction.hide(f);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        toolbar.setTitle("首页");

        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_search:
                        Toast.makeText(MainActivity.this,"I am search",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addFragment(HOME_INDEX);



    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * interface OnFragmentInteractionListener
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
