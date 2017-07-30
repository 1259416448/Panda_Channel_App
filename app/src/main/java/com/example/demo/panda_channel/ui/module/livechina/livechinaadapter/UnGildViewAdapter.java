package com.example.demo.panda_channel.ui.module.livechina.livechinaadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class UnGildViewAdapter extends BaseAdapter{
    private ArrayList<ChildFragmentAllBean.AlllistBean> list;
    private Context context;

    public UnGildViewAdapter(ArrayList<ChildFragmentAllBean.AlllistBean> list, Context context) {
        this.list=list;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.e("tag====unselectgildview",list.size()+"");
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
        ViewHodler viewHodler=new ViewHodler();
        if(convertView==null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.unselectgildview_item,null);
            viewHodler.text= (TextView) convertView.findViewById(R.id.unselect_gridview_text);
            convertView.setTag(viewHodler);
       }else {
            viewHodler= (ViewHodler) convertView.getTag();
        }
        viewHodler.text.setText(list.get(position).getTitle());
        return convertView;
    }
    class ViewHodler {
        TextView text;
    }
}


