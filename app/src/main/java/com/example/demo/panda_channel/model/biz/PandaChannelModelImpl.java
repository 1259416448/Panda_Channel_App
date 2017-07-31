package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveChildLiveDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveTablyoutData;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class PandaChannelModelImpl implements PandaChannelModel{
    @Override
    public void getHomeData(MyNetWorkCallBack<HomeData> callback) {
        iHttp.get(Urls.HOMEURLALL,null,callback);
    }

    @Override
    public void getHomePandaEye(MyNetWorkCallBack<HomePandaEyeBean> callBack) {
        iHttp.get(Urls.HOMEVIDEOURL,null,callBack);
    }
    @Override
    public void getPandaEyeData(MyNetWorkCallBack<PandaEyesDataBean> callBack) {
        iHttp.get(Urls.PANDAREPORTTWO,null,callBack);
    }

    @Override
    public void getPandaEyeChildData(String url, MyNetWorkCallBack<PandaEyesChildDataBean> callBack) {
        iHttp.get(url,null,callBack);
    }

    @Override
    public void getPandaLiveTablayout(MyNetWorkCallBack<PandaLiveTablyoutData> callBack) {
        iHttp.get(Urls.PANDALIVETAB,null,callBack);
    }

    @Override
    public void getPandaLiveModuleData(String url, MyNetWorkCallBack<PandaLiveMoudleDataBean> callBack) {
        iHttp.get(url,null,callBack);
    }

    @Override
    public void getPandaLiveMultiangLiveData(String url, MyNetWorkCallBack<MultiangleLiveDataBean> callBack) {
        iHttp.get(url,null,callBack);
    }

    @Override
    public void getPandaLiveWacthAndChatDataBean(String url, MyNetWorkCallBack<WacthAndChatDataBean> callBack) {
        iHttp.get(url,null,callBack);
    }

    @Override
    public void getPandaChildLiveData(MyNetWorkCallBack<PandaLiveChildLiveDataBean> callBack) {
        iHttp.get(Urls.PANDALIVE,null,callBack);
    }
}
