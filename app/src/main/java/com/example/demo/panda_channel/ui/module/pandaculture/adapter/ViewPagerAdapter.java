package com.example.demo.panda_channel.ui.module.pandaculture.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/7/31.
 */

public class ViewPagerAdapter extends PagerAdapter{
    private ArrayList<View> list;

    public ViewPagerAdapter(ArrayList<View> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newspostion =position%list.size();
        container.addView(list.get(newspostion));
        return list.get(newspostion);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
