package com.example.demo.panda_channel.adapter.histroy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.db.histroy.MyHistroy;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class HistroyListViewAdapter extends RecyclerView.Adapter{

    public interface CallBack{
        void show(View v,MyHistroy myHistroy,int postion);
    }
    private CallBack callBack;
    public void setOnclickListener(CallBack callBack){
        this.callBack=callBack;
    }

    private ArrayList<MyHistroy> list;
    private Context context;

    public HistroyListViewAdapter(ArrayList<MyHistroy> list, Context context) {
        this.list = list;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView time;
        RadioButton radio;
        LinearLayout original_linear;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.item_history_img);
            title= (TextView) itemView.findViewById(R.id.item_history_title);
            time= (TextView) itemView.findViewById(R.id.item_histroy_time);
            radio= (RadioButton) itemView.findViewById(R.id.item_history_radio);
            original_linear= (LinearLayout) itemView.findViewById(R.id.original_linear);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_histroylistview,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.time.setText(list.get(position).getDate());
        Glide.with(context).load(list.get(position).getImg()).into(viewHolder.img);
        viewHolder.radio.setEnabled(false);
        if(list.get(position).isCheckbox()) {
            viewHolder.radio.setVisibility(View.VISIBLE);
        }
        else {
            viewHolder.radio.setVisibility(View.GONE);
        }
        if(list.get(position).isFlag()) {
            viewHolder.radio.setChecked(true);
        }
        else {
            viewHolder.radio.setChecked(false);
        }

        viewHolder.original_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(callBack!=null){
                    callBack.show(v,list.get(position),position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
