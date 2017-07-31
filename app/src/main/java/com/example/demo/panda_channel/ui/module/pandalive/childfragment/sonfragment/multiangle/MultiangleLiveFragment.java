package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.MultiangleLiveDataBean;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle.adapter.MultiangleRecyclerAdapter;
import com.example.demo.panda_channel.utils.ACache;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class MultiangleLiveFragment extends BaseFragment implements MultiangleLiveFragmentContract.View {
    @BindView(R.id.multianglefragment_recycler)
    RecyclerView multianglefragmentRecycler;
    private MultiangleRecyclerAdapter adapter;
    private MultiangleLiveFragmentContract.Presenter presenter;
    private String url;
    public MultiangleLiveFragment(String url) {
        this.url=url;
    }

    @Override
    protected int getLayoutId() {
        new MultiangleLiveFragmentPresenter(this);
        return R.layout.multianglelive_framgmet;
    }

    @Override
    protected void init(View view) {
        presenter.NetHttpUrl(url);
        presenter.start();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setPresenter(MultiangleLiveFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void Success(MultiangleLiveDataBean bean) {
        multianglefragmentRecycler.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter =new MultiangleRecyclerAdapter(bean.getList(),getActivity());
        multianglefragmentRecycler.setAdapter(adapter);
    }

    @Override
    public void Error(String msg) {
        ACache aCache = ACache.get(App.context);
        MultiangleLiveDataBean bean = (MultiangleLiveDataBean) aCache.getAsObject("MultiangleLiveDataBean");
        multianglefragmentRecycler.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter =new MultiangleRecyclerAdapter(bean.getList(),getActivity());
        multianglefragmentRecycler.setAdapter(adapter);
    }
}
