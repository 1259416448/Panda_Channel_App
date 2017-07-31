package com.example.demo.panda_channel.activity.original;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.WebViewActivity;
import com.example.demo.panda_channel.model.entity.OriginalBean;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.List;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public class OriginalAdapter extends BaseAdapter<OriginalBean.InteractiveBean>{

    public OriginalAdapter(Context context, List<OriginalBean.InteractiveBean> datas) {
        super(context, R.layout.original_list_item, datas);
    }

    @Override
    public void convert(ViewHolder holder, final OriginalBean.InteractiveBean interactiveBean) {
        final ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.original_list_img);
        HttpFactroy.create().loadImage(interactiveBean.getImage(),imageView);//图片
        holder.setText(R.id.original_list_title,interactiveBean.getTitle());//标题

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, WebViewActivity.class);
                intent.putExtra("url",interactiveBean.getUrl());
                intent.putExtra("title",interactiveBean.getTitle());
                context.startActivity(intent);
            }
        });
    }
}
