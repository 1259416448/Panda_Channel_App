package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.List;

/**
 * Created by 闫雨婷 on 2017/7/29.
 */

public class HomePandaLiveAdapter extends RecyclerView.Adapter{

    public interface setOnClickListener{
        void setOnClickListener(View v,int position);
    }
    private setOnClickListener onClickListener;
    public void setOnClickListener(setOnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
    private List<HomeData.DataBean.PandaliveBean.ListBean> list;
    private Context context;

    public HomePandaLiveAdapter(List<HomeData.DataBean.PandaliveBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView home_live_shape;
        LinearLayout homepandlive_linear;
        public ViewHolder(View itemView) {
            super(itemView);
            homepandlive_linear= (LinearLayout) itemView.findViewById(R.id.homepandlive_linear);
            img= (ImageView) itemView.findViewById(R.id.homepandlive_item_img);
            title= (TextView) itemView.findViewById(R.id.homepandlive_item_tv);
            home_live_shape= (TextView) itemView.findViewById(R.id.home_live_shape);

        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_pandalive_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HttpFactroy.create().loadImage(list.get(position).getImage(),holder1.img);
        holder1.title.setText(list.get(position).getTitle());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
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
        return list.size();
    }
}
