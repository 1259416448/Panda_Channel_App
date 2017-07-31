package com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class ModuleXrecyclerAdapter extends RecyclerView.Adapter{
    private ArrayList<PandaLiveMoudleDataBean.VideoBean> list;
    private Context context;

    public ModuleXrecyclerAdapter(ArrayList<PandaLiveMoudleDataBean.VideoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.modulefragmentrecycler_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getImg()).into(viewHolder.img);
        viewHolder.title.setText(list.get(position).getT());
        viewHolder.time.setText(list.get(position).getPtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView time;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.modulefragmentxrecycler_item_img);
            title= (TextView) itemView.findViewById(R.id.modulefragmentxrecycler_item_title);
            time= (TextView) itemView.findViewById(R.id.modulefragmentxrecycler_item_time);
        }
    }
}
