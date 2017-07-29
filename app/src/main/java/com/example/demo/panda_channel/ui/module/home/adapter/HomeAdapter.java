package com.example.demo.panda_channel.ui.module.home.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.panda_channel.R;
import com.example.demo.panda_channel.model.biz.PandaChannelModel;
import com.example.demo.panda_channel.model.biz.PandaChannelModelImpl;
import com.example.demo.panda_channel.model.entity.HomeData;
import com.example.demo.panda_channel.model.entity.HomePandaEyeBean;
import com.example.demo.panda_channel.net.HttpFactroy;
import com.example.demo.panda_channel.net.callback.MyNetWorkCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫雨婷 on 2017/7/28.
 */

public class HomeAdapter extends RecyclerView.Adapter{

    private ArrayList<Object> list;
    private ArrayList<HomePandaEyeBean.ListBean> lists=new ArrayList<>();
    private Context context;
    public static final int ITEMCOUNT = 9;//9种不同类型的item
    public static final int BIGIMG = 0;//轮播图
    public static final int AREA = 1;//精彩推荐
    public static final int PANDAEYE = 2;//熊猫观察
    public static final int PANDALIVE = 3;//熊猫直播
    public static final int WALLLIVE = 4;//长城直播
    public static final int CHINALIVE = 5;//直播中国
    public static final int INTERACTIVE = 6;//特别策划
    public static final int CCTV = 7;//CCTV
    public static final int LIST = 8;//光影中国

    public HomeAdapter(ArrayList<Object> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       switch (viewType){
           case BIGIMG:
               View bigimg= LayoutInflater.from(context).inflate(R.layout.home_bigimg,null);
               return new BigImgHolder(bigimg);
           case AREA:
               View area=LayoutInflater.from(context).inflate(R.layout.home_area,null);
               return new AreaHolder(area);
           case PANDAEYE:
               View pandaEye=LayoutInflater.from(context).inflate(R.layout.home_pandaeye,null);
               return new PandaEyeHolder(pandaEye);
           case PANDALIVE:
               View pandaLive=LayoutInflater.from(context).inflate(R.layout.home_pandalive,null);
               return new PandaLiveHolder(pandaLive);
           case WALLLIVE:
               View wallLive=LayoutInflater.from(context).inflate(R.layout.home_pandalive,null);
               return new PandaLiveHolder(wallLive);
           case CHINALIVE:
               break;
           case INTERACTIVE:
               break;
           case CCTV:
               break;
           case LIST:
               break;
       }

        return null;
    }

    class BigImgHolder extends RecyclerView.ViewHolder{

        private ViewPager bigimgviewpager;
        public BigImgHolder(View itemView) {
            super(itemView);
            bigimgviewpager= (ViewPager) itemView.findViewById(R.id.bigimg_viewpager);
        }
    }

    class AreaHolder extends RecyclerView.ViewHolder{

        private ImageView areaIcon;
        private RecyclerView areaRecyclerView;
        public AreaHolder(View itemView) {
            super(itemView);
            areaIcon= (ImageView) itemView.findViewById(R.id.areaIcon);
            areaRecyclerView= (RecyclerView) itemView.findViewById(R.id.areaRecyclerView);
        }
    }

    class PandaEyeHolder extends RecyclerView.ViewHolder{

        private ImageView pandaeyeimg;
        private TextView onecontent;
        private TextView twocontent;
        private TextView onetx;
        private TextView twotx;
        private RecyclerView videorecycler;

        public PandaEyeHolder(View itemView) {
            super(itemView);
            pandaeyeimg= (ImageView) itemView.findViewById(R.id.panda_eye_img);
            onecontent= (TextView) itemView.findViewById(R.id.panda_eye_onecontent);
            twocontent= (TextView) itemView.findViewById(R.id.panda_eye_twocontent);
            onetx= (TextView) itemView.findViewById(R.id.panda_eye_onetx);
            twotx= (TextView) itemView.findViewById(R.id.panda_eye_twotx);
            videorecycler= (RecyclerView) itemView.findViewById(R.id.home_panda_eye_videorecycler);

        }
    }

    class PandaLiveHolder extends RecyclerView.ViewHolder{

        private TextView hometitle;
        private RecyclerView pandaliverecycler;
        public PandaLiveHolder(View itemView) {
            super(itemView);
            hometitle= (TextView) itemView.findViewById(R.id.home_title);
            pandaliverecycler= (RecyclerView) itemView.findViewById(R.id.pandalive_recycler);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (position){
            case BIGIMG:
                BigImgHolder holder1= (BigImgHolder) holder;
                List<HomeData.DataBean.BigImgBean> bigImg= (List<HomeData.DataBean.BigImgBean>) list.get(position);
                loadBigImg(holder1,bigImg);
                break;
            case AREA:
                AreaHolder holder2= (AreaHolder) holder;
                HomeData.DataBean.AreaBean areaBean = (HomeData.DataBean.AreaBean) list.get(position);
                loadArea(holder2,areaBean);
                break;
            case PANDAEYE:
                PandaEyeHolder holder3= (PandaEyeHolder) holder;
                HomeData.DataBean.PandaeyeBean pandaeyeBean= (HomeData.DataBean.PandaeyeBean) list.get(position);
                loadPandaEye(holder3,pandaeyeBean);
                break;
            case PANDALIVE:
                PandaLiveHolder holder4= (PandaLiveHolder) holder;
                HomeData.DataBean.PandaliveBean pandaliveBean= (HomeData.DataBean.PandaliveBean) list.get(position);
                loadPandaLive(holder4,pandaliveBean);
                break;
            case WALLLIVE:
                PandaLiveHolder holder5= (PandaLiveHolder) holder;
                HomeData.DataBean.WallliveBean wallliveBean= (HomeData.DataBean.WallliveBean) list.get(position);
                loadWallLive(holder5,wallliveBean);
                break;
        }
    }

