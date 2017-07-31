package com.example.demo.panda_channel.ui.module.pandaeye;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class PandaEyePresenter implements PandaEyeContract.Presenter{
    PandaEyeContract.View pandaeyeview;
    PandaChannelModel pandaChannelModel;
    public PandaEyePresenter(PandaEyeContract.View pandaeyeview){
        this.pandaeyeview=pandaeyeview;
        pandaeyeview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();
    }
    @Override
    public void start() {
        pandaChannelModel.getPandaEyeData(new MyNetWorkCallBack<PandaEyesDataBean>() {
            @Override
            public void onSuccess(PandaEyesDataBean listBean) {
                pandaeyeview.PandaEyesDataBeanSuccess(listBean);
            }

            @Override
            public void onError(String errorMsg) {
                pandaeyeview.PandaEyesEorror(errorMsg);
            }
        });
    }

    @Override
    public void PandaEyeChildUrl(String url) {
        pandaChannelModel.getPandaEyeChildData(url, new MyNetWorkCallBack<PandaEyesChildDataBean>() {
            @Override
            public void onSuccess(PandaEyesChildDataBean bean) {
                pandaeyeview.PandaEyesChildDataBeanSuccess(bean);
            }

            @Override
            public void onError(String errorMsg) {

                pandaeyeview.PandaEyesChildEorror(errorMsg);
            }
        });
    }
}
