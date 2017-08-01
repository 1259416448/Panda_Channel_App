package com.example.demo.panda_channel.base;


import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.demo.panda_channel.app.App;
import com.umeng.message.PushAgent;

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
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
        PushAgent.getInstance(this).onAppStart();

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
