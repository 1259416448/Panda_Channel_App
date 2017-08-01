package com.example.demo.panda_channel.activity.user.register.fragment.email;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;

/**
 * Created by 闫雨婷 on 2017/7/22.
 */

public interface EmailRegisterContract {
    interface View extends BaseView<Presenter> {

        void setYanZheng(Drawable drawable);
        void setLog(String string);
    }
    interface Presenter extends BasePresenter {
        void getRegis(String emile, String pwd, String yzm);

    }
}
