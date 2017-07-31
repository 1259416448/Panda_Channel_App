package com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class ModuleFragmentPresenter implements ModuleFragmentContract.Presenter{
    private ModuleFragmentContract.View moduleview;
    private PandaChannelModel pandaChannelModel;
    public ModuleFragmentPresenter(ModuleFragmentContract.View moduleview){
        this.moduleview=moduleview;
        moduleview.setPresenter(this);
        pandaChannelModel=new PandaChannelModelImpl();
    }
    @Override
    public void start() {

    }

    @Override
    public void UrlNetwork(String url) {
        pandaChannelModel.getPandaLiveModuleData(url, new MyNetWorkCallBack<PandaLiveMoudleDataBean>() {
            @Override
            public void onSuccess(PandaLiveMoudleDataBean bean) {
                moduleview.Success(bean);
            }

            @Override
            public void onError(String errorMsg) {
                moduleview.Error(errorMsg);
            }
        });
    }
}