    private void loadBigImg(BigImgHolder holder, List<HomeData.DataBean.BigImgBean> bigImgs){
        ViewPager viewPager = holder.bigimgviewpager;
        List<ImageView> imgs = new ArrayList<>();
        for (HomeData.DataBean.BigImgBean imgBean : bigImgs){
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams params =
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            HttpFactroy.create().loadImage(imgBean.getImage(),imageView);
            imgs.add(imageView);
        }
        viewPager.setAdapter(new HomeBigImgAdapter(imgs));
    }

    private void loadArea(AreaHolder holder,HomeData.DataBean.AreaBean areaBean){
        List<HomeData.DataBean.AreaBean.ListscrollBean> areas = areaBean.getListscroll();
        ImageView areaIcon = holder.areaIcon;
        HttpFactroy.create().loadImage(areaBean.getImage(),areaIcon);
        RecyclerView recyclerView = holder.areaRecyclerView;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new HomeAreaAdapter(context,areas));
    }

    private void loadPandaEye(PandaEyeHolder holder,HomeData.DataBean.PandaeyeBean pandaeyeBean){
        List<HomeData.DataBean.PandaeyeBean.ItemsBean> items = pandaeyeBean.getItems();
        ImageView pandaeyeimg = holder.pandaeyeimg;
        HttpFactroy.create().loadImage(pandaeyeBean.getPandaeyelogo(),pandaeyeimg);
        holder.onetx.setText(items.get(0).getBrief());
        holder.twotx.setText(items.get(1).getBrief());
        holder.onecontent.setText(items.get(0).getTitle());
        holder.twocontent.setText(items.get(1).getTitle());
        final RecyclerView videorecycler = holder.videorecycler;
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        videorecycler.setLayoutManager(manager);
        final HomePandaEyeAdapter adapter=new HomePandaEyeAdapter(context,lists);
        videorecycler.setAdapter(adapter);
        PandaChannelModel model=new PandaChannelModelImpl();
        model.getHomePandaEye(new MyNetWorkCallBack<HomePandaEyeBean>() {
            @Override
            public void onSuccess(HomePandaEyeBean homePandaEyeBean) {
                List<HomePandaEyeBean.ListBean> listBeen = homePandaEyeBean.getList();
                lists.clear();
                lists.addAll(listBeen);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    private void loadPandaLive(PandaLiveHolder holder,HomeData.DataBean.PandaliveBean pandaliveBean){
        List<HomeData.DataBean.PandaliveBean.ListBean> list = pandaliveBean.getList();
        RecyclerView recyclerView = holder.pandaliverecycler;
        GridLayoutManager manager=new GridLayoutManager(context,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new HomePandaLiveAdapter(list,context));
    }

    private void loadWallLive(PandaLiveHolder holder,HomeData.DataBean.WallliveBean wallliveBean){
        List<HomeData.DataBean.WallliveBean.ListBeanX> list = wallliveBean.getList();
        RecyclerView pandaliverecycler = holder.pandaliverecycler;
        TextView hometitle = holder.hometitle;
        hometitle.setText("长城直播");
        GridLayoutManager manager=new GridLayoutManager(context,3);
        pandaliverecycler.setLayoutManager(manager);
        pandaliverecycler.setAdapter(new HomeWallLiveAdapter(list,context));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object o = list.get(position);
        if(position==0){
            return BIGIMG;
        } else if (o instanceof HomeData.DataBean.AreaBean) {
            return AREA;
        } else if (o instanceof HomeData.DataBean.PandaeyeBean) {
            return PANDAEYE;
        } else if (o instanceof HomeData.DataBean.PandaliveBean) {
            return PANDALIVE;
        } else if (o instanceof HomeData.DataBean.WallliveBean) {
            return WALLLIVE;
        } else if (o instanceof HomeData.DataBean.ChinaliveBean) {
            return CHINALIVE;
        } else if (o instanceof HomeData.DataBean.InteractiveBean) {
            return INTERACTIVE;
        } else if (o instanceof HomeData.DataBean.CctvBean) {
            return CCTV;
        } else if (o instanceof HomeData.DataBean.ListBeanXXX) {
            return LIST;
        }
        return super.getItemViewType(position);
    }
}
