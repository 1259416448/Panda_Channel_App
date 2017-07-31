package com.example.demo.panda_channel.ui.module.livechina.livechinaadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/17 0017.
 */

public class GildViewAdapter extends BaseAdapter{
    private ArrayList<ChildFragmentAllBean.TablistBean> list;
    private Context context;
    public GildViewAdapter(ArrayList<ChildFragmentAllBean.TablistBean> list, Context context ) {
        this.list=list;
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
        ViewHodler viewHodler=new ViewHodler();

        if(convertView==null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.gildview_item,null);
            viewHodler.text= (TextView) convertView.findViewById(R.id.gridview_text);
            viewHodler.gildview_colse= (ImageView) convertView.findViewById(R.id.gildview_colse);
            convertView.setTag(viewHodler);
       }else {
            viewHodler= (ViewHodler) convertView.getTag();
        }
        viewHodler.text.setText(list.get(position).getTitle());
        if(list.get(position).isFlag()) {
            viewHodler.gildview_colse.setVisibility(View.VISIBLE);
        }
        else {
            viewHodler.gildview_colse.setVisibility(View.GONE);
        }
        return convertView;
    }
    public void swap(int i, int j) {
        if (j < i) {
            ChildFragmentAllBean.TablistBean s = list.get(i);
            list.add(j, s);
            list.remove(i + 1);
        } else if (i < j) {
            ChildFragmentAllBean.TablistBean s = list.get(i);
            list.add(j + 1, s);
            list.remove(i);
        }
    }
    class ViewHodler {
        TextView text;
        ImageView gildview_colse;
    }
}


