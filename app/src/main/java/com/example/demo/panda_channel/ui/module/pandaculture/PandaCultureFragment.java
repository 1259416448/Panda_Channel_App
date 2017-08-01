package com.example.demo.panda_channel.ui.module.pandaculture;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.config.GlideImageLoader;
import com.example.demo.panda_channel.model.entity.RollVideoBean;
import com.example.demo.panda_channel.ui.module.pandaculture.adapter.CultureXRecyclerAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


public class PandaCultureFragment extends BaseFragment implements PandaCultureContract.View {


    PandaCultureContract.Presenter presenter;
    @BindView(R.id.CultureXRecycler)
    XRecyclerView CultureXRecycler;
    Unbinder unbinder;
    @BindView(R.id.but)
    Button but;
    Unbinder unbinder1;
    private ArrayList<RollVideoBean.ListBean> arr;
    private ArrayList<RollVideoBean.BigImgBean> list;
    private CultureXRecyclerAdapter adapter;
    private Banner banner;

    @Override
    protected int getLayoutId() {
        return R.layout.pandaculture_fragment;
    }

    @Override
    protected void init(View view) {
        //presenter.start();
    }

    @Override
    protected void loadData() {
        presenter.start();
        arr = new ArrayList<>();
        list = new ArrayList<>();
        CultureXRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CultureXRecyclerAdapter(arr, getContext());
        CultureXRecycler.setAdapter(adapter);
        View inflate = View.inflate(getContext(), R.layout.pager_item, null);
        banner = (Banner) inflate.findViewById(R.id.item_culture_banner);
        CultureXRecycler.addHeaderView(inflate);

      but.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {




          }
      });
    }


    @Override
    public void setPresenter(PandaCultureContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showRollVideoBean(RollVideoBean rollVideoBean) {
        arr.addAll(rollVideoBean.getList());
        list.addAll(rollVideoBean.getBigImg());
        adapter.notifyDataSetChanged();
    }


    @Override
    public void setError(String msg) {

    }

    @Override
    public void setlbo() {
        final List<String> xxx = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            RollVideoBean.BigImgBean bigImgBean = list.get(i);
            xxx.add(bigImgBean.getImage());
        }

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(2000);
        //设置图片集合
        banner.setImages(xxx);
        //设置点的位置
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                RollVideoBean.BigImgBean bigImgBean = list.get(position);
                Toast.makeText(getContext(), "你好啊" + position, Toast.LENGTH_SHORT).show();
            }
        });
        banner.start();

    }


    //


}
