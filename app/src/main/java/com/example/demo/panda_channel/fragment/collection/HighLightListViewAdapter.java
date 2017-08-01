package com.example.demo.panda_channel.fragment.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.db.collection.MyCollection;

import java.util.ArrayList;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class HighLightListViewAdapter extends BaseAdapter{

    private ArrayList<MyCollection> list;
    private Context context;

    public HighLightListViewAdapter(ArrayList<MyCollection> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(holder==null){
            holder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_highlight,null);
            holder.OriginalNewsItemTitle= (TextView) convertView.findViewById(R.id.OriginalNews_item_title);
            holder.OriginalNewsItemImg= (ImageView) convertView.findViewById(R.id.OriginalNews_item_img);
            holder.OriginalNewsItemTime= (TextView) convertView.findViewById(R.id.OriginalNews_item_time);
            holder.checkBox= (RadioButton) convertView.findViewById(R.id.original_radio);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.OriginalNewsItemTitle.setText(list.get(position).getTitle());
        holder.OriginalNewsItemTime.setText(list.get(position).getDate());
        Glide.with(context).load(list.get(position).getImg()).into(holder.OriginalNewsItemImg);

        if(list.get(position).isCheckbox()) {
            holder.checkBox.setVisibility(View.VISIBLE);
        }
        else {
            holder.checkBox.setVisibility(View.GONE);
        }
        if(list.get(position).isFlag()) {
            holder.checkBox.setChecked(true);
        }
        else {
            holder.checkBox.setChecked(false);
        }
        return convertView;
    }
    static class ViewHolder {
        ImageView OriginalNewsItemImg;
        TextView OriginalNewsItemTitle;
        TextView OriginalNewsItemTime;
        RadioButton checkBox;
    }
}
