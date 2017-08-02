package com.example.demo.panda_channel.ui.module.home;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.activity.report.ReportActivity;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.config.Urls;
import com.example.demo.panda_channel.db.histroy.DaoMaster;
import com.example.demo.panda_channel.db.histroy.DaoSession;
import com.example.demo.panda_channel.db.histroy.MyHistroy;
import com.example.demo.panda_channel.db.histroy.MyHistroyDao;
import com.example.demo.panda_channel.model.entity.CCTVBean;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.model.entity.LightChinaBean;
import com.example.demo.panda_channel.ui.module.home.adapter.HomeAdapter;
import com.example.demo.panda_channel.utils.ACache;
import com.example.demo.panda_channel.widget.manager.ToastManager;
import com.example.demo.panda_channel.widget.view.CustomDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        adapter.setOnClickListener(new HomeAdapter.setOnClickListener() {


            @Override
            public void setViwpagerListener(int pos, List<HomeData.DataBean.BigImgBean> bigImg) {

                ToastManager.show(pos+"");
            }

            @Override
            public void setWonderfulListener(HomeData.DataBean.AreaBean.ListscrollBean wonderbean) {
                ToastManager.show("这是精彩推荐");

                Intent intent = new Intent(getActivity(), ReportActivity.class);
                intent.putExtra("url", Urls.VIDEOURL + "?pid=" + wonderbean.getPid());
                intent.putExtra("img", wonderbean.getImage());
                getActivity().startActivity(intent);


                MyHistroy dataBean = new MyHistroy();
                dataBean.setTitle(wonderbean.getTitle());
                dataBean.setMoviepath(Urls.VIDEOURL + "?pid=" + wonderbean.getPid());
                dataBean.setImg(wonderbean.getImage());
                dataBean.setDate("");
                myHistroyDao.insert(dataBean);
            }

            @Override
            public void setPandaeyeVideoListener(HomePandaEyeBean.ListBean pandaeyebean) {
                ToastManager.show("这是熊猫观察item");

//                Intent intent = new Intent(getActivity(), ReportActivity.class);
//                intent.putExtra("url", Urls.VIDEOURL + "?pid=" + pandaeyebean.getPid());
//                intent.putExtra("img", pandaeyebean.getImage());
//                getActivity().startActivity(intent);

                MyHistroy dataBean = new MyHistroy();
                dataBean.setTitle(pandaeyebean.getTitle());
                dataBean.setMoviepath(Urls.VIDEOURL + "?pid=" + pandaeyebean.getPid());
                dataBean.setImg(pandaeyebean.getImage());
                dataBean.setDate(pandaeyebean.getDaytime());
                myHistroyDao.insert(dataBean);

            }

            @Override
            public void setPandaeyeoneListener(HomeData.DataBean.PandaeyeBean.ItemsBean pandaeyebean) {
                ToastManager.show("这是熊猫观察1");
            }

            @Override
            public void setPandaeyetwoListener(HomeData.DataBean.PandaeyeBean.ItemsBean pandaeyebean) {
                ToastManager.show("这是熊猫观察2");
            }

            @Override
            public void setPandaliveListener(HomeData.DataBean.PandaliveBean.ListBean pandabean) {
                ToastManager.show("这是熊猫直播");
            }

            @Override
            public void setPangtwallliveListener(HomeData.DataBean.WallliveBean.ListBeanX wallbean) {
                ToastManager.show("这是长城直播");
            }

            @Override
            public void setChinaliveListener(HomeData.DataBean.ChinaliveBean.ListBeanXX bean) {
                ToastManager.show("这是直播中国");
            }

            @Override
            public void setInteractliveListener(HomeData.DataBean.InteractiveBean.InteractiveoneBean interbean) {
                ToastManager.show("这是特别策划");
            }

            @Override
            public void setCctvliveListener(CCTVBean.ListBean cctvbean) {
                ToastManager.show("这是cctv");
            }

            @Override
            public void setLightChinaListener(LightChinaBean.ListBean lightbean) {
                ToastManager.show("这是光影中国");
            }
        });
    }

    private MyHistroyDao myHistroyDao;
    public void createTab(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(getActivity(), "histroy.db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession daoSession = daoMaster.newSession();
        myHistroyDao = daoSession.getMyHistroyDao();
    }


    @Override
    protected void loadData() {
        createTab();
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
        ACache aCache=ACache.get(App.context);
        HomeData homeData1 = (HomeData) aCache.getAsObject("HomeData");
        list.add(homeData1);
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

    }
}
