package com.example.demo.panda_channel.ui.module.home;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.HomeData;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void setListData(HomeData homeData);
        void showMessage(String msg);
    }

    interface Presenter extends BasePresenter {

    }

}
