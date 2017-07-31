package com.example.demo.panda_channel;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.activity.original.OriginalActivity;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.net.OkHttpUtils;
import com.example.demo.panda_channel.ui.module.home.HomeFragment;
import com.example.demo.panda_channel.ui.module.home.HomePresenter;
import com.example.demo.panda_channel.ui.module.livechina.LiveChinaContract;
import com.example.demo.panda_channel.ui.module.livechina.LiveChinaFragment;
import com.example.demo.panda_channel.ui.module.livechina.LiveChinaPresenter;
import com.example.demo.panda_channel.ui.module.pandaculture.PandaCultureContract;
import com.example.demo.panda_channel.ui.module.pandaculture.PandaCultureFragment;
import com.example.demo.panda_channel.ui.module.pandaculture.PandaCulturePresenter;
import com.example.demo.panda_channel.ui.module.pandaeye.PandaEyeFragment;
import com.example.demo.panda_channel.ui.module.pandalive.PandaLiveFragment;
import com.example.demo.panda_channel.version.UpDateLoading;
import com.example.demo.panda_channel.version.UpdateContract;
import com.example.demo.panda_channel.widget.view.CustomDialog;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements UpdateContract.View{

    private String vsinurl;
    private static int versionCode;
    public UpdateContract.Presenter presenter;

    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.home_Page)
    RadioButton homePage;
    @BindView(R.id.home_panda_eye)
    RadioButton homePandaeye;
    @BindView(R.id.home_panda_culture)
    RadioButton homePandaculture;
    @BindView(R.id.home_panda_live)
    RadioButton homePandalive;
    @BindView(R.id.home_Live_China)
    RadioButton homeLiveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;

    public static final int HOMETYPE = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        getShowDialog();
        HomeFragment homeFragment = (HomeFragment) changeFragment(HomeFragment.class, R.id.container, true, null, false);
        new HomePresenter(homeFragment);

        getAppVersionName(MainActivity.this);
    }

    @OnClick({R.id.personImg, R.id.hudongImg, R.id.home_Page, R.id.home_panda_eye, R.id.home_panda_culture, R.id.home_panda_live, R.id.home_Live_China})
    public void onViewClicked(View view) {
        homePage.setBackgroundColor(0);
        homePandaeye.setBackgroundColor(0);
        homePandaculture.setBackgroundColor(0);
        homePandalive.setBackgroundColor(0);
        homeLiveChina.setBackgroundColor(0);
        switch (view.getId()) {
            case R.id.personImg:
                break;
            case R.id.hudongImg:
                Intent intent=new Intent(MainActivity.this,OriginalActivity.class);
                startActivity(intent);
                break;
            case R.id.home_Page:
                showTitle(null, HOMETYPE);
                changeFragment(HomeFragment.class, R.id.container, true, null, false);
                homePage.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_panda_eye:
                showTitle("熊猫观察", 0);
                changeFragment(PandaEyeFragment.class, R.id.container, true, null, false);
                homePandaeye.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_panda_culture:
                showTitle("熊猫文化", 0);
                BaseFragment baseFragment1 = changeFragment(PandaCultureFragment.class, R.id.container, true, null, false);
                new PandaCulturePresenter((PandaCultureContract.View) baseFragment1);
                homePandaculture.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_panda_live:
                showTitle("熊猫直播", 0);
                changeFragment(PandaLiveFragment.class, R.id.container, true, null, false);
                homePandalive.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_Live_China:
                showTitle("直播中国", 0);
                BaseFragment baseFragment = changeFragment(LiveChinaFragment.class, R.id.container, true, null, false);
                new LiveChinaPresenter((LiveChinaContract.View) baseFragment);
                homeLiveChina.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
        }
    }

    /**
     * 显示标题的方法
     *
     * @param title 显示的标题
     * @param type  1代表首页
     */
    private void showTitle(String title, int type) {
        if (type == HOMETYPE) {
            iconImg.setVisibility(View.VISIBLE);
            titleTv.setVisibility(View.GONE);
            hudongImg.setVisibility(View.VISIBLE);
        } else {
            titleTv.setText(title);
            iconImg.setVisibility(View.GONE);
            titleTv.setVisibility(View.VISIBLE);
            hudongImg.setVisibility(View.GONE);
        }
    }

    private long mkeyTime = 1;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mkeyTime) > 2000) {
                mkeyTime = System.currentTimeMillis();
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();

            } else {
                finish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public static String getAppVersionName(Context context) {
        String versionName = "";

        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
            Log.i("aaa", versionCode + "");
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.i("aaa", versionName);
        }
        return versionName;

    }

    @Override
    public void setPresenter(UpdateContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {
        CustomDialog.getInsent().create(MainActivity.this);
    }

    @Override
    public void dismissProgress() {
        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void getVersion(UpDateLoading upDateLoading) {
        String versionsNum = upDateLoading.getData().getVersionsNum();
        vsinurl = upDateLoading.getData().getVersionsUrl();
        int versionsInt = Integer.parseInt(versionsNum);
        if (versionCode < versionsInt) {
            getShowDialog();
        } else {
            Toast.makeText(MainActivity.this, "已经是最新版本", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void getShowDialog() {
        new AlertDialog.Builder(MainActivity.this).setTitle("版本升级")//设置对话框标题

                .setMessage("检测到最新版本，新版本对系统做了更好的优化")//设置显示的内容

                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        // TODO Auto-generated method stub
                        dialog.dismiss();
                        showDialogUpdate();
                        dialog.dismiss();

                    }

                }).setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {//添加返回按钮


            @Override

            public void onClick(DialogInterface dialog, int which) {//响应事件

                // TODO Auto-generated method stub

                dialog.dismiss();

            }

        }).show();//在按键响应事件中显示此对话框
    }

    @Override
    public void showDialogUpdate() {
        // 这里的属性可以一直设置，因为每次设置后返回的是一个builder对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // 设置提示框的标题
        builder.setTitle("版本升级").
                // 设置提示框的图标
                        setIcon(R.mipmap.ic_launcher).
                // 设置要显示的信息
                        setMessage("发现新版本！请及时更新").
                // 设置确定按钮
                        setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "选择确定哦", 0).show();
                        dialog.dismiss();
                        loadNewVersionProgress();//下载最新的版本程序

                    }
                }).

                // 设置取消按钮,null是什么都不做，并关闭对话框
                        setNegativeButton("取消", null);
        // 生产对话框
        AlertDialog  alertDialog = builder.create();
        // 显示对话框
        alertDialog.show();
    }

    @Override
    public void loadNewVersionProgress() {
        final String uri = vsinurl;
        final ProgressDialog pd;    //进度条对话框
        pd = new ProgressDialog(MainActivity.this);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
        pd.show();
        //启动子线程下载任务
        new Thread() {
            @Override
            public void run() {
                try {
                    File file = OkHttpUtils.getInstance().download(uri,pd);
                    sleep(3000);
                    installApk(file);
                    pd.dismiss(); //结束掉进度条对话框
                } catch (Exception e) {
                    //下载apk失败
                    Log.i("abc", "下载失败");
//                    Toast.makeText(getActivity(), "下载新版本失败", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 安装apk
     */
    protected void installApk(File file) {
        Intent intent = new Intent();
        //执行动作
        intent.setAction(Intent.ACTION_VIEW);
        //执行的数据类型
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }
}
