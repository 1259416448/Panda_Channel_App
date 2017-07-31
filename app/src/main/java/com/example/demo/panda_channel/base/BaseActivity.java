package com.example.demo.panda_channel.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.demo.panda_channel.app.App;

import butterknife.ButterKnife;

/**
 * Created by 闫雨婷 on 2017/7/27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }

    protected abstract int getLayoutId();
    protected abstract void init();

    public BaseFragment changeFragment(Class<? extends BaseFragment> fragmentClass,int containId,boolean isHidden,Bundle bundle,boolean isBack) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        String fragmentName = fragmentClass.getSimpleName();

        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
        if(currentFragment == null){
            try {
                //使用java动态代理
                currentFragment = fragmentClass.newInstance();
                transaction.add(containId,currentFragment,fragmentName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if(isHidden) {
            if (lastFragment != null)
                transaction.hide(lastFragment);
            transaction.show(currentFragment);
        }else {
            transaction.replace(containId,currentFragment,fragmentName);
        }
        //传递参数
        if(bundle != null){
           currentFragment.setBundle(bundle);
        }

        if(isBack){
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();

        lastFragment = currentFragment;

        return lastFragment;

    }

//    public void onBackPressed(){
//        String lastFragmentName = getLastFragmentName();
//        if("HomeFragment".equals(lastFragmentName)||"LiveChinaFragment".equals(lastFragmentName)||"PandaCultureFragment".equals(lastFragmentName)||"PandaEyeFragment".equals(lastFragmentName)||"PandaLiveFragment".equals(lastFragmentName)){
//
//
//        }
//
//    }
//
//    private String getLastFragmentName(){
//        getFragmentManager().getBackStackEntryCount();
//
//        return null;
//    }


    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }
}
