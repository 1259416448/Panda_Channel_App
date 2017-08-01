package com.example.demo.panda_channel.activity;

import android.widget.ImageView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutPandaActivity extends BaseActivity {
    @BindView(R.id.aboutpanda_image)
    ImageView aboutpandaImage;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_panda;
    }

    @Override
    protected void init() {

    }
    @OnClick(R.id.aboutpanda_image)
    public void onViewClicked() {
        finish();
    }
}
