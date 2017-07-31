package com.example.demo.panda_channel.ui.module.pandalive;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.PandaLiveTablyoutData;
import com.example.demo.panda_channel.ui.module.pandalive.adapter.PandaLiveViewpagerAdapter;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment.LiveFragment;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment.ModuleFragment;
import com.example.demo.panda_channel.utils.ACache;
import com.example.demo.panda_channel.widget.view.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.View {
    private PandaLiveContract.Presenter presenter;
    private ArrayList<Fragment> list;
    private ArrayList<String> strlist=new ArrayList<>();
    @BindView(R.id.pandalive_tablayout)
    TabLayout pandaliveTablayout;
    @BindView(R.id.pandalive_viewpager)
    CustomViewPager pandaliveViewpager;
    PandaLiveViewpagerAdapter adapter;
    @Override
    protected int getLayoutId() {
        new PandaLivePresenter(this);
        return R.layout.pandalive_fragment;
    }

    @Override
    protected void init(View view) {

        presenter.start();
        list=new ArrayList<>();


    }

    @Override
    protected void loadData() {


    }

    @Override
    public void setPresenter(PandaLiveContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void Success(PandaLiveTablyoutData pandaLiveTablyoutData) {
        for (int i=0;i<pandaLiveTablyoutData.getTablist().size();i++) {
            strlist.add(pandaLiveTablyoutData.getTablist().get(i).getTitle());
        }
        pandaliveViewpager.setScanScroll(false);
        adapter =new PandaLiveViewpagerAdapter(getFragmentManager(),list,strlist);
        pandaliveViewpager.setAdapter(adapter);
        pandaliveTablayout.setupWithViewPager(pandaliveViewpager);
        pandaliveTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        LiveFragment livefragment=new LiveFragment();
        list.clear();
        list.add(livefragment);
        for (int i=1;i<pandaLiveTablyoutData.getTablist().size();i++){
            ModuleFragment fragment=new ModuleFragment(pandaLiveTablyoutData.getTablist().get(i).getId());
            list.add(fragment);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String msg) {
        ACache aCache = ACache.get(App.context);
        PandaLiveTablyoutData pandaLiveTablyoutData = (PandaLiveTablyoutData) aCache.getAsObject("PandaLiveTablyoutData");
        for (int i=0;i<pandaLiveTablyoutData.getTablist().size();i++) {
            strlist.add(pandaLiveTablyoutData.getTablist().get(i).getTitle());
        }
        pandaliveViewpager.setScanScroll(false);
        adapter =new PandaLiveViewpagerAdapter(getFragmentManager(),list,strlist);
        pandaliveViewpager.setAdapter(adapter);

        pandaliveTablayout.setupWithViewPager(pandaliveViewpager);
        pandaliveTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        LiveFragment livefragment=new LiveFragment();
        list.clear();
        list.add(livefragment);
        for (int i=1;i<pandaLiveTablyoutData.getTablist().size();i++){
            ModuleFragment fragment=new ModuleFragment(pandaLiveTablyoutData.getTablist().get(i).getId());
            list.add(fragment);
        }
        adapter.notifyDataSetChanged();
    }
}
