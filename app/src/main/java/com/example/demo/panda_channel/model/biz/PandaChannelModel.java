package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.OriginalBean;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.version.UpDateLoading;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

//业务事件
public interface PandaChannelModel extends BaseModel{
    void getHomeData(MyNetWorkCallBack<HomeData> callback);
    void getPandaEyeData(MyNetWorkCallBack<PandaEyesDataBean> callBack);
    void getPandaEyeChildData(String url,MyNetWorkCallBack<PandaEyesChildDataBean> callBack);
    void getVersion(MyNetWorkCallBack<UpDateLoading> callBack);
    void getOriginal(MyNetWorkCallBack<OriginalBean> callBack);
}
