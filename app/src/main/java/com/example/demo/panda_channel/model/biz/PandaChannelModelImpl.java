package com.example.demo.panda_channel.model.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.model.entity.LoginBean;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;
import com.example.demo.panda_channel.model.entity.OriginalBean;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveChildLiveDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;
import com.example.demo.panda_channel.model.entity.PandaLiveTablyoutData;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;
import com.example.demo.panda_channel.net.OkHttpUtils;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.version.UpDateLoading;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

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
    public void getVersion(MyNetWorkCallBack<UpDateLoading> callBack) {
        iHttp.get(Urls.UPDATE,null,callBack);
    }

    @Override
    public void getOriginal(MyNetWorkCallBack<OriginalBean> callBack) {
        iHttp.get(Urls.ORIGINAL,null,callBack);
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
    public void setEmiRegs(MyNetWorkCallBack<Drawable> callBack) {
        OkHttpUtils.getInstance().loginPost(Urls.EMILEYANZHENG, null, null, callBack);
    }

    @Override
    public void getPhone(MyNetWorkCallBack<Drawable> callBack) {
        OkHttpUtils.getInstance().loginPost(Urls.EMILEYANZHENG,null,null,callBack);
    }

    @Override
    public void setphone(String num, String yz, MyNetWorkCallBack<String> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("method","getRequestVerifiCodeM");
        map.put("mobile",num);
        map.put("verfiCodeType","1");
        map.put("verificationCode",yz);
        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer", URLEncoder.encode( "http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map1.put("Cookie",getCookie());
        OkHttpUtils.getInstance().registerPost(Urls.PHONENUM,map,map1,callBack);
    }

    @Override
    public void getStrPhone(String num, String yz, String pwd, MyNetWorkCallBack<String> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("method","saveMobileRegisterM");
        map.put("mobile",num);
        map.put("verfiCodeType","1");
        map.put("verfiCode",yz);
        map.put("passWd",pwd);
        try {
            map.put("addons",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer",URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        OkHttpUtils.getInstance().registerPost(Urls.PHONEREGISTER,map,map1,callBack);
    }



    @Override
    public void getLogin(String username, String password, MyNetWorkCallBack<LoginBean> callback) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("service", "client_transaction");
        map.put("from", "https://reg.cntv.cn/login/login.action");
        iHttp.post(Urls.LOGIN, map, callback);
    }
    @Override
    public void getEmileRegister(String emile, String pwd, String yanzhengma, MyNetWorkCallBack<String> callBack) {
        Map<String,String> map = new HashMap<>();
        map.put("mailAdd",emile);
        map.put("passWd",pwd);
        map.put("verificationCode",yanzhengma);

        Map<String,String> map1 = new HashMap<>();
        try {
            map1.put("Referer", URLEncoder.encode("iPanda.Android", "UTF-8"));

            map1.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8"));
            map1.put("Cookie",getCookie());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        OkHttpUtils.getInstance().registerPost(Urls.EMILEREGIS,map,map1,callBack);
    }
    public String getCookie() {
        SharedPreferences cookie = App.context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        String string = cookie.getString("Cookie", null);
        return string;
    }
}
