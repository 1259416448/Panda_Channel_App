package com.example.demo.panda_channel.activity.settingactivity.userfeedback.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/22.
 */

public class UserfeedbackAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private String[] str={"遇到的问题","常见问题"};
    public UserfeedbackAdapter(FragmentManager fm, ArrayList<Fragment> list) {
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
