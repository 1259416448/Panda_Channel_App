package com.example.demo.panda_channel.app;

import android.app.Application;

import com.example.demo.panda_channel.base.BaseActivity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class App extends Application {
    public static BaseActivity context=null;
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2436552590", "8f44e87e2db0dea2cae1f2600a52881c", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);

    }


}
