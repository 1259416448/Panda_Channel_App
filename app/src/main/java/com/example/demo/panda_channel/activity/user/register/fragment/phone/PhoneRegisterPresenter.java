package com.example.demo.panda_channel.activity.user.register.fragment.phone;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/25.
 */

public class PhoneRegisterPresenter implements PhoneRegisterContract.Presenter{

    private PhoneRegisterContract.View view;
    private PandaChannelModel panda_channelModle;

    public PhoneRegisterPresenter(PhoneRegisterContract.View view) {
        view.setPresenter(this);
        this.view = view;
        panda_channelModle = new PandaChannelModelImpl();

    }

    @Override
    public void start() {

      panda_channelModle.getPhone(new MyNetWorkCallBack<Drawable>() {
          @Override
          public void onSuccess(Drawable drawable) {
              view.setPhoneReg(drawable);
          }

          @Override
          public void onError(String errorMsg) {
          }
      });
    }

    @Override
    public void getPhoneYz(String num, String yz) {
       panda_channelModle.setphone(num, yz, new MyNetWorkCallBack<String>() {
           @Override
           public void onSuccess(String s) {
                view.PhoneYzS(s);
           }

           @Override
           public void onError(String msg) {
               view.PhoneYzE(msg);
           }
       });
    }

    @Override
    public void getStrPhone(String num, String yz, String pwd) {
       panda_channelModle.getStrPhone(num, yz, pwd, new MyNetWorkCallBack<String>() {
           @Override
           public void onSuccess(String s) {
               view.setPhoneYzSuccess(s);
           }

           @Override
           public void onError(String msg) {
               view.setPhoneYzError(msg);
           }
       });
    }
}
