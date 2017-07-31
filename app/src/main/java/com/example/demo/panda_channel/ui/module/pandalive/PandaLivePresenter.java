package com.example.demo.panda_channel.ui.module.pandalive;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.PandaLiveTablyoutData;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class PandaLivePresenter implements PandaLiveContract.Presenter{
    private PandaLiveContract.View pandaview;
    private PandaChannelModel pandaChannelModel;
    public PandaLivePresenter(PandaLiveContract.View pandaview){
        this.pandaview=pandaview;
        pandaview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();
    }
    @Override
    public void start() {
        pandaChannelModel.getPandaLiveTablayout(new MyNetWorkCallBack<PandaLiveTablyoutData>() {
            @Override
            public void onSuccess(PandaLiveTablyoutData pandaLiveTablyoutData) {
                pandaview.Success(pandaLiveTablyoutData);
            }

            @Override
            public void onError(String errorMsg) {
                pandaview.Error(errorMsg);
            }
        });
    }
}
