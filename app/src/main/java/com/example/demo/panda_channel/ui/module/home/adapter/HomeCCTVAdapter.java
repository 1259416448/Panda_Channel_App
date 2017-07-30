package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.CCTVBean;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/29.
 */

public class HomeCCTVAdapter extends RecyclerView.Adapter{

    private Context context;
    private ArrayList<CCTVBean.ListBean> listBeen;

    public HomeCCTVAdapter(Context context, ArrayList<CCTVBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.homecctv_item_img);
            textView= (TextView) itemView.findViewById(R.id.homecctv_item_title);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_cctv_item,null);
        return new ViewHolder(view);
}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HttpFactroy.create().loadImage(listBeen.get(position).getImage(),holder1.imageView);
        holder1.textView.setText(listBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
}
