package com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.PandaLiveChildLiveDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class LiveFragmentPresenter implements LiveFragmentContract.Presenter{
    private LiveFragmentContract.View liveview;
    private PandaChannelModel pandaChannelModel;
    public LiveFragmentPresenter(LiveFragmentContract.View liveview){
        this.liveview=liveview;
        liveview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();

    }
    @Override
    public void start() {
        pandaChannelModel.getPandaChildLiveData(new MyNetWorkCallBack<PandaLiveChildLiveDataBean>() {
            @Override
            public void onSuccess(PandaLiveChildLiveDataBean bean) {
                liveview.ChildLiveFragmentSuccess(bean);
            }

            @Override
            public void onError(String errorMsg) {
                liveview.Error(errorMsg);
            }
        });
    }
}
