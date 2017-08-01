package com.example.demo.panda_channel.activity.user.register.fragment.email;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/22.
 */

public class EmailRegisterPresenter implements EmailRegisterContract.Presenter{

    private EmailRegisterContract.View view;
    private PandaChannelModel modle;
    public EmailRegisterPresenter(EmailRegisterContract.View view) {
        view.setPresenter(this);
        this.view = view;
        modle = new PandaChannelModelImpl();

    }


    @Override
    public void getRegis(String emile, String pwd, String yzm) {
     modle.getEmileRegister(emile, pwd, yzm, new MyNetWorkCallBack<String>() {
         @Override
         public void onSuccess(String s) {
             view.setLog(s);
         }

         @Override
         public void onError(String errorMsg) {

         }
     });
    }

    @Override
    public void start() {
        modle.setEmiRegs(new MyNetWorkCallBack<Drawable>() {
            @Override
            public void onSuccess(Drawable drawable) {
                view.setYanZheng(drawable);
            }

            @Override
            public void onError(String errorMsg) {

            }
        });

    }
}
