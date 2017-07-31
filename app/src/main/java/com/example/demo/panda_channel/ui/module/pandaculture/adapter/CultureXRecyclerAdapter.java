package com.example.demo.panda_channel.ui.module.pandaculture.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.RollVideoBean;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/7/31.
 */

public class CultureXRecyclerAdapter extends RecyclerView.Adapter {
    ArrayList<RollVideoBean.ListBean> arr;

    Context context;
    private static final int TYPE = 1;
    private static final int TYPETWO = 2;
    private ArrayList<View> views;
    private ImageView pager_img;


    public CultureXRecyclerAdapter(ArrayList<RollVideoBean.ListBean> arr, Context context) {
        this.arr = arr;
        this.context = context;

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = View.inflate(context, R.layout.item_list, null);
            return new MyHoder(inflate);


    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


            MyHoder hoder= (MyHoder) holder;
            hoder.videoitem_title.setText(arr.get(position).getTitle());
            hoder.videoitem_content.setText(arr.get(position).getBrief());
            hoder.videoitem_time.setText(arr.get(position).getVideoLength());
            Glide.with(context).load(arr.get(position).getImage()).into(hoder.videoitem_image);


    }


    @Override
    public int getItemCount() {
        return arr.size();
    }



    class MyHoder extends RecyclerView.ViewHolder {
        private ImageView videoitem_image;
        private TextView videoitem_time;
        private TextView videoitem_title;
        private TextView videoitem_content;

        public MyHoder(View itemView) {
            super(itemView);
             videoitem_image = (ImageView) itemView.findViewById(R.id.videoitem_image);
             videoitem_time = (TextView) itemView.findViewById(R.id.videoitem_time);
             videoitem_title = (TextView) itemView.findViewById(R.id.videoitem_title);
             videoitem_content = (TextView) itemView.findViewById(R.id.videoitem_content);


        }
    }
}
