package com.example.demo.panda_channel.activity.user.forgetpassword;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;

/**
 * Created by 闫雨婷 on 2017/7/22.
 */

public interface ForgetpasswordContract {
    interface View extends BaseView<Presenter> {

        void setYanZheng(Drawable drawable);
        void setSuccess(String str);
        void SetEorro(String msg);
    }
    interface Presenter extends BasePresenter {
        void getStrPhone(String num, String yz, String pwd);

    }
}
