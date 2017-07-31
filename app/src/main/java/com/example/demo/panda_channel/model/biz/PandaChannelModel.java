package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

//业务事件
public interface PandaChannelModel extends BaseModel{
    void getHomeData(MyNetWorkCallBack<HomeData> callback);
    void getHomePandaEye(MyNetWorkCallBack<HomePandaEyeBean> callBack);
    void getPandaEyeData(MyNetWorkCallBack<PandaEyesDataBean> callBack);
    void getPandaEyeChildData(String url,MyNetWorkCallBack<PandaEyesChildDataBean> callBack);
}
