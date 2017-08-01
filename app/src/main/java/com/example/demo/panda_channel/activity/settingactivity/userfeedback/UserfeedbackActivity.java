package com.example.demo.panda_channel.activity.settingactivity.userfeedback;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.settingactivity.userfeedback.adapter.UserfeedbackAdapter;
import com.example.demo.panda_channel.activity.settingactivity.userfeedback.fragment.CommonProblemFragment;
import com.example.demo.panda_channel.activity.settingactivity.userfeedback.fragment.MeetProblemFragment;
import com.example.demo.panda_channel.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class UserfeedbackActivity extends BaseActivity {
    @BindView(R.id.image_userfeedback)
    ImageView imageUserfeedback;
    @BindView(R.id.tab_userfeedback)
    TabLayout tabUserfeedback;
    @BindView(R.id.viewpager_userfeedback)
    ViewPager viewpagerUserfeedback;
    private UserfeedbackAdapter adapter;
    private ArrayList<Fragment> list=new ArrayList<>();
    private MeetProblemFragment meetProblemFragment;
    private CommonProblemFragment commonProblemFragment;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_userfeedback;

    }

    @Override
    protected void init() {
        meetProblemFragment=new MeetProblemFragment();
        commonProblemFragment=new CommonProblemFragment();
        list.add(meetProblemFragment);
        list.add(commonProblemFragment);

        adapter=new UserfeedbackAdapter(getSupportFragmentManager(),list);
        viewpagerUserfeedback.setAdapter(adapter);

        tabUserfeedback.setupWithViewPager(viewpagerUserfeedback);
        tabUserfeedback.setTabMode(TabLayout.MODE_FIXED);

        tabUserfeedback.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tabUserfeedback.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.colorPrimary));

    }
    @OnClick(R.id.image_userfeedback)
    public void onViewClicked() {
        finish();
    }
}
