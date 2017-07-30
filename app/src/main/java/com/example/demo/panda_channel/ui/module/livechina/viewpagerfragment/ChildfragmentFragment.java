package com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.LiveChinaBean;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.BadalingRecyclerviewAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ASUS on 2017/7/29.
 */

public class ChildfragmentFragment extends BaseFragment implements ChildContract.View {

    @BindView(R.id.badaling_recyclerview)
    XRecyclerView badalingRecyclerview;

    private ChildContract.Presenter presenter;
    private String url;
    private ArrayList<LiveChinaBean.LiveBean> arr;
    private BadalingRecyclerviewAdapter adapter;

    public ChildfragmentFragment(String url) {
        this.url = url;
    }

    @Override
    public void setPresenter(ChildContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.badalingfragment;
    }

    @Override
    protected void init(View view) {
        presenter.UrlLiveChinaBean(url);
        arr = new ArrayList<>();
        badalingRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BadalingRecyclerviewAdapter(arr,getContext());
        badalingRecyclerview.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void ShowLiveChinaBean(LiveChinaBean liveChinaBean) {
        arr.addAll(liveChinaBean.getLive());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setError(String msg) {

    }


}
