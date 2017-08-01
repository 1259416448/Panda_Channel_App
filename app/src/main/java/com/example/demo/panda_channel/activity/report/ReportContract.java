package com.example.demo.panda_channel.activity.report;

import com.example.demo.panda_channel.base.BasePresenter;
import com.example.demo.panda_channel.base.BaseView;
import com.example.demo.panda_channel.model.entity.ReportVideoPlayBean;

/**
 * Created by Administrator on 2017/8/1 0001.
 */

public interface ReportContract{
    interface View extends BaseView<Presenter>{
        void setSuccess(ReportVideoPlayBean bean);
        void setEorror(String msg);
    }
    interface Presenter extends BasePresenter{
        void setVideoData(String url);
    }
}
