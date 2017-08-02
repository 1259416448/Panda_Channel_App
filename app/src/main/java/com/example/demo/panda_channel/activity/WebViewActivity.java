package com.example.demo.panda_channel.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.config.Keys;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public class WebViewActivity extends BaseActivity {
    @BindView(R.id.home_webview_back)
    ImageView homeWebviewBack;
    @BindView(R.id.home_webview_title)
    TextView homeWebviewTitle;
    @BindView(R.id.home_webview_share)
    ImageView homeWebviewShare;
    @BindView(R.id.activity_webview)
    WebView activityWebview;

    private WebSettings settings;
    private String stringurl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void init() {

        settings = activityWebview.getSettings();
        stringurl = getIntent().getStringExtra(Keys.WEBVIEW);

        Intent intent = getIntent();
        String title = intent.getStringExtra(Keys.TITLE);
        homeWebviewTitle.setText(title);


        //      可以与什么交互
        settings.setJavaScriptEnabled(true);
//        将图片控制到适合webview的大小
        settings.setUseWideViewPort(true);

//        缩放至屏幕大小
        settings.setLoadWithOverviewMode(true);
        activityWebview.loadUrl(stringurl);

    }

    @OnClick({R.id.home_webview_back, R.id.home_webview_title, R.id.home_webview_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_webview_back:
                finish();
                break;
            case R.id.home_webview_share:
                break;
        }
    }
}
