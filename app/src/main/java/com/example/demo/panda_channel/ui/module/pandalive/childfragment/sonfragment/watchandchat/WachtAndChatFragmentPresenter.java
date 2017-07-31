package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class WachtAndChatFragmentPresenter implements WatchAndChatFragmentContract.Presenter{
    private WatchAndChatFragmentContract.View multiangview;
    private PandaChannelModel pandaChannelModel;
    public WachtAndChatFragmentPresenter(WatchAndChatFragmentContract.View multiangview){
        this.multiangview=multiangview;
        multiangview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();

    }
    @Override
    public void start() {

    }

    @Override
    public void NetHttpUrl(String url) {
        pandaChannelModel.getPandaLiveWacthAndChatDataBean(url, new MyNetWorkCallBack<WacthAndChatDataBean>() {
            @Override
            public void onSuccess(WacthAndChatDataBean bean) {
                multiangview.Success(bean);
            }
            @Override
            public void onError(String errorMsg) {
                multiangview.Error(errorMsg);
            }
        });
    }
}
