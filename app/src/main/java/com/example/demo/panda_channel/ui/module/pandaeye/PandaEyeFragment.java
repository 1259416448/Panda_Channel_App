package com.example.demo.panda_channel.ui.module.pandaeye;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.PandaEyesChildDataBean;
import com.example.demo.panda_channel.model.entity.PandaEyesDataBean;
import com.example.demo.panda_channel.ui.module.pandaeye.adapter.PandaEyeXrecyclerAdapter;
import com.example.demo.panda_channel.utils.ACache;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class PandaEyeFragment extends BaseFragment implements PandaEyeContract.View {
    private ImageView img;
    private TextView title;
    private PandaEyeContract.Presenter presenter;
    @BindView(R.id.panda_eye_xrecycler)
    XRecyclerView pandaEyeXrecycler;
    private PandaEyeXrecyclerAdapter adapter;
    @Override
    protected int getLayoutId() {
        new PandaEyePresenter(this);
        return R.layout.pandaeye_fragment;
    }
    private ArrayList<PandaEyesChildDataBean.ListBean> pandachilddatalist=new ArrayList<>();
    @Override
    protected void init(View view) {
        presenter.start();
    }

    @Override
    protected void loadData() {
        pandaEyeXrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =new PandaEyeXrecyclerAdapter(getActivity(),pandachilddatalist);
        pandaEyeXrecycler.setAdapter(adapter);
        pandaEyeXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                pandaEyeXrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                pandaEyeXrecycler.loadMoreComplete();
            }
        });
        header = LayoutInflater.from(getContext()).inflate(R.layout.pandaeye_xrecyclerview_header, null);
        pandaEyeXrecycler.addHeaderView(header);
        img = (ImageView) header.findViewById(R.id.pandaeye_xrecyclerview_header_img);
        title = (TextView) header.findViewById(R.id.pandaeye_xrecyclerview_header_title);

    }

    private View header;
    @Override
    public void setPresenter(PandaEyeContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void PandaEyesDataBeanSuccess(PandaEyesDataBean bean) {
        Glide.with(getActivity()).load(bean.getData().getBigImg().get(0).getImage()).into(img);
        title.setText(bean.getData().getBigImg().get(0).getTitle());
        presenter.PandaEyeChildUrl(bean.getData().getListurl());
    }
    @Override
    public void PandaEyesEorror(String msg) {
        ACache aCache = ACache.get(App.context);
        PandaEyesDataBean bean = (PandaEyesDataBean) aCache.getAsObject("PandaEyesDataBean");
        Glide.with(getActivity()).load(bean.getData().getBigImg().get(0).getImage()).into(img);
        title.setText(bean.getData().getBigImg().get(0).getTitle());
        presenter.PandaEyeChildUrl(bean.getData().getListurl());
    }

    @Override
    public void PandaEyesChildDataBeanSuccess(PandaEyesChildDataBean bean) {
        pandachilddatalist.addAll(bean.getList());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void PandaEyesChildEorror(String msg) {
        ACache aCache = ACache.get(App.context);
        PandaEyesChildDataBean bean = (PandaEyesChildDataBean) aCache.getAsObject("PandaEyesChildDataBean");
        pandachilddatalist.addAll(bean.getList());
        adapter.notifyDataSetChanged();
    }
}
