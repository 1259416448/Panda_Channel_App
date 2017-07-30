package com.example.demo.panda_channel.ui.module.livechina;

import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.ChildFragmentAllBean;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.GildViewAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.LiveChinaViewPagerAdapter;
import com.example.demo.panda_channel.ui.module.livechina.livechinaadapter.UnGildViewAdapter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildPresenter;
import com.example.demo.panda_channel.ui.module.livechina.viewpagerfragment.ChildfragmentFragment;
import com.example.demo.panda_channel.widget.view.CustomViewPager;
import com.example.demo.panda_channel.widget.view.MyGridView;
import com.example.demo.panda_channel.widget.view.MyUnSelectGridView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public class LiveChinaFragment extends BaseFragment implements LiveChinaContract.View {
    @BindView(R.id.live_china_tab)
    TabLayout liveChinaTab;
    @BindView(R.id.live_china_plus)
    ImageView liveChinaPlus;
    @BindView(R.id.live_china_viewpager)
    CustomViewPager liveChinaViewpager;
    Button popupwindBtBianji;
    MyGridView selectGridview;
    MyUnSelectGridView unselectGridvie;
    TextView long_an;
    private LiveChinaContract.Presenter presenter;
    private ArrayList<ChildFragmentAllBean.TablistBean> arr;
    private ArrayList<ChildFragmentAllBean.AlllistBean> list;
    private ArrayList<Fragment> fragments;
    private LiveChinaViewPagerAdapter pagerAdapter;
    private ImageView plus_img_back;
    private UnGildViewAdapter unGildViewAdapter;
    private GildViewAdapter gildViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.livechina_fragment;
    }

    @Override
    protected void init(View view) {
        arr = new ArrayList<>();
        fragments = new ArrayList<>();
        list=new ArrayList<>();
        pagerAdapter = new LiveChinaViewPagerAdapter(getChildFragmentManager(),fragments,arr);
        liveChinaViewpager.setAdapter(pagerAdapter);
        liveChinaViewpager.setScanScroll(false);
        liveChinaTab.setupWithViewPager(liveChinaViewpager);
        liveChinaTab.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void loadData() {
        presenter.start();


    }


    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
    this.presenter=presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }


    @Override
    public void ShowChildFragmentAllBean(ChildFragmentAllBean childFragmentAllBean) {
        arr.addAll(childFragmentAllBean.getTablist());
        list.addAll(childFragmentAllBean.getAlllist());
        for (int i = 0; i < childFragmentAllBean.getTablist().size(); i++) {
            ChildfragmentFragment childfragment = new ChildfragmentFragment(arr.get(i).getUrl());
            new ChildPresenter(childfragment);
            fragments.add(childfragment);
        }
        pagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setError(String msg) {

    }

    @Override
    public void bombWindow() {
        liveChinaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View inflate = View.inflate(getContext(), R.layout.activity_plus, null);
                long_an = (TextView) inflate.findViewById(R.id.long_an);
                selectGridview = (MyGridView) inflate.findViewById(R.id.select_gridview);
                setSelectGridviewAdapter();
                selectGridview.setEnabled(false);
                unselectGridvie = (MyUnSelectGridView) inflate.findViewById(R.id.unselect_gridview);
                setUnselectGridvieAdapter();
                popupwindBtBianji = (Button) inflate.findViewById(R.id.popupwind_bt_bianji);
                setpopupwindBtBianji();
                plus_img_back = (ImageView) inflate.findViewById(R.id.plus_img_back);
                PopupWindow popupWindow=new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.showAsDropDown(inflate, 0, 0);
            }
        });

    }


    public void setpopupwindBtBianji() {
        popupwindBtBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = popupwindBtBianji.getText().toString().trim();
                if(trim.equals("编辑")){
                    selectGridview.setEnabled(true);
                    setGridViewClickListener();
                    popupwindBtBianji.setText("完成");

                    for (int i = 0; i < arr.size(); i++) {
                        arr.get(i).setFlag(true);
                    }
                    gildViewAdapter.notifyDataSetChanged();
                    unGildViewAdapter.notifyDataSetChanged();
                }else if(trim.equals("完成")){
                    for (int i = 0; i < arr.size(); i++) {
                        arr.get(i).setFlag(false);
                    }
                    setSelectGridviewClickListener();
                    gildViewAdapter.notifyDataSetChanged();
                    unGildViewAdapter.notifyDataSetChanged();
                    pagerAdapter.notifyDataSetChanged();
                    selectGridview.setEnabled(false);
                   popupwindBtBianji.setText("编辑");
                }
            }
        });
    }

    public void setSelectGridviewAdapter(){
        gildViewAdapter = new GildViewAdapter(arr,getContext());
        selectGridview.setAdapter(gildViewAdapter);

    }
    public void setUnselectGridvieAdapter(){
        unGildViewAdapter = new UnGildViewAdapter(list,getContext());

        unselectGridvie.setAdapter(unGildViewAdapter);

    }


    public void setGridViewClickListener(){



        unselectGridvie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String trim = popupwindBtBianji.getText().toString().trim();


                    ChildFragmentAllBean.TablistBean tablistBean=new ChildFragmentAllBean.TablistBean();
                    tablistBean.setTitle(list.get(i).getTitle());
                    tablistBean.setUrl(list.get(i).getUrl());
                    tablistBean.setOrder(list.get(i).getOrder());
                    tablistBean.setType(list.get(i).getType());
                    arr.add(tablistBean);

                if(trim.equals("完成")){
                    ChildfragmentFragment childfragment = new ChildfragmentFragment(tablistBean.getUrl());
                    new ChildPresenter(childfragment);
                    fragments.add(childfragment);
                    pagerAdapter.notifyDataSetChanged();
                    gildViewAdapter.notifyDataSetChanged();
                    unGildViewAdapter.notifyDataSetChanged();
                    list.remove(list.get(i));
                    }




            }
        });
    }

    public void setSelectGridviewClickListener(){


        selectGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String trim = popupwindBtBianji.getText().toString().trim();

                if (arr.size() < 5) {
                    Toast.makeText(getContext(), "栏目区，不能少于四个频道", Toast.LENGTH_SHORT).show();
                }else{

                        ChildFragmentAllBean.AlllistBean all = new ChildFragmentAllBean.AlllistBean();
                        all.setTitle(arr.get(i).getTitle());
                        all.setUrl(arr.get(i).getUrl());
                        all.setOrder(arr.get(i).getOrder());
                        all.setType(arr.get(i).getType());
                        list.add(all);
                        gildViewAdapter.notifyDataSetChanged();
                        unGildViewAdapter.notifyDataSetChanged();
                        arr.remove(arr.get(i));
                   /* if(trim.equals("完成")) {

                        fragments.remove(arr.get(i));
                        pagerAdapter.notifyDataSetChanged();
                    }*/
                }

            }
        });
    }

}
