package com.example.demo.panda_channel.activity.user;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ModifyNicknameActivity extends BaseActivity {
    @BindView(R.id.modifynickname_image)
    ImageView modifynicknameImage;
    @BindView(R.id.edit_nickmane)
    EditText editNickmane;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_nickname;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String textView = intent.getStringExtra("nickname");
        editNickmane.setText(textView);
    }
    @OnClick({R.id.modifynickname_image, R.id.edit_nickmane})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.modifynickname_image:
                finish();
                break;
            case R.id.edit_nickmane:
                break;
        }
    }
}
