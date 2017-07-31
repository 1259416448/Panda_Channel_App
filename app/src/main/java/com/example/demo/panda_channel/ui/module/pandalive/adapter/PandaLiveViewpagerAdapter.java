package com.example.demo.panda_channel.ui.module.pandalive.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class PandaLiveViewpagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> list;
    private ArrayList<String> str;
    public PandaLiveViewpagerAdapter(FragmentManager fm,ArrayList<Fragment> list,ArrayList<String> str) {
        super(fm);
        this.list=list;
        this.str=str;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    public CharSequence getPageTitle(int position) {
        return str.get(position);
    }
}
