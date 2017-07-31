package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class MultiangleRecyclerAdapter extends RecyclerView.Adapter{
    private List<MultiangleLiveDataBean.ListBean> list;
    private Context context;

    public MultiangleRecyclerAdapter(List<MultiangleLiveDataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.multiangleliverecylcer_item,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.multiangle_recycler_item_img);
            title= (TextView) itemView.findViewById(R.id.multiangle_recycler_title);
        }
    }
}
