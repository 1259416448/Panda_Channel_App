package com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.model.entity.WacthAndChatDataBean;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat.adapter.WatchRecyclerAdapter;
import com.example.demo.panda_channel.utils.ACache;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/31 0031.
 */

public class WatchAndChatFragment extends BaseFragment implements WatchAndChatFragmentContract.View {
    @BindView(R.id.watch_content)
    EditText watchContent;
    @BindView(R.id.watch_btsend)
    Button watchBtsend;
    @BindView(R.id.watchrecyclerview)
    XRecyclerView watchrecyclerview;
    private int page=1;
    private WatchAndChatFragmentContract.Presenter presenter;
    private ArrayList<WacthAndChatDataBean.DataBean.ContentBean> list=new ArrayList<>();
    private WatchRecyclerAdapter adapter;
    private String urls;
    public WatchAndChatFragment(String urls) {
        this.urls = urls;
    }

    @Override
    protected int getLayoutId() {
        new WachtAndChatFragmentPresenter(this);
        return R.layout.watchandchatfragment;
    }

    @Override
    protected void init(View view) {
        adapter=new WatchRecyclerAdapter(list,getActivity());
        watchrecyclerview.setLoadingMoreProgressStyle(R.drawable.loading_12);
        watchrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        watchrecyclerview.setAdapter(adapter);
        presenter.start();
        presenter.NetHttpUrl(Urls.watch+"?app=ipandaApp&itemid="+urls+"&nature=1&page="+page);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void setPresenter(WatchAndChatFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
    @Override
    public void Success(WacthAndChatDataBean bean) {
        for (int i=0;i<bean.getData().getContent().size();i++){
            list.add(bean.getData().getContent().get(i));
        }
        adapter.notifyDataSetChanged();
        watchrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                watchrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.NetHttpUrl(Urls.watch+"?app=ipandaApp&itemid="+urls+"&nature=1&page="+page);
                watchrecyclerview.loadMoreComplete();
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void Error(String msg) {
        ACache aCache = ACache.get(App.context);
        WacthAndChatDataBean bean = (WacthAndChatDataBean) aCache.getAsObject("WacthAndChatDataBean");
        for (int i=0;i<bean.getData().getContent().size();i++){
            list.add(bean.getData().getContent().get(i));
        }
        adapter.notifyDataSetChanged();
        watchrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                watchrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                watchrecyclerview.loadMoreComplete();
            }
        });
    }
}
