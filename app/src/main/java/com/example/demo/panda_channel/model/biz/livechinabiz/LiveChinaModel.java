package com.example.demo.panda_channel.model.biz.livechinabiz;

import com.example.demo.panda_channel.model.biz.BaseModel;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by ASUS on 2017/7/29.
 */

public interface LiveChinaModel extends BaseModel {
    void getChildFragmentAllBean(MyNetWorkCallBack<ChildFragmentAllBean> callback);
    void getLiveChinaBean(String url,MyNetWorkCallBack<LiveChinaBean> callback);

}
