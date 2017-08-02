package com.example.demo.panda_channel.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.adapter.histroy.HistroyListViewAdapter;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.db.histroy.DaoMaster;
import com.example.demo.panda_channel.db.histroy.DaoSession;
import com.example.demo.panda_channel.db.histroy.MyHistroy;
import com.example.demo.panda_channel.db.histroy.MyHistroyDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class HistroyActivity extends BaseActivity implements HistroyListViewAdapter.CallBack{

    @BindView(R.id.history_image)
    ImageView historyImage;
    @BindView(R.id.history_edit)
    TextView historyEdit;
    @BindView(R.id.history_backgroud)
    ImageView historyBackgroud;
    @BindView(R.id.history_all)
    TextView historyAll;
    @BindView(R.id.history_delect)
    TextView historyDelect;
    @BindView(R.id.history_recyclerview)
    RecyclerView historyRecyclerview;
    @BindView(R.id.history_linear)
    LinearLayout historyLinear;
    @BindView(R.id.history_relative)
    RelativeLayout historyRelative;

    private ArrayList<MyHistroy> list = new ArrayList<>();
    private HistroyListViewAdapter adapter;
    private int number = 0;
    private MyHistroyDao myHistroyDao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_histroy;
    }

    @Override
    protected void init() {
        createTable();
        List<MyHistroy> histroyList = myHistroyDao.queryBuilder().list();
        if(histroyList.size()==0) {
            historyEdit.setVisibility(View.GONE);
            historyRelative.setVisibility(View.GONE);
            historyBackgroud.setVisibility(View.VISIBLE);
        }
        list.clear();
        list.addAll(histroyList);
        historyRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HistroyListViewAdapter(list,this);
        historyRecyclerview.setAdapter(adapter);
        adapter.setOnclickListener(this);
    }

    @OnClick({R.id.history_image, R.id.history_edit, R.id.history_all, R.id.history_delect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.history_image:
                finish();
                break;
            case R.id.history_edit:
                if (historyEdit.getText().equals("编辑")) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setCheckbox(true);
                    }
                    historyLinear.setVisibility(View.VISIBLE);
                    historyEdit.setText("完成");
                    adapter.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setCheckbox(false);
                    }
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setFlag(false);
                    }
                    historyLinear.setVisibility(View.GONE);
                    historyEdit.setText("编辑");
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.history_all:
                if (historyAll.getText().equals("全选")) {
                    historyAll.setText("取消全选");
                    if (historyEdit.getText().equals("完成")) {
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).setFlag(true);
                        }
                        number = list.size();
                        historyDelect.setText("删除" + number);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setFlag(false);
                    }
                    number = 0;
                    historyDelect.setText("删除");
                    historyAll.setText("全选");
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.history_delect:
                if (historyEdit.getText().equals("完成")) {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).isFlag()) {
                            myHistroyDao.delete(list.get(i));
                            list.remove(list.get(i));
                        }
                    }
                    number = 0;
                    adapter.notifyDataSetChanged();
                    historyDelect.setText("删除");
                    if (list.size() == 0) {
                        historyEdit.setVisibility(View.GONE);
                        historyRelative.setVisibility(View.GONE);
                        historyBackgroud.setVisibility(View.VISIBLE);
                        historyLinear.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }

    public void createTable() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "histroy.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        myHistroyDao = daoSession.getMyHistroyDao();
    }

    @Override
    public void show(View v,MyHistroy myHistroy, int postion) {
        if(historyEdit.getText().equals("编辑")) {
//            Intent intent = new Intent(HistroyActivity.this, ReportActivity.class);
//            intent.putExtra("url", myHistroy.getMoviepath());
//            intent.putExtra("img", myHistroy.getImg());
//            HistroyActivity.this.startActivity(intent);
        }
        else {
            if (list.get(postion).isFlag() == false) {
                list.get(postion).setFlag(true);
                number++;
                historyDelect.setText("删除" + number);
            } else {
                number--;
                historyDelect.setText("删除" + number);
                HistroyActivity.this.list.get(postion).setFlag(false);
            }
            if (number == 0) {
                historyDelect.setText("删除");
            }

        }
        adapter.notifyDataSetChanged();
    }
}
