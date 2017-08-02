package com.example.demo.panda_channel.activity.user;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.utils.ACache;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonInformationActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.person_information_image)
    ImageView personInformationImage;
    @BindView(R.id.img_touxiang)
    ImageView imgTouxiang;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.bt_quit_login)
    Button btQuitLogin;
    private PopupWindow popupWindow;
    private Button btn_camera;
    private Button btn_album;
    private Button btn_cancel;

    private static final int NEED_CAMERA = 200;
    private static final int RESULT_PICK = 201;
    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;
    /* 头像文件 */
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";
    // 裁剪后图片的宽(X)和高(Y),480 X 480的正方形。
    private static int output_X = 480;
    private static int output_Y = 480;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_person_information;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("textView");

        tvNickname.setText(stringExtra);
    }
    @OnClick({R.id.person_information_image, R.id.img_touxiang, R.id.tv_nickname, R.id.bt_quit_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.person_information_image:
                finish();
                break;
            case R.id.img_touxiang:
                popwindow();
                break;
            case R.id.tv_nickname:
                Intent intent=new Intent(PersonInformationActivity.this,ModifyNicknameActivity.class);
                intent.putExtra("nickname",tvNickname.getText().toString());
                startActivity(intent);
                break;
            case R.id.bt_quit_login:
                ACache aCache=ACache.get(PersonInformationActivity.this);
                aCache.clear();
                Intent intent2=getIntent();
                setResult(3000,intent2);
                finish();
                break;
        }
    }

    public void popwindow() {
        popupWindow = new PopupWindow();
        View view = LayoutInflater.from(PersonInformationActivity.this).inflate(
                R.layout.item_popwindow, null);
        popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);// 取得焦点
        //注意  要是点击外部空白处弹框消息  那么必须给弹框设置一个背景色  不然是不起作用的
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        //设置可以点击
        popupWindow.setTouchable(true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);

        btn_camera = (Button) view.findViewById(R.id.btn_camera);
        btn_album = (Button) view.findViewById(R.id.btn_album);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);

        btn_camera.setOnClickListener(this);
        btn_album.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:
                // 从本地相册选取图片作为头像

                Intent intentFromGallery = new Intent();
                // 设置文件类型
                intentFromGallery.setType("image/*");
                intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
                break;
            case R.id.btn_album:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, NEED_CAMERA);
                } else {
                    //打开相机获取图片
                    startCamera();
                }

                break;
            case R.id.btn_cancel:
                popupWindow.dismiss();
                break;
        }
    }
    private void startCamera() {

    }


    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            imgTouxiang.setImageBitmap(photo);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }

        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                cropRawPhoto(intent.getData());
                break;

            case CODE_CAMERA_REQUEST:
                if (hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    cropRawPhoto(Uri.fromFile(tempFile));
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }

                break;

            case CODE_RESULT_REQUEST:
                if (intent != null) {

                    setImageToHeadView(intent);
                }

                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }

}
