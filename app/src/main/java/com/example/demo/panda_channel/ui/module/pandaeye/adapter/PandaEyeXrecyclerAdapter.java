package com.example.demo.panda_channel.ui.module.pandaeye.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/29 0029.
 */

public class PandaEyeXrecyclerAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<PandaEyesChildDataBean.ListBean> pandachilddatalist;

    public PandaEyeXrecyclerAdapter(Context context, ArrayList<PandaEyesChildDataBean.ListBean> pandachilddatalist) {
        this.context = context;
        this.pandachilddatalist = pandachilddatalist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.pandaeye_xrecycelview_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.title.setText(pandachilddatalist.get(position).getTitle());

        Date date=new Date(pandachilddatalist.get(position).getFocus_date());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        viewHolder.data.setText(year+"/"+month+"/"+day);
        Glide.with(context).load(pandachilddatalist.get(position).getPicurl()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return pandachilddatalist.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView data;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.panda_eye_item_img);
            title= (TextView) itemView.findViewById(R.id.panda_eye_item_title);
            data= (TextView) itemView.findViewById(R.id.panda_eye_item_data);
        }
    }
}
