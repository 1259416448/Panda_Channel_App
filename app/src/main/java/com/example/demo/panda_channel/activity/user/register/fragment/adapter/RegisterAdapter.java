package com.example.demo.panda_channel.activity.user.register.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/15.
 */

public class RegisterAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private String[] str={"手机注册","邮箱注册"};
    public RegisterAdapter(FragmentManager fm, ArrayList<Fragment> list) {
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
