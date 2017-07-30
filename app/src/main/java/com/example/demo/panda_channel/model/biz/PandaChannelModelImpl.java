package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class PandaChannelModelImpl implements PandaChannelModel{
    @Override
    public void getHomeData(MyNetWorkCallBack<HomeData> callback) {
        iHttp.get(Urls.HOMEURLALL,null,callback);
    }
}
