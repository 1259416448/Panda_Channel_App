package com.example.demo.panda_channel.net.callback;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public interface MyNetWorkCallBack<T> {
    void onSuccess(T t);
    void onError(String errorMsg);
}
