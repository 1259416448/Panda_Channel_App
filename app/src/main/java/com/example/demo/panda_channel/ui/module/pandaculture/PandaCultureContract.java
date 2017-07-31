package com.example.demo.panda_channel.ui.module.pandaculture;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.RollVideoBean;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public interface PandaCultureContract {
    interface View extends BaseView<Presenter> {
      void showRollVideoBean(RollVideoBean rollVideoBean);
      void setError(String msg);
      void setlbo();
    }

    interface Presenter extends BasePresenter {

    }
}
