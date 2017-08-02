package com.example.demo.panda_channel.activity.report;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.GestureDetector;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.config.Keys;
import com.example.demo.panda_channel.db.collection.DaoMaster;
import com.example.demo.panda_channel.db.collection.DaoSession;
import com.example.demo.panda_channel.db.collection.MyCollection;
import com.example.demo.panda_channel.db.collection.MyCollectionDao;
import com.example.demo.panda_channel.model.entity.ReportVideoPlayBean;
import com.example.demo.panda_channel.net.HttpFactroy;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

import java.util.List;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


//555

//22
public class ReportActivity extends BaseActivity implements ReportContract.View {
    private ReportContract.Presenter presenter;
    @BindView(R.id.activity_report)
    RelativeLayout activityReport;
    private int k;
    private boolean flag = false;
    //手势
    private GestureDetector gestureDetector;
    @BindView(R.id.jc_video)
    JCVideoPlayerStandard videoplayer;

    @Override
    public void onBackPressed() {
        if (videoplayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoplayer.releaseAllVideos();
    }

    @Override
    protected int getLayoutId() {
        new ReportPresenter(this);
        return R.layout.activity_report;
    }

    private String img;
    private String url;

    @Override
    protected void init() {
        //screenOrientation

        Intent intent = getIntent();
        url = intent.getStringExtra(Keys.VIDEOURL);
        img = intent.getStringExtra(Keys.VIDEOIMG);
        presenter.setVideoData(url);
        createTable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoplayer.clearSavedProgress(this, "");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void setSuccess(final ReportVideoPlayBean bean) {
        videoplayer.setUp(bean.getVideo().getChapters().get(0).getUrl(),
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, bean.getTitle());
        videoplayer.onAutoCompletion();
        videoplayer.startVideo();
        HttpFactroy.create().loadImage(img, videoplayer.thumbImageView);
        videoplayer.setMonitor(new JCVideoPlayerStandard.imgClickon() {
            @Override
            public void Monitor(View view) {
                UMVideo video = new UMVideo(bean.getVideo().getChapters().get(0).getUrl());
                video.setTitle(video.getTitle());//视频的标题
                video.setThumb(new UMImage(ReportActivity.this, img));
                video.setDescription(video.getTitle());//视频的描述
                if (Build.VERSION.SDK_INT >= 23) {
                    String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
                    ActivityCompat.requestPermissions(ReportActivity.this, mPermissionList, 123);
                }
                new ShareAction(ReportActivity.this).withText("").setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN).setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {

                    }
                }).withMedia(video).open();
            }

            @Override
            public void CollectionMonitor(CompoundButton compoundButton, boolean b) {
                List<MyCollection> list = dao.queryBuilder().build().list();
                if (list.size() == 0) {
                    MyCollection collection = new MyCollection();
                    collection.setTitle(bean.getTitle());
                    collection.setDate(bean.getF_pgmtime());
                    collection.setMoviepath(url);
                    dao.insert(collection);
                    Toast.makeText(ReportActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                } else {
                    for (int i=0;i<list.size();i++){//
                        if(list.get(i).getTitle().equals(bean.getTitle())) {
                            flag=true;
                        }

                    }
                    if(flag==true) {
                        flag=false;
                    }else {
                        MyCollection collection = new MyCollection();
                        collection.setTitle(bean.getTitle());
                        collection.setDate(bean.getF_pgmtime());
                        collection.setMoviepath(url);
                        dao.insert(collection);
                    }
                }
            }

            @Override
            public void WatchthelistMonitor(View view) {

            }

            @Override
            public void setgq() {
                videoplayer.setUp(bean.getVideo().getChapters().get(0).getUrl()
                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, bean.getTitle());
                videoplayer.onAutoCompletion();

                Glide.with(ReportActivity.this)
                        .load(bean.getVideo().getChapters().get(0).getImage())
                        .into(videoplayer.thumbImageView);
            }

            @Override
            public void setbq() {
                videoplayer.setUp(bean.getVideo().getChapters4().get(0).getUrl()
                        , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, bean.getTitle());
                videoplayer.onAutoCompletion();

                Glide.with(ReportActivity.this)
                        .load(bean.getVideo().getChapters().get(0).getImage())
                        .into(videoplayer.thumbImageView);
            }
        });
    }

    @Override
    public void setEorror(String msg) {

    }

    @Override
    protected void onResume() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();

    }

    @Override
    public void setPresenter(ReportContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    private MyCollectionDao dao;

    public void createTable() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "collection.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getMyCollectionDao();
    }
}






