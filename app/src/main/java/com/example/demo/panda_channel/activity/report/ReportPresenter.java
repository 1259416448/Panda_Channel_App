package com.example.demo.panda_channel.activity.report;

import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.ReportVideoPlayBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public class ReportPresenter implements ReportContract.Presenter{
    private ReportContract.View reportview;
    private PandaChannelModel pandamodel;
    public ReportPresenter(ReportContract.View reportview){
        this.reportview=reportview;
        reportview.setPresenter(this);
        pandamodel=new PandaChannelModelImpl();
    }
    @Override
    public void start() {
    }
    @Override
    public void setVideoData(String url) {
        pandamodel.getReportData(url, new MyNetWorkCallBack<ReportVideoPlayBean>() {
            @Override
            public void onSuccess(ReportVideoPlayBean reportVideoPlayBean) {
                reportview.setSuccess(reportVideoPlayBean);
            }
            @Override
            public void onError(String errorMsg) {
                reportview.setEorror(errorMsg);
            }
        });
    }
}
