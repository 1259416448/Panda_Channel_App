package com.example.demo.panda_channel.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.utils.ACache;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class OkHttpUtils implements IHttp {
    private String jsonId;
    byte[] bytes;
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

//    上传图片
    @Override
    public void upload() {

    }

    //更新
    int total = 0;
    public File download(String uri, final ProgressDialog pd) throws Exception {
        //如果相等的话表示当前的sdcard挂载在手机上并且是可用的
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            //获取到文件的大小
            pd.setMax(conn.getContentLength());
            InputStream is = conn.getInputStream();
            long time = System.currentTimeMillis();//当前时间的毫秒数
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), time + "updata.apk");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedInputStream bis = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                total += len;
                //获取当前下载量
                pd.setProgress(total);
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        } else {
            return null;
        }
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
    public void loginPost(String url, Map<String, String> parmers, Map<String, String> heards, final MyNetWorkCallBack callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (parmers != null && parmers.size() > 0) {
            sb.append("?");
            Set<String> strings = parmers.keySet();
            for (String string : strings) {
                String s = parmers.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
        Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError("执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Headers headers = response.headers();
                jsonId = headers.get("Set-Cookie");
                bytes = response.body().bytes();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        saveCookie(jsonId);
                        Drawable drawable = byteToDrawable(bytes);
                        callBack.onSuccess(drawable);
                    }
                });

            }
        });
    }
    public void saveCookie(String value){
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = cookie.edit();
        edit.putString("Cookie",value);
        edit.commit();
    }
    public static Drawable byteToDrawable(byte[] byteArray) {
        try {
            String string = new String(byteArray, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
        return Drawable.createFromStream(ins, null);
    }
    public void registerPost(String url, Map<String, String> parmers, Map<String, String> heards, final MyNetWorkCallBack<String> callBack) {
        StringBuffer sb = new StringBuffer(url);
        if (parmers != null && parmers.size() > 0) {
            sb.append("?");
            Set<String> strings = parmers.keySet();
            for (String string : strings) {
                String s = parmers.get(string);
                sb.append(string).append("=").append(s).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();

        if (heards != null && heards.size() > 0) {
            Set<String> strings = heards.keySet();
            for (String string : strings) {
                String s = heards.get(string);
                builder.addHeader(string, s);
            }
        }
        Request request = builder.url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //okhttp请求失败的回调
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callBack.onError("执行了网络请求异常");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(s);
                    }
                });

            }
        });
    }
}
