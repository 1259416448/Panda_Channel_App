package com.example.demo.panda_channel.net;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class HttpFactroy {
    public static IHttp create() {

        return OkHttpUtils.getInstance();
    }
}
