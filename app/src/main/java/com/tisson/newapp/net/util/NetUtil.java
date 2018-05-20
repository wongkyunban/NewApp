package com.tisson.newapp.net.util;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {


    /**
     * inspect network connection
     * 检查网络连接
     * @param context
     * @return boolean
     */
    public static boolean isConnectedToNetwork(Context context){
        boolean connected = false;
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm != null){
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if(ni != null){
                connected = ni.isConnected();
            }
        }
        return connected;
    }
}
