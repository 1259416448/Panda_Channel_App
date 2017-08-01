package com.example.demo.panda_channel.activity.user.login;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.user.forgetpassword.ForgetpasswordActivity;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.LoginBean;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;
import com.example.demo.panda_channel.activity.user.register.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_image)
    ImageView loginImage;
    @BindView(R.id.microblog)
    RadioButton microblog;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.weixin)
    RadioButton weixin;
    @BindView(R.id.qq)
    RadioButton qq;
    @BindView(R.id.et_phonenumber)
    EditText editText;
    @BindView(R.id.et_password)
    EditText editText2;
    @BindView(R.id.bt_login)
    Button button;
    @BindView(R.id.tv_forgetpassword)
    TextView tv_forgetpassword;
    private String phonenumber;
    private String password;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {

    }
    @OnClick({R.id.login_image, R.id.microblog, R.id.tv_register, R.id.weixin, R.id.qq, R.id.et_phonenumber, R.id.et_password, R.id.bt_login,R.id.tv_forgetpassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_image:
                finish();
                break;
            case R.id.tv_register:
                final Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
               // UMShareAPI.get(LoginActivity.this).doOauthVerify(LoginActivity.this, platforms.get(0).mPlatform, authListener);
                break;
            case R.id.microblog:
                /*UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.SINA, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Log.e("TAG", share_media.toString());
                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        String uid = map.get("uid");
                        String name = map.get("name");
                        String gender = map.get("gender");
                        String iconurl = map.get("iconurl");
                        Log.e("TAG", "uid:" + uid + "," + "name:" + name + "," + "gender:" + gender + "," + "iconurl:" + iconurl);

                        Intent intent=new Intent();
                        intent.putExtra("name",name);
                        setResult(2000,intent);
                        finish();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Log.e("TAG", throwable.toString());
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Log.e("TAG", "取消分享");
                    }
                });*/

                break;
            case R.id.et_phonenumber:
                break;
            case R.id.et_password:
                break;
            case R.id.tv_forgetpassword:
                Intent intent1=new Intent(LoginActivity.this,ForgetpasswordActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_login:

                phonenumber = editText.getText().toString().trim();
                password = editText2.getText().toString().trim();

                PandaChannelModel panda_channelModle = new PandaChannelModelImpl();
                panda_channelModle.getLogin(phonenumber, password, new MyNetWorkCallBack<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        String errMsg = loginBean.getErrMsg();
                        if (errMsg.equals("成功")) {
                            Intent intent1 =new Intent();
                            intent1.putExtra("id", "央视网友" + loginBean.getUser_seq_id());
                            setResult(1000,intent1);
                            finish();
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(String errormsg) {
                        Log.e("TAG",errormsg.toString());
                    }
                });

                break;
        }

    }
}
