package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.List;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class HomeAreaAdapter extends RecyclerView.Adapter{

    private Context context;
    private List<HomeData.DataBean.AreaBean.ListscrollBean> datas;
    private LayoutInflater inflater;
    public HomeAreaAdapter(Context context, List<HomeData.DataBean.AreaBean.ListscrollBean> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_area_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Holder holder1 = (Holder) holder;
        HttpFactroy.create().loadImage(datas.get(position).getImage(),holder1.img);
        holder1.titleTv.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView titleTv;
        public Holder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.areaImg);
            titleTv = (TextView) itemView.findViewById(R.id.areaTitle);
        }
    }
}
