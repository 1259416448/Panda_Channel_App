package com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.PandaLiveChildLiveDataBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface LiveFragmentContract {
    interface View extends BaseView<Presenter> {
        void ChildLiveFragmentSuccess(PandaLiveChildLiveDataBean bean);
        void Error(String msg);
    }

    interface Presenter extends BasePresenter {

    }
}
