package com.example.demo.panda_channel.base;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public interface BaseView<T> {

    void setPresenter(T t);
    void showProgress();
    void dismissProgress();
}
