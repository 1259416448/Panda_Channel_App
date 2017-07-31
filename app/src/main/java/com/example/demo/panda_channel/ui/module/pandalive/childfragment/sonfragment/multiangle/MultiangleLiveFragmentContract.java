package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface MultiangleLiveFragmentContract {
    interface View extends BaseView<Presenter> {
        void Success(MultiangleLiveDataBean bean);
        void Error(String msg);
    }

    interface Presenter extends BasePresenter {
        void NetHttpUrl(String url);
    }
}
