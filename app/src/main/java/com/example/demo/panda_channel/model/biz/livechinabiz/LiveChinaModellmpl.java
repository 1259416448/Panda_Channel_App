package com.example.demo.panda_channel.model.biz.livechinabiz;

import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by ASUS on 2017/7/29.
 */

public class LiveChinaModellmpl implements LiveChinaModel {


    @Override
    public void getChildFragmentAllBean(MyNetWorkCallBack<ChildFragmentAllBean> callback) {
        iHttp.get(Urls.LIVECHINAURL,null,callback);
    }

    @Override
    public void getLiveChinaBean(String url,MyNetWorkCallBack<LiveChinaBean> callback) {
        iHttp.get(url,null,callback);
    }
}
