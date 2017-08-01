package com.example.demo.panda_channel.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.settingactivity.SettingActivity;
import com.example.demo.panda_channel.activity.user.PersonInformationActivity;
import com.example.demo.panda_channel.activity.user.login.LoginActivity;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.utils.ACache;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity {
    @BindView(R.id.personal_image)
    ImageView personalImage;
    @BindView(R.id.linear1)
    LinearLayout linear1;
    @BindView(R.id.linear2)
    LinearLayout linear2;
    @BindView(R.id.linear3)
    LinearLayout linear3;
    @BindView(R.id.linear4)
    LinearLayout linear4;
    @BindView(R.id.tv_dianjilogin)
    TextView textView;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case 1000:
                String id = data.getStringExtra("id");
                textView.setText(id);
                break;
            case 2000:
                String name = data.getStringExtra("name");
                textView.setText(name);
                break;
            case 3000:
                textView.setText("点击登录");
                break;
        }
    }
    @OnClick(R.id.personal_image)
    public void onViewClicked() {
        finish();
    }
    @OnClick({R.id.linear1, R.id.linear2, R.id.linear3, R.id.linear4, R.id.tv_dianjilogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linear1:

                break;
            case R.id.linear2:
               /* Intent intent2 = new Intent(PersonalActivity.this, HistoryActivity.class);
                startActivity(intent2);*/
                break;
            case R.id.linear3:
               /* Intent intent3 = new Intent(PersonalActivity.this, ShouCangActivity.class);
                startActivity(intent3);*/
                break;
            case R.id.linear4:
                Intent intent4 = new Intent(PersonalActivity.this, SettingActivity.class);
                startActivity(intent4);
                break;
            case R.id.tv_dianjilogin:
                ACache aCache = ACache.get(PersonalActivity.this);
                Object loginBean = aCache.getAsObject("loginBean");
                if (textView.getText().equals("点击登录")) {
                    Intent intent = new Intent(PersonalActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    Intent intent = new Intent(PersonalActivity.this, PersonInformationActivity.class);
                    intent.putExtra("textView", textView.getText().toString());
                    startActivityForResult(intent,0);
                }
                break;
        }
    }
}
