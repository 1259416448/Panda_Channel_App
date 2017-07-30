package com.example.demo.panda_channel.ui.module.home;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 闫雨婷 on 2017/7/30.
 */

public class MyLoader extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load((String) path).into(imageView);
    }
}
