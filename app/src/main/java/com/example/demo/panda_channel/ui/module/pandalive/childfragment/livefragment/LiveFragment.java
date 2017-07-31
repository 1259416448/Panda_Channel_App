package com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.app.App;
import com.example.demo.panda_channel.base.BaseFragment;
import com.example.demo.panda_channel.model.entity.PandaLiveChildLiveDataBean;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.livefragment.adapter.LiveFragmentViewpagerAdapter;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.multiangle.MultiangleLiveFragment;
import com.example.demo.panda_channel.ui.module.pandalive.childfragment.sonfragment.watchandchat.WatchAndChatFragment;
import com.example.demo.panda_channel.utils.ACache;
import com.example.demo.panda_channel.widget.view.CustomViewPager;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/30 0030.
 */

public class LiveFragment extends BaseFragment implements LiveFragmentContract.View {
    @BindView(R.id.pandalive_vido)
    ImageView pandaliveVido;
    @BindView(R.id.pandalivechilid_title)
    TextView pandalivechilidTitle;
    @BindView(R.id.pandalivechilid_button)
    CheckBox pandalivechilidButton;
    @BindView(R.id.pandalivechilid_content)
    TextView pandalivechilidContent;
    @BindView(R.id.pandalivechilid_tablelayout)
    TabLayout pandalivechilidTablelayout;
    @BindView(R.id.pandalivechilid_page)
    CustomViewPager pandalivechilidPage;
    @BindView(R.id.live_view)
    View liveView;
    private ArrayList<Fragment> list=new ArrayList<>();
    private LiveFragmentContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        new LiveFragmentPresenter(this);

        return R.layout.pandachildlivefragment;
    }

    @Override
    protected void init(View view) {
        presenter.start();
    }

    @Override
    protected void loadData() {
        pandalivechilidButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pandalivechilidContent.setVisibility(View.VISIBLE);
                    liveView.setVisibility(View.VISIBLE);
                } else {
                    pandalivechilidContent.setVisibility(View.GONE);
                    liveView.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void ChildLiveFragmentSuccess(PandaLiveChildLiveDataBean bean) {

        Glide.with(getActivity()).load(bean.getLive().get(0).getImage()).into(pandaliveVido);
        pandalivechilidTitle.setText("[正在直播] " + bean.getLive().get(0).getTitle());
        pandalivechilidContent.setText(bean.getLive().get(0).getBrief());
        pandalivechilidPage.setScanScroll(false);
        pandalivechilidPage.setOffscreenPageLimit(2);
        MultiangleLiveFragment multiangleLiveFragment =new MultiangleLiveFragment(bean.getBookmark().getMultiple().get(0).getUrl());
        WatchAndChatFragment watchAndChatFragment =new WatchAndChatFragment(bean.getBookmark().getWatchTalk().get(0).getUrl());
        list.clear();
        list.add(multiangleLiveFragment);
        list.add(watchAndChatFragment);
        LiveFragmentViewpagerAdapter adapter =new LiveFragmentViewpagerAdapter(getChildFragmentManager(),list);
        pandalivechilidPage.setAdapter(adapter);
        pandalivechilidTablelayout.setupWithViewPager(pandalivechilidPage);
    }

    @Override
    public void Error(String msg) {
        ACache aCache = ACache.get(App.context);
        PandaLiveChildLiveDataBean bean = (PandaLiveChildLiveDataBean) aCache.getAsObject("PandaLiveChildLiveDataBean");
        Glide.with(getActivity()).load(bean.getLive().get(0).getImage()).into(pandaliveVido);
        pandalivechilidTitle.setText("[正在直播] " + bean.getLive().get(0).getTitle());
        pandalivechilidContent.setText(bean.getLive().get(0).getBrief());
        pandalivechilidPage.setScanScroll(false);
        MultiangleLiveFragment multiangleLiveFragment =new MultiangleLiveFragment(bean.getBookmark().getMultiple().get(0).getUrl());
        WatchAndChatFragment watchAndChatFragment =new WatchAndChatFragment(bean.getBookmark().getWatchTalk().get(0).getUrl());
        list.clear();
        list.add(multiangleLiveFragment);
        list.add(watchAndChatFragment);
        LiveFragmentViewpagerAdapter adapter =new LiveFragmentViewpagerAdapter(getFragmentManager(),list);
        pandalivechilidPage.setAdapter(adapter);
        pandalivechilidTablelayout.setupWithViewPager(pandalivechilidPage);
    }

    @Override
    public void setPresenter(LiveFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
