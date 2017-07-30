package com.example.demo.panda_channel.ui.module.pandalive;

import android.support.design.widget.TabLayout;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.widget.view.CustomViewPager;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.View {
    @BindView(R.id.pandalive_tablayout)
    TabLayout pandaliveTablayout;
    @BindView(R.id.pandalive_viewpager)
    CustomViewPager pandaliveViewpager;//
    @Override
    protected int getLayoutId() {
        return R.layout.pandalive_fragment;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setPresenter(PandaLiveContract.Presenter presenter) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
