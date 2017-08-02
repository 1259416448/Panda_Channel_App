package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.net.HttpFactroy;

import java.util.List;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class HomePandaEyeAdapter extends RecyclerView.Adapter{

    public interface setOnClickListener{
        void show(View view,int position);
    }
    private setOnClickListener OnClickListener;
    public void setOnClickListener(setOnClickListener OnClickListener){
        this.OnClickListener=OnClickListener;
    }

    private Context context;
    private List<HomePandaEyeBean.ListBean> datas;
    private LayoutInflater inflater;
    public HomePandaEyeAdapter(Context context, List<HomePandaEyeBean.ListBean> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_pandaeye_item,null);
        return new Holder(view);

    }

    class Holder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        private TextView textView2;
        private TextView textView3;

        public Holder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.panda_eye_img);
            textView= (TextView) itemView.findViewById(R.id.panda_eye_time);
            textView2= (TextView) itemView.findViewById(R.id.panda_eye_title);
            textView3= (TextView) itemView.findViewById(R.id.panda_eye_date);

        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Holder holder1= (Holder) holder;
        HttpFactroy.create().loadImage(datas.get(position).getImage(),holder1.imageView);
        holder1.textView.setText(datas.get(position).getVideoLength());
        holder1.textView2.setText(datas.get(position).getTitle());
        holder1.textView3.setText(datas.get(position).getDaytime());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(OnClickListener!=null){
                    OnClickListener.show(v,position);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
