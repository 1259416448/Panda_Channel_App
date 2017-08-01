package com.example.demo.panda_channel.net;

import android.app.ProgressDialog;
import android.widget.ImageView;

import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

import java.io.File;
import java.util.Map;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public interface IHttp {
    <T> void get(String url, Map<String,String> params, MyNetWorkCallBack<T> callback);
    <T> void post(String url,Map<String,String> params,MyNetWorkCallBack<T> callback);
    <T> void get(String url, Map<String,String> params, Map<String,String> headers,MyNetWorkCallBack<T> callback);
    void upload();
    File download(String uri, final ProgressDialog pd) throws Exception;
    void loadImage(String url, ImageView imageView);

}
