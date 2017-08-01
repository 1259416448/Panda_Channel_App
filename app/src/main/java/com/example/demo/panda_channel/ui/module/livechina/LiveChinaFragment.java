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
    private PopupWindow popupWindow;

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
        presenter.getData();
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

                setGridViewClickListener();
                setSelectGridviewClickListener();
                plus_img_back = (ImageView) inflate.findViewById(R.id.plus_img_back);

                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
                popupWindow.setBackgroundDrawable(new ColorDrawable());
                popupWindow.showAsDropDown(inflate, 0, 0);
                setPlus_img_back();
            }
        });

    }


    public void setpopupwindBtBianji() {
        popupwindBtBianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = popupwindBtBianji.getText().toString().trim();
                presenter.setBtBianjilogic(trim,popupwindBtBianji,selectGridview,unselectGridvie,arr,gildViewAdapter,unGildViewAdapter,pagerAdapter);
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
                presenter.setUnselectGridvie(trim,fragments,arr,gildViewAdapter,list,unGildViewAdapter,pagerAdapter,i);
            }
        });
    }

    public void setSelectGridviewClickListener(){


        selectGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String trim = popupwindBtBianji.getText().toString().trim();
                presenter.setSelectGridview(trim,fragments,arr,gildViewAdapter,list,unGildViewAdapter,pagerAdapter,i);
            }
        });
    }
//..

    public void setPlus_img_back(){
        plus_img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < arr.size(); i++) {
                    arr.get(i).setFlag(false);
                }
                String trim = popupwindBtBianji.getText().toString().trim();

                if(trim.equals("编辑")){
                    popupWindow.dismiss();
                }else{
                    Toast.makeText(getContext(), "请点击完成保存", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
