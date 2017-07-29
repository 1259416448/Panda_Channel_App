package com.example.demo.panda_channel.utils;

import android.util.Log;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class LogUtils {
    private static boolean isOpen = true;
    public static void e(String tag,String msg){
        if(isOpen)
            Log.e(tag,msg);
    }
    public static void d(String tag,String msg){
        if(isOpen)
            Log.d(tag,msg);
    }
}
