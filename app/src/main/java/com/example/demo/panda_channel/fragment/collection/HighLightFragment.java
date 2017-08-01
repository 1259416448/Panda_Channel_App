package com.example.demo.panda_channel.fragment.collection;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.db.collection.MyCollection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class HighLightFragment extends BaseFragment {

    @BindView(R.id.highlight_listview)
    ListView highlightListview;
    @BindView(R.id.quanxuan)
    TextView quanxuan;
    @BindView(R.id.shanchu)
    TextView shanchu;
    @BindView(R.id.dilog)
    LinearLayout dilog;

    private ArrayList<MyCollection> list=new ArrayList<>();
    private HighLightListViewAdapter adapter;
    private TextView textView;
    private int number = 0;

    public HighLightFragment(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.highlight_fragment;
    }

    @Override
    protected void init(View view) {

        for(int i=0;i<=5;i++){
            MyCollection collection=new MyCollection();
            collection.setDate("2017/8/1"+i);
            collection.setTitle("标题"+i);
            list.add(collection);
        }
        adapter=new HighLightListViewAdapter(list,getContext());
        highlightListview.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        highlightListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (textView.getText().equals("完成")) {
                    if (list.get(i).isFlag() == false) {
                        list.get(i).setFlag(true);
                        number++;
                        shanchu.setText("删除" + number);
                    } else {
                        number--;
                        shanchu.setText("删除" + number);
                        list.get(i).setFlag(false);
                    }
                    if (number == 0) {
                        shanchu.setText("删除");
                    }
                    adapter.notifyDataSetChanged();
                }else{
                    adapter.notifyDataSetChanged();
//                    Intent intent = new Intent(getContext(), ReportActivity.class);
//                    intent.putExtra("url", arr1.get(i).getUrl());
//                    intent.putExtra("img", arr1.get(i).getImg());
//                    startActivity(intent);
                }

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText().equals("编辑")) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setCheckbox(true);
                    }
                    dilog.setVisibility(View.VISIBLE);
                    textView.setText("完成");
                    adapter.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setCheckbox(false);
                    }
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setFlag(false);
                    }
                    dilog.setVisibility(View.GONE);
                    textView.setText("编辑");
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    @OnClick({R.id.quanxuan, R.id.shanchu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.quanxuan:
                if (quanxuan.getText().equals("全选")) {
                    quanxuan.setText("取消全选");
                    if (textView.getText().equals("完成")) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setFlag(true);
                        }
                        number = list.size();
                        shanchu.setText("删除" + number);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setFlag(false);
                    }
                    number = 0;
                    shanchu.setText("删除");
                    quanxuan.setText("全选");
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.shanchu:
                if (textView.getText().equals("完成")) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).isFlag()) {
//                            delect(arr1.get(i));
                            list.remove(list.get(i));
                        }
                    }
                    number = 0;
                    adapter.notifyDataSetChanged();
                    shanchu.setText("删除");
                    if (list.size() == 0) {
                        textView.setVisibility(View.GONE);
                        dilog.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }
}
