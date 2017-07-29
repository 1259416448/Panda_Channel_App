package com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment;

import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModel;
import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModellmpl;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by ASUS on 2017/7/29.
 */

public class ChildPresenter implements ChildContract.Presenter {
    private ChildContract.View view;
    private LiveChinaModel chinaModel;
    public ChildPresenter(ChildContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        chinaModel=new LiveChinaModellmpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void UrlLiveChinaBean(String url) {
        chinaModel.getLiveChinaBean(url, new MyNetWorkCallBack<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                view.ShowLiveChinaBean(liveChinaBean);
            }

            @Override
            public void onError(String errorMsg) {
                view.setError(errorMsg);
            }
        });
    }
}
