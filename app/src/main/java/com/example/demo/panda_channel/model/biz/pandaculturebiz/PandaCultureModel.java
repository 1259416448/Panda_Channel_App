package com.example.demo.panda_channel.model.biz.pandaculturebiz;

import com.example.demo.panda_channel.model.entity.RollVideoBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by ASUS on 2017/7/31.
 */

public interface PandaCultureModel {
   void  getRollVideoBean(MyNetWorkCallBack<RollVideoBean> callBack);
}
