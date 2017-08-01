package com.example.demo.panda_channel.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.fragment.collection.CollectionAdapter;
import com.example.demo.panda_channel.fragment.collection.HighLightFragment;
import com.example.demo.panda_channel.fragment.collection.LiveFragment;
import com.example.demo.panda_channel.fragment.collection.NonSwipeableViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class CollectionActivity extends BaseActivity {

    @BindView(R.id.shoucang_image)
    ImageView shoucangImage;
    @BindView(R.id.bj)
    TextView bj;
    @BindView(R.id.shoucang_tab)
    TabLayout shoucangTab;
    @BindView(R.id.shoucang_viewpager)
    NonSwipeableViewPager viewPager;

    private ArrayList<Fragment> list=new ArrayList<>();
    private LiveFragment liveFragment;
    private HighLightFragment highLightFragment;
    private CollectionAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void init() {

        liveFragment=new LiveFragment();
        highLightFragment=new HighLightFragment(bj);

        list.add(liveFragment);
        list.add(highLightFragment);

        adapter=new CollectionAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);

        shoucangTab.setupWithViewPager(viewPager);
        shoucangTab.setTabMode(TabLayout.MODE_FIXED);

        shoucangTab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimary));
        shoucangTab.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.colorPrimary));

    }

    @OnClick({R.id.shoucang_image, R.id.bj})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoucang_image:
                finish();
                break;
            case R.id.bj:
                break;
        }
    }
}
