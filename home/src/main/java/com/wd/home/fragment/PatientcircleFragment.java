package com.wd.home.fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.home.R;
import com.wd.home.adapter.KeywordSearchAdapter;
import com.wd.home.adapter.RecyclerConsultationAdapter;
import com.wd.home.adapter.consultation.ConsultationAdapter;
import com.wd.home.adapter.sickcirclelist.RecyclerSickCircleAdapter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.KeywordSearchBean;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.presenter.BannerPresenter;
import com.wd.home.view.ObservableScrollView;
import com.wd.home.view.PatientDetailsActivity;
import com.wd.home.view.Patient_Circle_DetailsActivity;
import com.wd.home.view.SearchActivity;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment
 * @anthor 病友圈首页
 * @time 2019/12/14 8:50
 */
public class PatientcircleFragment extends BaseFragment<BannerPresenter> implements BannerContract.Iview,ObservableScrollView.ScrollViewListener {

    //用户头像
    private ImageView patient_iv_user_head_pic;
    //用户收到的消息
    private ImageView patient_iv_user_message;
    //搜索框
    private ImageView patient_iv_search;
    private int page = 1;
    private int count = 5;
    private RecyclerView patient_recycler_department;
    private XRecyclerView patient_recycler_sick_circle_list;
    private List<DepartmentBean.ResultBean> result;

    private RelativeLayout patient_relative_titlebar;
    private TextView patient_tv_department_name;
    private TextView patient_fragment_tv_select;
    //用户收到的消息
    private ImageView patient_iv_user_news;
    private RelativeLayout patient_relative_serach;
    private ObservableScrollView patient_scorll_view;
    private RelativeLayout patient_linear_layout;
    private int mImageHeight;
    private RecyclerConsultationAdapter recyclerConsultationAdapter;
    private int id;
    private int positions;
    private List<SickCircleListBean.ResultBean> sickCircleListBeanResult;
    private RecyclerSickCircleAdapter recyclerSickCircleAdapter;
    private TabLayout patient_tablayout;
    private ViewPager patient_viewpager;
    private String departmentName;
    private int anInt;
    private XRecyclerView xiangxi_rlv;
    private EditText patient_tv_department_keyword;
    private KeywordSearchAdapter keywordSearchAdapter;
    private String trim;

    @Override
    protected int provideLayoutId() {
        return R.layout.patientcirclefragment;

    }

    @Override
    protected void initView() {
        super.initView();
        patient_iv_user_head_pic = getActivity().findViewById(R.id.patient_iv_user_head_pic);
        patient_iv_user_message = getActivity().findViewById(R.id.patient_iv_user_message);
        patient_iv_search = getActivity().findViewById(R.id.patient_iv_search);
        patient_relative_titlebar = getActivity().findViewById(R.id.patient_relative_titlebar);
        patient_tv_department_name = getActivity().findViewById(R.id.patient_tv_department_name);
        patient_iv_user_news = getActivity().findViewById(R.id.patient_iv_user_news);
        patient_relative_serach = getActivity().findViewById(R.id.patient_relative_serach);
        patient_scorll_view = getActivity().findViewById(R.id.patient_scorll_view);
        patient_linear_layout = getActivity().findViewById(R.id.patient_linear_layout);
        patient_tablayout = getActivity().findViewById(R.id.patient_tablayout);
        patient_viewpager = getActivity().findViewById(R.id.patient_viewpager);
        xiangxi_rlv = getActivity().findViewById(R.id.xiangxi_rlv);
        patient_tv_department_keyword = getActivity().findViewById(R.id.patient_tv_department_keyword);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        xiangxi_rlv.setLayoutManager(linearLayoutManager1);
        //设置ScrollView的滑动监听,
        patient_scorll_view.setScrollViewListener(this);
        initListener();
    }


    private void initListener() {
        //获取控件的视图观察者,一遍通过视图观察者得到控件的宽高属性
        ViewTreeObserver viewTreeObserver = patient_linear_layout.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                //此时就可以得到控件的高度
                mImageHeight = patient_linear_layout.getHeight();
                //我们做的第一件事情就是移除监听,卸磨杀驴,减少内存的消耗
                patient_linear_layout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.department();
        //搜索框
        patient_tv_department_keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                trim = patient_tv_department_keyword.getText().toString().trim();
                if (trim != null) {
                    mPresenter.keywordsearchbean(trim);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        patient_iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void banner(BannerBean bannerBean) {

    }

    //科室列表
    @Override
    public void department(DepartmentBean departmentBean) {
        result = departmentBean.getResult();
        patient_tablayout.setupWithViewPager(patient_viewpager);
        patient_viewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                departmentName = result.get(position).getDepartmentName();
                SickCircleFragment sickCircleFragment = new SickCircleFragment();
                Bundle bundle = new Bundle();
                anInt = result.get(position).getId();
                bundle.putInt("anInt", anInt);
                sickCircleFragment.setArguments(bundle);
                patient_tv_department_name.setText(departmentName);
                return sickCircleFragment;
            }

            @Override
            public int getCount() {
                return result.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return result.get(position).getDepartmentName();
            }
        });
        patient_tablayout.setupWithViewPager(patient_viewpager);


        };




    @Override
    public void information(InformationBean informationBean) {

    }

    @Override
    public void informationlist(InformationListBean informationListBean) {

    }

    //根据关键词查询病友圈
    @Override
    public void keywordsearchbean(KeywordSearchBean keywordSearchBean) {
        xiangxi_rlv.setVisibility(View.VISIBLE);
        List<KeywordSearchBean.ResultBean> result = keywordSearchBean.getResult();
        keywordSearchAdapter = new KeywordSearchAdapter(getContext());
        xiangxi_rlv.setAdapter(keywordSearchAdapter);
        keywordSearchAdapter.addData(result);
        keywordSearchAdapter.onItemClickListener(new KeywordSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int id) {
                int sickCircleId = result.get(position).getSickCircleId();
                Intent intent = new Intent(getContext(), PatientDetailsActivity.class);
                intent.putExtra("sickCircleId", sickCircleId);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
        if (t <= 10) {
            patient_relative_titlebar.setVisibility(View.VISIBLE);
            patient_relative_serach.setVisibility(View.GONE);
        } else if (t > 10 && t < mImageHeight) {
            patient_relative_serach.setVisibility(View.VISIBLE);
            patient_relative_titlebar.setVisibility(View.GONE);
            patient_tv_department_name.setText(departmentName);
        }
    }
}
