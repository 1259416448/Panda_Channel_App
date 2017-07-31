package com.example.demo.panda_channel.ui.module.livechina;

import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModel;
import com.example.demo.panda_channel.model.biz.livechinabiz.LiveChinaModellmpl;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class LiveChinaPresenter implements LiveChinaContract.Presenter{
    private LiveChinaContract.View view;
    private LiveChinaModel chinaModel;
    public LiveChinaPresenter(LiveChinaContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
        chinaModel=new LiveChinaModellmpl();
    }

    @Override
    public void start() {
        view.bombWindow();

        chinaModel.getChildFragmentAllBean(new MyNetWorkCallBack<ChildFragmentAllBean>() {
            @Override
            public void onSuccess(ChildFragmentAllBean childFragmentAllBean) {
                view.ShowChildFragmentAllBean(childFragmentAllBean);

            }

            @Override
            public void onError(String errorMsg) {
                view.setError(errorMsg);
            }
        });
    }
}
