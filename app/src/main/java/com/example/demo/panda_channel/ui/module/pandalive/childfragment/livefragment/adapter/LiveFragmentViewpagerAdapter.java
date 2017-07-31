package com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class LiveFragmentViewpagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> list;
    String[] str ={"多视角直播","边看边聊"};
    public LiveFragmentViewpagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
