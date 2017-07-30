package com.example.demo.panda_channel.model.biz;

import com.example.demo.panda_channel.net.HttpFactroy;
import com.example.demo.panda_channel.net.IHttp;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */
//model层的基类
public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();

}
