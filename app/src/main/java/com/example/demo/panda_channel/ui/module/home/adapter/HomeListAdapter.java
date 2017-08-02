package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.LightChinaBean;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/7/29.
 */

public class HomeListAdapter extends RecyclerView.Adapter{

    public interface setOnClickListener{
        void setOnClickListener(View v,int position);
    }
    private HomePandaLiveAdapter.setOnClickListener onClickListener;
    public void setOnClickListener(HomePandaLiveAdapter.setOnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
    private Context context;
    private ArrayList<LightChinaBean.ListBean> listBeen;

    public HomeListAdapter(Context context, ArrayList<LightChinaBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView,textView2,textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.panda_eye_img);
            textView= (TextView) itemView.findViewById(R.id.panda_eye_title);
            textView2= (TextView) itemView.findViewById(R.id.panda_eye_date);
            textView3= (TextView) itemView.findViewById(R.id.panda_eye_time);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_pandaeye_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HttpFactroy.create().loadImage(listBeen.get(position).getImage(),holder1.imageView);
        holder1.textView.setText(listBeen.get(position).getTitle());
        holder1.textView2.setText(listBeen.get(position).getDaytime());
        holder1.textView3.setText(listBeen.get(position).getVideoLength());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.setOnClickListener(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
}
