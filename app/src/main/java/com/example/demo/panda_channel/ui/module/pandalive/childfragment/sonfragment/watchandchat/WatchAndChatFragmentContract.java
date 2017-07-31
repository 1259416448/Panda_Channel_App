package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface WatchAndChatFragmentContract {
    interface View extends BaseView<Presenter> {
        void Success(WacthAndChatDataBean bean);
        void Error(String msg);
    }

    interface Presenter extends BasePresenter {
        void NetHttpUrl(String url);
    }
}
