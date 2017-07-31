package com.example.demo.panda_channel.activity.original;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.OriginalBean;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public interface OriginalContract {
    interface View extends BaseView<Presenter> {
        void setListData(OriginalBean originalBean);
    }

    interface Presenter extends BasePresenter {

    }
}
