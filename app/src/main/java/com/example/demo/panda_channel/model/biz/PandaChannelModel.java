package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
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
    void getVersion(MyNetWorkCallBack<UpDateLoading> callBack);
    void getOriginal(MyNetWorkCallBack<OriginalBean> callBack);
    void getPandaChildLiveData(MyNetWorkCallBack<PandaLiveChildLiveDataBean> callBack);
    void getPandaLiveTablayout(MyNetWorkCallBack<PandaLiveTablyoutData> callBack);
    void getPandaLiveModuleData(String url,MyNetWorkCallBack<PandaLiveMoudleDataBean> callBack);
    void getPandaLiveMultiangLiveData(String url, MyNetWorkCallBack<MultiangleLiveDataBean> callBack);
    void getPandaLiveWacthAndChatDataBean(String url, MyNetWorkCallBack<WacthAndChatDataBean> callBack);
}
