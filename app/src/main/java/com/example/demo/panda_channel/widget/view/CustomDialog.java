package com.example.demo.panda_channel.widget.view;

import android.app.Dialog;
import android.content.Context;

import com.example.demo.panda_channel.R;

/**
 * Created by xingge on 2017/7/26.
 */

//显示进度条
public class CustomDialog {
    private static CustomDialog customDialog;

    private CustomDialog() {
    }

    private Dialog loadDialog;

    public static CustomDialog getInsent() {
        if (customDialog == null) {
            synchronized (CustomDialog.class) {
                if (customDialog == null) {
                    customDialog = new CustomDialog();
                }
            }
        }
        return customDialog;
    }

    public CustomDialog create(Context context) {

        loadDialog = new Dialog(context, R.style.dialog);
        loadDialog.setCanceledOnTouchOutside(false);

        loadDialog.setContentView(R.layout.customdialog);
        loadDialog.show();

        return this;
    }

    public CustomDialog dismiss() {

        loadDialog.dismiss();
        return this;
    }

}
