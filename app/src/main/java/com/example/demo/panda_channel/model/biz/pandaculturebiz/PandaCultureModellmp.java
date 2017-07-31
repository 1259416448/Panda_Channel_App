package com.example.demo.panda_channel.model.biz.pandaculturebiz;

import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.RollVideoBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

import static com.example.demo.panda_channel.model.biz.BaseModel.iHttp;

/**
 * Created by ASUS on 2017/7/31.
 */

public class PandaCultureModellmp implements PandaCultureModel{

    @Override
    public void getRollVideoBean(MyNetWorkCallBack<RollVideoBean> callBack) {
        iHttp.get(Urls.ROLLVIDEO,null,callBack);
    }
}
