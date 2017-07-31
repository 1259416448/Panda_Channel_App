package com.example.demo.panda_channel.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * C\reated by Administrator on 2017/7/31 0031.
 */

public class PandaLiveMoudleDataBean implements Serializable{

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4547"}
     * video : [{"vsid":"VSET100167216881","order":"4530","vid":"a45dfbcccd744416bf2df3d0d99a92ba","t":"《精彩一刻》 20170728 你这一定是在逗我！","url":"http://tv.cntv.cn/video/VSET100167216881/a45dfbcccd744416bf2df3d0d99a92ba","ptime":"2017-07-28 10:00:00","img":"http://p3.img.cctvpic.com/fmspic/2017/07/28/a45dfbcccd744416bf2df3d0d99a92ba-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4529","vid":"195737cf5c3f48c5996cf9e103374455","t":"《精彩一刻》 20170728 超级网红小灰灰\u201c碰瓷\u201d 你也敢不扶？","url":"http://tv.cntv.cn/video/VSET100167216881/195737cf5c3f48c5996cf9e103374455","ptime":"2017-07-28 09:57:02","img":"http://p5.img.cctvpic.com/fmspic/2017/07/28/195737cf5c3f48c5996cf9e103374455-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4528","vid":"56616066c4734982bc6b4fb440071cd6","t":"《精彩一刻》 20170727 我撒起泼来连自己都害怕","url":"http://tv.cntv.cn/video/VSET100167216881/56616066c4734982bc6b4fb440071cd6","ptime":"2017-07-27 13:52:53","img":"http://p5.img.cctvpic.com/fmspic/2017/07/27/56616066c4734982bc6b4fb440071cd6-35.jpg?p=2&h=120","len":"00:00:51","em":"CM01"},{"vsid":"VSET100167216881","order":"4526","vid":"76306d41c4c74325973287259b4c4a27","t":"《精彩一刻》 20170727 脚挠痒的时候，手也不能闲着","url":"http://tv.cntv.cn/video/VSET100167216881/76306d41c4c74325973287259b4c4a27","ptime":"2017-07-27 13:44:31","img":"http://p5.img.cctvpic.com/fmspic/2017/07/27/76306d41c4c74325973287259b4c4a27-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"},{"vsid":"VSET100167216881","order":"4527","vid":"0d8d8d221028489f902b70eb6f8e9828","t":"《精彩一刻》 20170727 奶爸，give me five","url":"http://tv.cntv.cn/video/VSET100167216881/0d8d8d221028489f902b70eb6f8e9828","ptime":"2017-07-27 13:40:40","img":"http://p2.img.cctvpic.com/fmspic/2017/07/27/0d8d8d221028489f902b70eb6f8e9828-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4525","vid":"2b6420e7d7e64b90b7231f3f2071e4bb","t":"《精彩一刻》 20170727 下滑梯基本靠\u201c滚\u201d","url":"http://tv.cntv.cn/video/VSET100167216881/2b6420e7d7e64b90b7231f3f2071e4bb","ptime":"2017-07-27 13:39:11","img":"http://p2.img.cctvpic.com/fmspic/2017/07/27/2b6420e7d7e64b90b7231f3f2071e4bb-34.jpg?p=2&h=120","len":"00:00:48","em":"CM01"},{"vsid":"VSET100167216881","order":"4524","vid":"901d463a5fc643638e61c39e2bb080ef","t":"《精彩一刻》 20170727 求反射弧距离有多长！","url":"http://tv.cntv.cn/video/VSET100167216881/901d463a5fc643638e61c39e2bb080ef","ptime":"2017-07-27 11:03:33","img":"http://p5.img.cctvpic.com/fmspic/2017/07/27/901d463a5fc643638e61c39e2bb080ef-9.jpg?p=2&h=120","len":"00:00:17","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean implements Serializable{
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4547
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean implements Serializable{
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean implements Serializable{
        /**
         * vsid : VSET100167216881
         * order : 4530
         * vid : a45dfbcccd744416bf2df3d0d99a92ba
         * t : 《精彩一刻》 20170728 你这一定是在逗我！
         * url : http://tv.cntv.cn/video/VSET100167216881/a45dfbcccd744416bf2df3d0d99a92ba
         * ptime : 2017-07-28 10:00:00
         * img : http://p3.img.cctvpic.com/fmspic/2017/07/28/a45dfbcccd744416bf2df3d0d99a92ba-33.jpg?p=2&h=120
         * len : 00:00:45
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
