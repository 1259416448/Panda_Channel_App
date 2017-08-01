package com.example.demo.panda_channel.activity.user.forgetpassword;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetpasswordActivity extends BaseActivity implements ForgetpasswordContract.View{
    private ForgetpasswordContract.Presenter presenter;
    @BindView(R.id.phone_imageView)
    ImageView phone_imageView;
    @BindView(R.id.register_forget_number)
    EditText registerForgetNumber;
    @BindView(R.id.register_forget_photoyanzheng)
    EditText registerForgetPhotoyanzheng;
    @BindView(R.id.forget_yanzhengma_image)
    ImageView forget_yanzhengma_image;
    @BindView(R.id.register_forget_reveive)
    EditText registerForgetReveive;
    @BindView(R.id.bt_getyanzheng)
    Button btGetyanzheng;
    @BindView(R.id.register_forget_setpass)
    EditText registerForgetSetpass;
    @BindView(R.id.bt_register)
    Button btRegister;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_forgetpassword;
    }

    @Override
    protected void init() {
        new ForgetpasswordPresenter(this);
        presenter.start();
        forget_yanzhengma_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
            }
        });
    }

    @Override
    public void setYanZheng(Drawable drawable) {
        forget_yanzhengma_image.setImageDrawable(drawable);
    }

    @Override
    public void setSuccess(String str) {
        finish();
    }

    @Override
    public void SetEorro(String msg) {
        Log.e("TAG",msg.toString());
    }


    @Override
    public void setPresenter(ForgetpasswordContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
    @OnClick({R.id.phone_imageView, R.id.bt_getyanzheng, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.phone_imageView:
                finish();
                break;
            case R.id.bt_getyanzheng:
                presenter.start();
                break;
            case R.id.bt_register:
                presenter.getStrPhone(registerForgetNumber.getText().toString(),registerForgetPhotoyanzheng.getText().toString(),registerForgetSetpass.getText().toString());
                break;
        }
    }
}
