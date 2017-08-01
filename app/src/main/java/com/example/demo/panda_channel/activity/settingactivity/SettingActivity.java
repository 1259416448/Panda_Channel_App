package com.example.demo.panda_channel.activity.settingactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.AboutPandaActivity;
import com.example.demo.panda_channel.activity.settingactivity.userfeedback.UserfeedbackActivity;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.utils.CleanMessageUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.setting_image)
    ImageView settingImage;
    @BindView(R.id.setting_fankui)
    RelativeLayout settingFankui;
    @BindView(R.id.setting_shengji)
    RelativeLayout settingShengji;
    @BindView(R.id.setting_like)
    RelativeLayout settingLike;
    @BindView(R.id.setting_aboutpanda)
    RelativeLayout settingAboutpanda;
    @BindView(R.id.setting_clear)
    RelativeLayout settingClear;
    private PopupWindow popupWindow;
    TextView clearqueding;
    TextView clearquxiao;
    @BindView(R.id.tv_number)
    TextView tvnumber;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        try {
            tvnumber.setText(CleanMessageUtil.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick({R.id.setting_image, R.id.setting_fankui, R.id.setting_shengji, R.id.setting_like,R.id.setting_aboutpanda,R.id.setting_clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_image:
                finish();
                break;
            case R.id.setting_fankui:
                Intent intent=new Intent(this,UserfeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.setting_shengji:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("已检测到新版本，是否升级");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create();
                builder.show();
                break;
            case R.id.setting_like:

                break;
            case R.id.setting_aboutpanda:
                startActivity(new Intent(this,AboutPandaActivity.class));
                break;
            case R.id.setting_clear:
                onClickCleanCache();
                break;

        }
    }

    private void onClickCleanCache() {
        getConfirmDialog(this, "是否清空缓存?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CleanMessageUtil.clearAllCache(App.context);
                tvnumber.setText("0.00MB");
            }
        }).show();
    }


    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

}
