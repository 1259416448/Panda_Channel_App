package com.example.demo.panda_channel.ui.module.livechina;

import android.support.v4.app.Fragment;
import android.widget.Button;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.GildViewAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.LiveChinaViewPagerAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.UnGildViewAdapter;
import com.example.demo.panda_channel.widget.view.MyGridView;
import com.example.demo.panda_channel.widget.view.MyUnSelectGridView;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface LiveChinaContract {
    interface View extends BaseView<Presenter> {
        void ShowChildFragmentAllBean(ChildFragmentAllBean childFragmentAllBean);
        void setError(String msg);
        void bombWindow();

    }

    interface Presenter extends BasePresenter {
        void getData();
        void setBtBianjilogic(String textView,
                              Button button,
                              MyGridView myGridView,
                              MyUnSelectGridView myUnSelectGridView,
                              ArrayList<ChildFragmentAllBean.TablistBean> arr,
                              GildViewAdapter gildViewAdapter,
                              UnGildViewAdapter unGildViewAdapter,
                              LiveChinaViewPagerAdapter liveChinaViewPagerAdapter);

        void setUnselectGridvie(String textView,
                                ArrayList<Fragment> fragments,
                              ArrayList<ChildFragmentAllBean.TablistBean> arr,
                              GildViewAdapter gildViewAdapter,
                              ArrayList<ChildFragmentAllBean.AlllistBean> list,
                              UnGildViewAdapter unGildViewAdapter,
                              LiveChinaViewPagerAdapter liveChinaViewPagerAdapter,
                              int i);
        void setSelectGridview(String textView,
                               ArrayList<Fragment> fragments,
                               ArrayList<ChildFragmentAllBean.TablistBean> arr,
                               GildViewAdapter gildViewAdapter,
                               ArrayList<ChildFragmentAllBean.AlllistBean> list,
                               UnGildViewAdapter unGildViewAdapter,
                               LiveChinaViewPagerAdapter liveChinaViewPagerAdapter,
                               int i);
    }

}
