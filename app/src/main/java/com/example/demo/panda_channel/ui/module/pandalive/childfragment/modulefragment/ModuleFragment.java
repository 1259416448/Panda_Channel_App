package com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.PandaLiveMoudleDataBean;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.modulefragment.adapter.ModuleXrecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class ModuleFragment extends BaseFragment implements ModuleFragmentContract.View {
    @BindView(R.id.modulefragmentxrecycler)
    XRecyclerView modulefragmentxrecycler;
    private ArrayList<PandaLiveMoudleDataBean.VideoBean> list=new ArrayList<>();
    private ModuleFragmentContract.Presenter presenter;
    private ModuleXrecyclerAdapter adapter;
    private String id;
    private String st = "&n=7&serviceId=panda&o=desc&of=time&p=1";

    public ModuleFragment(String id) {
        this.id = id;
    }

    @Override
    protected int getLayoutId() {
        new ModuleFragmentPresenter(this);
        return R.layout.modulefragment;
    }

    @Override
    protected void init(View view) {
        presenter.start();
        presenter.UrlNetwork(Urls.ORIGINALNEWS + "?vsid=" + id + st);
    }

    @Override
    protected void loadData() {
        adapter =new ModuleXrecyclerAdapter(list,getActivity());
        modulefragmentxrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        modulefragmentxrecycler.setAdapter(adapter);
        modulefragmentxrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                modulefragmentxrecycler.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                modulefragmentxrecycler.loadMoreComplete();
            }
        });
    }

    @Override
    public void setPresenter(ModuleFragmentContract.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void Success(PandaLiveMoudleDataBean bean) {
        list.clear();
        list.addAll(bean.getVideo());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String msg) {

    }
}
