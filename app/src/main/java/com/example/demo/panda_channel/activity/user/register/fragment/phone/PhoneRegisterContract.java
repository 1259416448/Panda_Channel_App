package com.example.demo.panda_channel.activity.user.register.fragment.phone;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;


/**
 * Created by 闫雨婷 on 2017/7/25.
 */

public interface PhoneRegisterContract {
    interface View extends BaseView<Presenter> {
        void setPhoneReg(Drawable drawable);
        void PhoneYzS(String s);
        void PhoneYzE(String msg);
        void setPhoneYzSuccess(String str);
        void setPhoneYzError(String msg);
    }
    interface Presenter extends BasePresenter {
        void getPhoneYz(String num, String yz);
        void getStrPhone(String num, String yz, String pwd);
    }
}
