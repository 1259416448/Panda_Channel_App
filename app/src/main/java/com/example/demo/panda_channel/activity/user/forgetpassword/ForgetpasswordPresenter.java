package com.example.demo.panda_channel.activity.user.forgetpassword;

import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/22.
 */

public class ForgetpasswordPresenter implements ForgetpasswordContract.Presenter{

    private ForgetpasswordContract.View view;
    private PandaChannelModel modle;
    public ForgetpasswordPresenter(ForgetpasswordContract.View view) {
        this.view = view;
        view.setPresenter(this);
        modle = new PandaChannelModelImpl();
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

    @Override
    public void getStrPhone(String num, String yz, String pwd) {
        modle.getStrPhone(num, yz, pwd, new MyNetWorkCallBack<String>() {
            @Override
            public void onSuccess(String s) {
                view.setSuccess(s);
            }

            @Override
            public void onError(String errorMsg) {
                view.SetEorro(errorMsg);
            }
        });
    }
}
