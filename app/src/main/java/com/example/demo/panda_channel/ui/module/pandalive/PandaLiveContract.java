package com.example.demo.panda_channel.ui.module.pandalive;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.PandaLiveTablyoutData;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface PandaLiveContract {
    interface View extends BaseView<Presenter> {
        void Success(PandaLiveTablyoutData pandaLiveTablyoutData);
        void Error(String msg);
    }

    interface Presenter extends BasePresenter {
    }
}
