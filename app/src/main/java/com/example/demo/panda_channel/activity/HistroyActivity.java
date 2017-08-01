package com.example.demo.panda_channel.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class HistroyActivity extends BaseActivity {


    @BindView(R.id.history_image)
    ImageView historyImage;
    @BindView(R.id.history_edit)
    TextView historyEdit;
    @BindView(R.id.history_backgroud)
    ImageView historyBackgroud;
    @BindView(R.id.history_all)
    TextView historyAll;
    @BindView(R.id.history_delect)
    TextView historyDelect;
    @BindView(R.id.history_recyclerview)
    RecyclerView historyRecyclerview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_histroy;
    }

    @Override
    protected void init() {

    }

    @OnClick({R.id.history_image, R.id.history_edit, R.id.history_all, R.id.history_delect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.history_image:
                break;
            case R.id.history_edit:
                break;
            case R.id.history_all:
                break;
            case R.id.history_delect:
                break;
        }
    }
}
