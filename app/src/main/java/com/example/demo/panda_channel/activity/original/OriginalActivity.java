package com.example.demo.panda_channel.activity.original;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.ImageView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseActivity;
import com.example.demo.panda_channel.model.entity.OriginalBean;
import com.example.demo.panda_channel.widget.view.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public class OriginalActivity extends BaseActivity implements OriginalContract.View{

    private OriginalContract.Presenter presenter;

    @BindView(R.id.original_image)
    ImageView originalImage;
    @BindView(R.id.original_recyclerview)
    PullToRefreshRecyclerView originalRecyclerview;
    private ArrayList<OriginalBean.InteractiveBean> list=new ArrayList<>();
    private OriginalAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_original;
    }

    @Override
    protected void init() {
        new OriginalPresenter(this);
        presenter.start();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        originalRecyclerview.setLayoutManager(manager);
        adapter=new OriginalAdapter(this,list);
        originalRecyclerview.setAdapter(adapter);

        originalRecyclerview.setLoadingMoreEnabled(true);
        originalRecyclerview.setPullRefreshEnabled(true);
        originalRecyclerview.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                originalRecyclerview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        originalRecyclerview.setRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onLoadMore() {
                    originalRecyclerview.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                            originalRecyclerview.setLoadMoreComplete();
                        }
                    },1000);
            }
        });
    }


    @OnClick(R.id.original_image)
    public void onViewClicked() {
        finish();
    }


    @Override
    public void setPresenter(OriginalContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {
        CustomDialog.getInsent().create(this);
    }

    @Override
    public void dismissProgress() {
        CustomDialog.getInsent().dismiss();
    }

    @Override
    public void setListData(OriginalBean originalBean) {
        list.addAll(originalBean.getInteractive());
        adapter.notifyDataSetChanged();
    }
}
