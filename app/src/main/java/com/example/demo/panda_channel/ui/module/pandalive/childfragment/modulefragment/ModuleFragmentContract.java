package com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface ModuleFragmentContract {
    interface View extends BaseView<Presenter> {
        void Success(PandaLiveMoudleDataBean bean);
        void Error(String msg);
    }

    interface Presenter extends BasePresenter {
        void UrlNetwork(String url);
    }
}
