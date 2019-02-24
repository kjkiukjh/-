package com.li.tb_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment{
    View view;
    /**
     * 模拟请求后得到的数据
     */
    List<Info> mList = new ArrayList<>();

    /**
     * 轮播图
     */
    CycleViewPager mCycleViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recylerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new GoodsList_Adapter(getContext(), this, getGoodsLists()));

        initData();
        initView();
        return view;
    }

    private List<GoodsInfoBean> getGoodsLists(){
        List<GoodsInfoBean> datas = new ArrayList<>();
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品1", "商品1的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品2", "商品2的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品3", "商品3的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品4", "商品4的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品5", "商品5的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品6", "商品6的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品7", "商品7的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品8", "商品8的信息介绍"));
        datas.add(new GoodsInfoBean(R.mipmap.ic_launcher, "商品9", "商品9的信息介绍"));
        return datas;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mList.add(new Info("标题1",R.drawable.ncvt_wifi_head));
        mList.add(new Info("标题2",R.drawable.img1));
        mList.add(new Info("标题3",R.drawable.img2));
        mList.add(new Info("标题4",R.drawable.img3));
    }

    /**
     * 初始化View
     */
    private void initView() {
        mCycleViewPager = (CycleViewPager) view.findViewById(R.id.cycle_view);
        //设置选中和未选中时的图片
        mCycleViewPager.setIndicators(R.drawable.ic_dot_select, R.drawable.ic_dot_normal);
        //设置轮播间隔时间
        mCycleViewPager.setDelay(2000);
        mCycleViewPager.setData(mList, mAdCycleViewListener);
    }

    /**
     * 轮播图点击监听
     */
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener =
            new CycleViewPager.ImageCycleViewListener() {

                @Override
                public void onImageClick(Info info, int position, View imageView) {

                    if (mCycleViewPager.isCycle()) {
                        position = position - 1;
                    }
                    Toast.makeText(getActivity(), info.getTitle() +
                            "选择了--" + position, Toast.LENGTH_LONG).show();
                }
            };

}
