package com.example.demo.panda_channel;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.ui.module.home.HomeFragment;
import com.example.demo.panda_channel.ui.module.home.HomePresenter;
import com.example.demo.panda_channel.ui.module.livechina.LiveChinaFragment;
import com.example.demo.panda_channel.ui.module.pandaculture.PandaCultureFragment;
import com.example.demo.panda_channel.ui.module.pandaeye.PandaEyeFragment;
import com.example.demo.panda_channel.ui.module.pandalive.PandaLiveFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

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
        HomeFragment homeFragment = (HomeFragment) changeFragment(HomeFragment.class, R.id.container, true, null, false);
        new HomePresenter(homeFragment);

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
                changeFragment(PandaCultureFragment.class, R.id.container, true, null, false);
                homePandaculture.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_panda_live:
                showTitle("熊猫直播", 0);
                changeFragment(PandaLiveFragment.class, R.id.container, true, null, false);
                homePandalive.setBackgroundColor(getResources().getColor(R.color.tab_backgroud_color));
                break;
            case R.id.home_Live_China:
                showTitle("直播中国", 0);
                changeFragment(LiveChinaFragment.class, R.id.container, true, null, false);
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
}
