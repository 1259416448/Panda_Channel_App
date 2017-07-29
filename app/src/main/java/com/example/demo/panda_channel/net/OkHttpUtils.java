package com.example.demo.panda_channel.net;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.utils.ACache;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class OkHttpUtils implements IHttp {

    private OkHttpClient okHttpClient;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient();
    }

    private static OkHttpUtils okhttpUilts;

    public static OkHttpUtils getInstance() {
        if (okhttpUilts == null) {
            synchronized (OkHttpUtils.class) {
                okhttpUilts = new OkHttpUtils();
            }
        }
        return okhttpUilts;
    }

    @Override
    public <T> void get(String url, Map<String, String> params, final MyNetWorkCallBack<T> callback) {
        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            sb.append("?");
            for (String key : keys) {
                String values = params.get(key);
                sb.append(key).append("=").append(values).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e.getMessage().toString());

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> params, final MyNetWorkCallBack<T> callback) {
        StringBuffer sb=new StringBuffer(url);
        if (params !=null && params.size()>0){
            sb.append("?");
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url=sb.deleteCharAt(sb.length()-1).toString();
        }

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Referer","https://reg.cntv.cn/login/login.action")
                .addHeader("User-Agent","CNTV_APP_CLIENT_CYNTV_MOBILE")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e.getMessage().toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });
            }
        });

    }

    @Override
    public <T> void get(String url, Map<String, String> params, Map<String, String> headers, final MyNetWorkCallBack<T> callback) {
        StringBuffer sb = new StringBuffer(url);
        if(params != null && params.size() > 0){
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length()-1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if(headers != null && headers.size() > 0){
            Set<String> keys = headers.keySet();
            for (String key : keys){
                String value = headers.get(key);
                builder.addHeader(key,value);
            }
        }
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData,callback));
                    }
                });

            }
        });
    }

    @Override
    public void upload() {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(App.context).load(url).into(imageView);
    }

    private <T> T getGeneric(String jsonData, MyNetWorkCallBack<T> callback) {
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callback.getClass().getGenericInterfaces();//返回直接实现的接口

        // 通过反射机制获取子类传递过来的实体类的类型信息
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();// 返回实际泛型类型列表
        Type type = actualTypeArguments[0];

        T t = gson.fromJson(jsonData, type);
        ACache aCacha=ACache.get(App.context);
        aCacha.put(t.getClass().getSimpleName(), (Serializable) t);
        return t;
    }
}
