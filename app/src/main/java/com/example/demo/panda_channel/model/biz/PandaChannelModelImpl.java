package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
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
}
