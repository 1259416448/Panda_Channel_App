package com.example.demo.panda_channel.config;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

//接口地址
public class Urls {
    //服务器地址
    public static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页
    public static final String HOMEURLALL = "http://www.ipanda.com/kehuduan/PAGE14501749764071042/index.json";
    //熊猫文化
    public static final String ROLLVIDEO = BASEURL + "xmwh/index.json";
    //直播中国
    public static final String LIVECHINAURL = "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json";
    //熊猫播报
    public static final String PANDAREPORT = "http://api.cntv.cn/apicommon/index";
    //熊猫播报2
    public static final String PANDAREPORTTWO = "http://www.ipanda.com/kehuduan/PAGE14503485387528442/index.json";
    // 熊猫直播
    public static final String PANDALIVE = BASEURL + "PAGE14501769230331752/index.json";

    public static final String MULITANGLE = "http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json";
    //首页视频
    public static final String HOMEVIDEOURL = "http://www.ipanda.com/kehuduan/shipinliebieye/xiongmaoguancha/index.json";
    //首页-原创互动
    public static final String ORIGINAL = BASEURL + "PAGE14501767715521482/index.json";
    //精彩一刻
    public static final String ORIGINALNEWS = "http://api.cntv.cn/video/videolistById";
    //视频地址
    public static final String VIDEOURL = "http://115.182.9.189/api/getVideoInfoForCBox.do";
    //登录
    public static final String LOGIN = "https://reg.cntv.cn/login/login.action";
    //邮箱注册
    public static final String EMILEREGIS = "https://reg.cntv.cn/api/register.action";
    public static final String EMILEYANZHENG = "http://reg.cntv.cn/simple/verificationCode.action";
    public static String watch = "http://newcomment.cntv.cn/comment/list";
    //版本更新
    public static final String UPDATE = "http://115.182.9.124/index.php?action=release-GetNewVersions&applyName=1426217325";
    //手机注册--获取验证码
    public static final String PHONENUM = "http://reg.cntv.cn/regist/getVerifiCode.action";
    //点击注册
    public static final String PHONEREGISTER = "https://reg.cntv.cn/regist/mobileRegist.do";

}
