package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class MultiangleLiveFragmentPresenter implements MultiangleLiveFragmentContract.Presenter{
    private MultiangleLiveFragmentContract.View multiangview;
    private PandaChannelModel pandaChannelModel;
    public MultiangleLiveFragmentPresenter(MultiangleLiveFragmentContract.View multiangview){
        this.multiangview=multiangview;
        multiangview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();

    }
    @Override
    public void start() {

    }

    @Override
    public void NetHttpUrl(String url) {
        pandaChannelModel.getPandaLiveMultiangLiveData(url, new MyNetWorkCallBack<MultiangleLiveDataBean>() {
            @Override
            public void onSuccess(MultiangleLiveDataBean bean) {
                multiangview.Success(bean);
            }

            @Override
            public void onError(String errorMsg) {
                multiangview.Error(errorMsg);
            }
        });
    }
}
