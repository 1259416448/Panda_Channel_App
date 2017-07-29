package com.example.demo.panda_channel.widget.manager;

import android.widget.Toast;

import com.example.demo.panda_channel.app.App;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class ToastManager {
    public static void show(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_LONG).show();
    }
}
