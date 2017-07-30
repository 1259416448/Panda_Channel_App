package com.example.demo.panda_channel.ui.module.livechina.livechinaadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/7/29.
 */

public class BadalingRecyclerviewAdapter extends RecyclerView.Adapter{
    private ArrayList<LiveChinaBean.LiveBean> list;
    private Context context;
    public BadalingRecyclerviewAdapter(ArrayList<LiveChinaBean.LiveBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.china_list_item,null);

        return new ViewHolder(view);
    }
    private boolean flag=true;
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewholder= (ViewHolder) holder;
        viewholder.context.setText(list.get(position).getBrief());
        viewholder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImage()).into(viewholder.img);

        viewholder.radiobt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(flag) {
                    viewholder.radiobt.setChecked(flag);
                    viewholder.context.setVisibility(View.VISIBLE);
                    flag=false;
                }
                else {
                    viewholder.radiobt.setChecked(flag);
                    viewholder.context.setVisibility(View.GONE);
                    flag=true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView context;
        ImageView img;
        RadioButton radiobt;
        public ViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.live_china_item_title);
            context= (TextView) itemView.findViewById(R.id.live_china_item_content);
            img= (ImageView) itemView.findViewById(R.id.live_china_item_image);
            radiobt= (RadioButton) itemView.findViewById(R.id.live_china_item_checkbox);
        }
    }
}
