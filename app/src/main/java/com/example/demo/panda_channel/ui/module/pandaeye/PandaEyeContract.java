package com.example.demo.panda_channel.ui.module.pandaeye;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface PandaEyeContract {
    interface View extends BaseView<Presenter> {
        void PandaEyesDataBeanSuccess(PandaEyesDataBean bean);
        void PandaEyesEorror(String msg);
        void PandaEyesChildDataBeanSuccess(PandaEyesChildDataBean bean);
        void PandaEyesChildEorror(String msg);
    }

    interface Presenter extends BasePresenter {
        void PandaEyeChildUrl(String url);
    }
}
