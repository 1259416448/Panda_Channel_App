package com.example.demo.panda_channel.ui.module.home;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.ui.module.home.adapter.HomeAdapter;
import com.example.demo.panda_channel.widget.manager.ToastManager;
import com.example.demo.panda_channel.widget.view.CustomDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {

    @BindView(R.id.xRecyclerView)
    XRecyclerView xRecyclerView;
    private HomeContract.Presenter presenter;
    private ArrayList<Object> list=new ArrayList<>();
    private HomeAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void init(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(false);
        adapter = new HomeAdapter(list,getActivity());
        xRecyclerView.setAdapter(adapter);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.start();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        CustomDialog.getInsent().create(getContext());
    }

    @Override
    public void dismissProgress() {
        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void setListData(HomeData homeData) {
        list.clear();
        list.add(homeData.getData().getBigImg());
        list.add(homeData.getData().getArea());
        list.add(homeData.getData().getPandaeye());
        list.add(homeData.getData().getPandalive());
        list.add(homeData.getData().getWalllive());
        list.add(homeData.getData().getChinalive());
        list.add(homeData.getData().getInteractive());
        list.add(homeData.getData().getCctv());
        list.add(homeData.getData().getList().get(0));
        adapter.notifyDataSetChanged();
        xRecyclerView.refreshComplete();
    }

    @Override
    public void showMessage(String msg) {
        ToastManager.show(msg);
    }
}
