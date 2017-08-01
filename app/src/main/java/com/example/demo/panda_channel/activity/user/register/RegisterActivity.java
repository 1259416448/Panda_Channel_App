package com.example.demo.panda_channel.activity.user.register;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.user.register.fragment.adapter.RegisterAdapter;
import com.example.demo.panda_channel.activity.user.register.fragment.email.EmailRegisterFragment;
import com.example.demo.panda_channel.activity.user.register.fragment.phone.PhoneRegisterFragment;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.widget.view.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_image)
    ImageView registerImage;
    @BindView(R.id.register_tab)
    TabLayout registerTab;
    @BindView(R.id.register_viewpager)
    CustomViewPager registerViewpager;



    private PhoneRegisterFragment phoneRegisterFragment;
    private EmailRegisterFragment emailRegisterFragment;
    private ArrayList<Fragment> list=new ArrayList<>();
    private RegisterAdapter adapter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        phoneRegisterFragment=new PhoneRegisterFragment();
        emailRegisterFragment=new EmailRegisterFragment();
        list.add(phoneRegisterFragment);
        list.add(emailRegisterFragment);

        adapter=new RegisterAdapter(getSupportFragmentManager(),list);
        registerViewpager.setAdapter(adapter);

        registerTab.setupWithViewPager(registerViewpager);
        registerTab.setTabMode(TabLayout.MODE_FIXED);

        registerTab.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorPrimary));
        registerTab.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.colorPrimary));

        LinearLayout linearLayout = (LinearLayout) registerTab.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.tablayout_fg));
        registerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
