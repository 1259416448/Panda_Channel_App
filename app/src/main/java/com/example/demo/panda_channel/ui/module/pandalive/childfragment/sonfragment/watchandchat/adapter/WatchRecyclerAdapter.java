package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class WatchRecyclerAdapter extends RecyclerView.Adapter{
    private List<WacthAndChatDataBean.DataBean.ContentBean> list;
    private Context context;
    public WatchRecyclerAdapter(List<WacthAndChatDataBean.DataBean.ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.watchandchat_recycler_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.name.setText(list.get(position).getAuthor());
        viewHolder.content.setText(list.get(position).getMessage());
        viewHolder.lou.setText(list.get(position).getAuthorid()+"楼");
        viewHolder.time.setText(list.get(position).getDateline());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,content,lou,time;
        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.watchchat_name);
            content= (TextView) itemView.findViewById(R.id.watchchat_content);
            lou= (TextView) itemView.findViewById(R.id.watchchat_lou);
            time= (TextView) itemView.findViewById(R.id.watchchat_time);

        }
    }
}
