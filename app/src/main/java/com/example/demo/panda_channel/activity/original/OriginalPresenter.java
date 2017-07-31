package com.example.demo.panda_channel.activity.original;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.OriginalBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public class OriginalPresenter implements OriginalContract.Presenter{

    private OriginalContract.View view;
    private PandaChannelModel model;

    public OriginalPresenter(OriginalContract.View view) {
        this.view = view;
        view.setPresenter(this);
        model=new PandaChannelModelImpl();
    }

    @Override
    public void start() {
        model.getOriginal(new MyNetWorkCallBack<OriginalBean>() {
            @Override
            public void onSuccess(OriginalBean originalBean) {
                view.setListData(originalBean);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
