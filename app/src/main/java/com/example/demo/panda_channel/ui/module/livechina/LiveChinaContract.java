package com.example.demo.panda_channel.ui.module.livechina;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface LiveChinaContract {
    interface View extends BaseView<Presenter> {
        void ShowChildFragmentAllBean(ChildFragmentAllBean childFragmentAllBean);
        void setError(String msg);
        void bombWindow();
    }

    interface Presenter extends BasePresenter {
    }

}
