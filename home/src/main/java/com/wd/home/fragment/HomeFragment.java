package com.wd.home.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.stx.xhb.androidx.transformers.Transformer;
import com.wd.home.R;
import com.wd.home.adapter.consultation.ConsultationAdapter;
import com.wd.home.adapter.consultation.NewslistAdapter;
import com.wd.home.adapter.consultation.PlateListAdapter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.presenter.BannerPresenter;
import com.wd.home.view.BannerWebViewMainActivity;
import com.wd.home.view.Collection_detailsActivity;
import com.wd.home.view.Home_searchActivity;
import com.wd.home.view.ReviewsMainActivity;


import java.util.AbstractList;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment
 * @anthor 首页
 * @time 2019/12/14 8:49
 */
public class HomeFragment extends BaseFragment<BannerPresenter> implements BannerContract.Iview{

    private List<BannerBean.ResultBean> result;
    private List<DepartmentBean.ResultBean> beans;
    private XBanner xbanner;
    private RecyclerView consultationRecy;
    private RecyclerView advisory_plate_recy;
    private ConsultationAdapter consultationAdapter;
    private List<InformationBean.ResultBean> beanResult;
    private PlateListAdapter plateListAdapter;
    private List<InformationListBean.ResultBean> resultBeans;
    private RecyclerView advisory_list_recy;
    private TextView home_search;
    private int id;
    private ImageView illness_details;
    private ImageView drug_details;
    private ImageView reviews;

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        super.initView();

        xbanner = getActivity().findViewById(R.id.xbanner);
        consultationRecy = getActivity().findViewById(R.id.consultation_recy);
        advisory_plate_recy = getActivity().findViewById(R.id.advisory_plate_recy);
        advisory_list_recy = getActivity().findViewById(R.id.advisory_list_recy);
        home_search = getActivity().findViewById(R.id.home_search);
        //常见病症
        illness_details = getActivity().findViewById(R.id.illness_details);
        //常用药品
        drug_details = getActivity().findViewById(R.id.drug_details);
        //健康评测
        reviews = getActivity().findViewById(R.id.reviews);

        //健康评测
        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ReviewsMainActivity.class));
            }
        });
        //查询科室列表
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        consultationRecy.setLayoutManager(gridLayoutManager);
        //查询健康资讯板块
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        advisory_plate_recy.setLayoutManager(linearLayoutManager);


        //搜索
        home_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Home_searchActivity.class));
            }
        });

        //常见病症
        illness_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(getContext(), Collection_detailsActivity.class);
                startActivity(intent);
            }
        });
        //常用药品
        drug_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(getContext(), Collection_detailsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.banner();
        mPresenter.department();
        mPresenter.information();
        mPresenter.informationlist(1,1,5);
    }

    //轮播图
    @Override
    public void banner(BannerBean bannerBean) {

        result = bannerBean.getResult();

        xbanner.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }
            @Override
            public int size() {
                return result.size();
            }
        });
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView image_fresco = view.findViewById(R.id.banner_sim);
                Uri parse = Uri.parse(result.get(position).getImageUrl());
                image_fresco.setImageURI(parse);

                xbanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                    @Override
                    public void onItemClick(XBanner banner, Object model, View view, int position) {
                        String jumpUrl = result.get(position).getJumpUrl();

                        Intent intent = new Intent(getContext(), BannerWebViewMainActivity.class);
                        intent.putExtra("jumpUrl",jumpUrl);
                        startActivity(intent);
                    }
                });

            }
        });
        xbanner.setPageTransformer(Transformer.Default);
        xbanner.setAutoPalyTime(2000);
        xbanner.startAutoPlay();
    }

    //查询科室
    @Override
    public void department(DepartmentBean departmentBean) {
        beans = departmentBean.getResult();
        consultationAdapter = new ConsultationAdapter(beans,getContext());
        consultationRecy.setAdapter(consultationAdapter);
    /*    consultationAdapter.onItemClickListener(new ConsultationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getContext(), InquiryMainActivity.class);
                startActivity(intent);
            }
        });*/
    }

    //查询健康资讯
    @Override
    public void information(InformationBean informationBean) {
        beanResult = informationBean.getResult();
        plateListAdapter = new PlateListAdapter(beanResult,getContext());
        advisory_plate_recy.setAdapter(plateListAdapter);

        plateListAdapter.onItemClickListener(new PlateListAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                id = beans.get(position).getId();
                mPresenter.informationlist(id,1,5);
            }
        });
    }

    //根据资讯板块查询资讯列表
    @Override
    public void informationlist(InformationListBean informationListBean) {
        resultBeans = informationListBean.getResult();
        NewslistAdapter newslistAdapter = new NewslistAdapter(resultBeans,getContext());
        //根据资讯板块查询资讯列表
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        advisory_list_recy.setLayoutManager(linearLayoutManager2);
        advisory_list_recy.setAdapter(newslistAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        xbanner.stopAutoPlay();

    }
}
