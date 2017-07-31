package com.example.demo.panda_channel.ui.module.livechina;

import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModel;
import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModellmpl;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.GildViewAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.LiveChinaViewPagerAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.UnGildViewAdapter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildPresenter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildfragmentFragment;
import com.example.demo.panda_channel.widget.view.MyGridView;
import com.example.demo.panda_channel.widget.view.MyUnSelectGridView;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class LiveChinaPresenter implements LiveChinaContract.Presenter{
    private LiveChinaContract.View view;
    private LiveChinaModel chinaModel;
    public LiveChinaPresenter(LiveChinaContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        chinaModel=new LiveChinaModellmpl();
    }

    @Override
    public void start() {
        view.bombWindow();


    }

    @Override
    public void getData() {
        chinaModel.getChildFragmentAllBean(new MyNetWorkCallBack<ChildFragmentAllBean>() {
            @Override
            public void onSuccess(ChildFragmentAllBean childFragmentAllBean) {
                view.ShowChildFragmentAllBean(childFragmentAllBean);

            }

            @Override
            public void onError(String errorMsg) {
                view.setError(errorMsg);
            }
        });
    }

    @Override
    public void setBtBianjilogic(String textView, Button button, MyGridView myGridView, MyUnSelectGridView myUnSelectGridView, ArrayList<ChildFragmentAllBean.TablistBean> arr, GildViewAdapter gildViewAdapter, UnGildViewAdapter unGildViewAdapter,LiveChinaViewPagerAdapter liveChinaViewPagerAdapter) {

        if(textView.equals("编辑")){
            myGridView.setEnabled(true);
            button.setText("完成");
            for (int i = 0; i < arr.size(); i++) {
                arr.get(i).setFlag(true);
            }
            gildViewAdapter.notifyDataSetChanged();
            unGildViewAdapter.notifyDataSetChanged();

        }else if(textView.equals("完成")){
            for (int i = 0; i < arr.size(); i++) {
                arr.get(i).setFlag(false);
            }
            gildViewAdapter.notifyDataSetChanged();
            unGildViewAdapter.notifyDataSetChanged();
            liveChinaViewPagerAdapter.notifyDataSetChanged();
            myGridView.setEnabled(false);
            button.setText("编辑");
        }
    }

    @Override
    public void setUnselectGridvie(String textView, ArrayList<Fragment> fragments,  ArrayList<ChildFragmentAllBean.TablistBean> arr, GildViewAdapter gildViewAdapter, ArrayList<ChildFragmentAllBean.AlllistBean> list, UnGildViewAdapter unGildViewAdapter, LiveChinaViewPagerAdapter liveChinaViewPagerAdapter,int i) {
        if(textView.equals("完成")){

            ChildFragmentAllBean.TablistBean tablistBean=new ChildFragmentAllBean.TablistBean();
            tablistBean.setTitle(list.get(i).getTitle());
            tablistBean.setUrl(list.get(i).getUrl());
            tablistBean.setOrder(list.get(i).getOrder());
            tablistBean.setType(list.get(i).getType());
            arr.add(tablistBean);
            ChildfragmentFragment childfragment = new ChildfragmentFragment(tablistBean.getUrl());
            new ChildPresenter(childfragment);
            fragments.add(childfragment);
            for (int  x= 0; x < arr.size(); x++) {
                arr.get(x).setFlag(true);
            }
            list.remove(list.get(i));
            liveChinaViewPagerAdapter.notifyDataSetChanged();
            gildViewAdapter.notifyDataSetChanged();
            unGildViewAdapter.notifyDataSetChanged();


        }
    }

    @Override
    public void setSelectGridview(String textView, ArrayList<Fragment> fragments, ArrayList<ChildFragmentAllBean.TablistBean> arr, GildViewAdapter gildViewAdapter, ArrayList<ChildFragmentAllBean.AlllistBean> list, UnGildViewAdapter unGildViewAdapter, LiveChinaViewPagerAdapter liveChinaViewPagerAdapter, int i) {
        if(textView.equals("完成")) {
            if (arr.size() < 5) {
                Toast.makeText(App.context, "栏目区，不能少于四个频道", Toast.LENGTH_SHORT).show();
            } else {

                ChildFragmentAllBean.AlllistBean all = new ChildFragmentAllBean.AlllistBean();
                all.setTitle(arr.get(i).getTitle());
                all.setUrl(arr.get(i).getUrl());
                all.setOrder(arr.get(i).getOrder());
                all.setType(arr.get(i).getType());
                list.add(all);

                gildViewAdapter.notifyDataSetChanged();
                unGildViewAdapter.notifyDataSetChanged();
                arr.remove(arr.get(i));
                fragments.remove(fragments.get(i));
                liveChinaViewPagerAdapter.notifyDataSetChanged();

            }
        }
    }
}
