package com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;

/**
 * Created by ASUS on 2017/7/29.
 */

public interface ChildContract {
    interface View extends BaseView<Presenter> {
        void ShowLiveChinaBean(LiveChinaBean liveChinaBean);
        void setError(String msg);
    }

    interface Presenter extends BasePresenter {
        void UrlLiveChinaBean(String url);
    }
}
