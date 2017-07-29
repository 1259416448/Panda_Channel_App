package com.example.demo.panda_channel.ui.module.home;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View homeView;
    private PandaChannelModel model;

    public HomePresenter(HomeContract.View homeView) {
        this.homeView = homeView;
        homeView.setPresenter(this);
        this.model = new PandaChannelModelImpl();

    }

    @Override
    public void start() {
        homeView.showProgress();
        model.getHomeData(new MyNetWorkCallBack<HomeData>() {
            @Override
            public void onSuccess(HomeData homeData) {
                homeView.setListData(homeData);
                homeView.dismissProgress();
            }

            @Override
            public void onError(String errorMsg) {
                homeView.showMessage(errorMsg);
            }
        });
    }
}