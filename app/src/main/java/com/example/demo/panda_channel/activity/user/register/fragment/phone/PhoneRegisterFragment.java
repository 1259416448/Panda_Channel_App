package com.example.demo.panda_channel.activity.user.register.fragment.phone;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/7/15.
 */

public class PhoneRegisterFragment extends BaseFragment implements PhoneRegisterContract.View{

    PhoneRegisterContract.Presenter presenter;

    @BindView(R.id.phone_et_phonenumber)
    EditText etPhonenumber;
    @BindView(R.id.phone_et_pictureyanzheng)
    EditText etPictureyanzheng;
    @BindView(R.id.phone_et_receiveyanzheng)
    EditText etReceiveyanzheng;
    @BindView(R.id.phone_bt_getyanzheng)
    Button btGetyanz9heng;
    @BindView(R.id.phone_et_password)
    EditText etPassword;
    @BindView(R.id.phone_bt_register)
    Button btRegister;
    @BindView(R.id.hint_phone)
    TextView hint_phone;
    @BindView(R.id.phone_hint_surepawd)
    TextView hint_surepawd;
    @BindView(R.id.hint_imagecheck)
    TextView hint_imagecheck;
    @BindView(R.id.phone_yanzhengma_image)
    ImageView imageView;
    @BindView(R.id.phone_hint_phonecheck)
    TextView hint_phonecheck;
    private String mCaptchaEditTextString;
    @Override
    protected void onShow() {

    }

    @Override
    protected void onHidden() {

    }

    @Override
    protected void loadData() {
        presenter.start();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.phoneregisterfragment;
    }
    @Override
    protected void init(View view) {
        new PhoneRegisterPresenter(this);
    }
    @OnClick({R.id.phone_et_phonenumber, R.id.phone_et_pictureyanzheng, R.id.phone_et_receiveyanzheng, R.id.phone_bt_getyanzheng, R.id.phone_et_password, R.id.phone_bt_register,R.id.phone_yanzhengma_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_getyanzheng:
                phonenumber();
                pictureyanzheng();
                presenter.getPhoneYz(etPhonenumber.getText().toString(),etPictureyanzheng.getText().toString());
                break;
            case R.id.bt_register:
                password();
                phoneyanzheng();
                presenter.getStrPhone(etPhonenumber.getText().toString(),etReceiveyanzheng.getText().toString(),etPassword.getText().toString());
                if (etPhonenumber.getText().toString().equals("")
                        || etReceiveyanzheng.getText().toString().equals("")
                        || etPassword.getText().toString().equals("")){
                    Toast.makeText(getContext(), "注册失败", Toast.LENGTH_SHORT).show();
                }else {

                    getActivity().finish();
                }
                break;
            case R.id.phone_yanzhengma_image:
                presenter.start();
                break;
        }
    }

    private boolean phonenumber() {
        String phoneString = etPhonenumber.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            hint_phone.setVisibility(View.VISIBLE);
            hint_phone.setText("手机号码不能为空");
            return false;
        } else {
            hint_phone.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean password() {
        String editpasswordsString = etPassword.getText().toString();
        if (TextUtils.isEmpty(editpasswordsString)) {
            hint_surepawd.setVisibility(View.VISIBLE);
            hint_surepawd.setText("密码不能为空");
            return false;
        } else if (editpasswordsString.length() < 6 || editpasswordsString.length() > 16) {
            hint_surepawd.setText("密码仅限6-16个字符");
            return false;
        } else {
            hint_surepawd.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean pictureyanzheng() {
        mCaptchaEditTextString = etPictureyanzheng.getText().toString().trim();
        if (mCaptchaEditTextString.contains(" ")) {
            hint_imagecheck.setText("验证码不正确");
            hint_imagecheck.setVisibility(View.VISIBLE);
            return false;
        }
        if (mCaptchaEditTextString == null || "".equals(mCaptchaEditTextString)) {
            hint_imagecheck.setText("验证码不能为空");
            hint_imagecheck.setVisibility(View.VISIBLE);
            return false;
        } else {
            hint_imagecheck.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean phoneyanzheng() {
        String phonecheck = etReceiveyanzheng.getText().toString().trim();

        if (TextUtils.isEmpty(phonecheck)) {
            hint_phonecheck.setText("验证码不能为空");
            hint_phonecheck.setVisibility(View.VISIBLE);
            return false;
        } else {
            hint_phonecheck.setVisibility(View.GONE);
            return true;
        }
    }
    @Override
    public void setPhoneReg(Drawable drawable) {
        imageView.setImageDrawable(drawable);
    }
    @Override
    public void PhoneYzS(String s) {
        Log.e("tag==PhoneYzS",s);

    }
    @Override
    public void PhoneYzE(String msg) {
        Log.e("tag==PhoneYzE",msg);
    }

    @Override
    public void setPhoneYzSuccess(String str) {
        Log.e("tag===setPhoneYzSuccess",str);
    }

    @Override
    public void setPhoneYzError(String msg) {
        Log.e("tag===setPhoneYzError",msg);
    }


    @Override
    public void setPresenter(PhoneRegisterContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
