package com.example.demo.panda_channel.ui.module.pandaculture;

import com.example.demo.panda_channel.model.biz.pandaculturebiz.PandaCultureModel;
import com.example.demo.panda_channel.model.biz.pandaculturebiz.PandaCultureModellmp;
import com.example.demo.panda_channel.model.entity.RollVideoBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class PandaCulturePresenter implements PandaCultureContract.Presenter{
    private PandaCultureContract.View view;
    private PandaCultureModel model;

    public PandaCulturePresenter(PandaCultureContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        model=new PandaCultureModellmp();
    }



    @Override
    public void start() {
        model.getRollVideoBean(new MyNetWorkCallBack<RollVideoBean>() {
            @Override
            public void onSuccess(RollVideoBean rollVideoBean) {
                view.showRollVideoBean(rollVideoBean);
                view.setlbo();
            }

            @Override
            public void onError(String errorMsg) {
              view.setError(errorMsg);
            }
        });
    }
}
