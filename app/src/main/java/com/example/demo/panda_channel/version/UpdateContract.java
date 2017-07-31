package com.example.demo.panda_channel.version;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;

/**
 * Created by lizhuofang on 2017/7/23.
 */

public interface UpdateContract {
    interface View extends BaseView<Presenter> {
        void getVersion(UpDateLoading upDateLoading);
        void getShowDialog();//显示版本升级对话框
        void showDialogUpdate();//提示立即更新的对话框
        void loadNewVersionProgress();//下载更新

    }
    interface Presenter extends BasePresenter{
    }
}
