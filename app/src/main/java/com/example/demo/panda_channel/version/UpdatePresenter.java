package com.example.demo.panda_channel.version;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.net.OkHttpUtils;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by lizhuofang on 2017/7/23.
 */

public class UpdatePresenter implements UpdateContract.Presenter {
    private UpdateContract.View view;
    private PandaChannelModel pandaChannelModel;
    private OkHttpUtils okHttpUtils;
    public UpdatePresenter(UpdateContract.View view){
        this.view=view;
        this.view.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();
    }
    @Override
    public void start() {
        pandaChannelModel.getVersion(new MyNetWorkCallBack<UpDateLoading>() {
            @Override
            public void onSuccess(UpDateLoading upDateLoading) {
                view.getVersion(upDateLoading);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
