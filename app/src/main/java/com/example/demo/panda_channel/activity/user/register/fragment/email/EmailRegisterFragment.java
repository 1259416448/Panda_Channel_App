package com.example.demo.panda_channel.activity.user.register.fragment.email;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
//
public class EmailRegisterFragment extends BaseFragment implements EmailRegisterContract.View{
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_emailpsw)
    EditText etEmailpsw;
    @BindView(R.id.et_emailquerenpsw)
    EditText etEmailquerenpsw;
    @BindView(R.id.et_emailpictureyanzheng)
    EditText etEmailpictureyanzheng;
    @BindView(R.id.email_image)
    ImageView emailImage;
    @BindView(R.id.bt_emailregister)
    Button btEmailregister;
    @BindView(R.id.hint_email)
    TextView hint_email;

    private EmailRegisterContract.Presenter presenter;
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
        return R.layout.emailregisterfragment;
    }

    @Override
    protected void init(View view) {
        new EmailRegisterPresenter(this);
    }


    @OnClick({R.id.et_email, R.id.et_emailpsw, R.id.et_emailquerenpsw, R.id.et_emailpictureyanzheng, R.id.email_image, R.id.bt_emailregister})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_email:
                break;
            case R.id.et_emailpsw:
                break;
            case R.id.et_emailquerenpsw:
                break;
            case R.id.et_emailpictureyanzheng:
                break;
            case R.id.email_image:
                presenter.start();
                break;
            case R.id.bt_emailregister:
                etEmail();
                if(etEmail.getText().toString().equals("")||etEmailpsw.getText().toString().equals("")||etEmailquerenpsw.getText().toString().equals("")||etEmailpictureyanzheng.getText().toString().equals("")){
                    Toast.makeText(getContext(),"邮箱注册失败",Toast.LENGTH_SHORT).show();
                }else{
                    presenter.getRegis(etEmail.getText().toString()
                            , etEmailquerenpsw.getText().toString()
                            , etEmailpictureyanzheng.getText().toString());
                    getActivity().finish();
                }

                break;
        }
    }

    @Override
    public void setYanZheng(Drawable drawable) {
        emailImage.setImageDrawable(drawable);
    }

    @Override
    public void setLog(String string) {

    }

    @Override
    public void setPresenter(EmailRegisterContract.Presenter presenter) {
        this.presenter=presenter;

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    private boolean etEmail() {
        String phoneString = etEmail.getText().toString().trim();
        if (TextUtils.isEmpty(phoneString)) {
            hint_email.setVisibility(View.VISIBLE);
            hint_email.setText("邮箱不能为空");
            return false;
        } else {
            hint_email.setVisibility(View.GONE);
            return true;
        }
    }
}
