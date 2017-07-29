package com.example.demo.panda_channel.ui.module.livechina;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.LiveChinaViewPagerAdapter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildPresenter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildfragmentFragment;
import com.example.demo.panda_channel.widget.view.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.live_china_tab)
    TabLayout liveChinaTab;
    @BindView(R.id.live_china_plus)
    ImageView liveChinaPlus;
    @BindView(R.id.live_china_viewpager)
    CustomViewPager liveChinaViewpager;

    private LiveChinaContract.Presenter presenter;
    private ArrayList<ChildFragmentAllBean.TablistBean> arr;
    private ArrayList<Fragment> fragments;
    private LiveChinaViewPagerAdapter pagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {
        arr = new ArrayList<>();
        fragments = new ArrayList<>();
        pagerAdapter = new LiveChinaViewPagerAdapter(getChildFragmentManager(),fragments,arr);
        liveChinaViewpager.setAdapter(pagerAdapter);
        liveChinaViewpager.setScanScroll(false);
        liveChinaTab.setupWithViewPager(liveChinaViewpager);
        liveChinaTab.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void loadData() {
        presenter.start();


    }


    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
    this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }


    @Override
    public void ShowChildFragmentAllBean(ChildFragmentAllBean childFragmentAllBean) {
        arr.addAll(childFragmentAllBean.getTablist());
        for (int i = 0; i < childFragmentAllBean.getTablist().size(); i++) {
            ChildfragmentFragment childfragment = new ChildfragmentFragment(arr.get(i).getUrl());
            new ChildPresenter(childfragment);
            fragments.add(childfragment);
        }
        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError(String msg) {

    }

    @Override
    public void bombWindow() {
        liveChinaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View inflate = View.inflate(getContext(), R.layout.activity_plus, null);

            }
        });

    }
}
