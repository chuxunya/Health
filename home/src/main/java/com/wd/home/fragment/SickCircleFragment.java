package com.wd.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.home.R;
import com.wd.home.adapter.sickcirclelist.RecyclerSickCircleAdapter;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.SickContract;
import com.wd.home.presenter.BannerPresenter;
import com.wd.home.presenter.SickPresenter;
import com.wd.home.view.PatientDetailsActivity;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment
 * @anthor hp
 * @time 2019/12/20 17:25
 */
public class SickCircleFragment extends BaseFragment<SickPresenter> implements SickContract.Iview {


    private XRecyclerView patient_recycler_sick_circle_list;
    private int page = 1;
    private int count1 = 10;
    private int anInt;
    private List<SickCircleListBean.ResultBean> result;

    @Override
    protected SickPresenter providePresenter() {
        return new SickPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.sickcirclefragment;
    }

    @Override
    protected void initView() {
        super.initView();

        patient_recycler_sick_circle_list = getActivity().findViewById(R.id.patient_recycler_sick_circle_list);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.sick(anInt, page, count1);
        patient_recycler_sick_circle_list.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.sick(anInt, page, count1);
                patient_recycler_sick_circle_list.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.sick(anInt, page, count1);
                patient_recycler_sick_circle_list.loadMoreComplete();

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        patient_recycler_sick_circle_list.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        anInt = bundle.getInt("anInt");
    }

    @Override
    public void sick(SickCircleListBean sickCircleListBean) {
        result = sickCircleListBean.getResult();
        RecyclerSickCircleAdapter recyclerSickCircleAdapter = new RecyclerSickCircleAdapter(result, getContext());
        patient_recycler_sick_circle_list.setAdapter(recyclerSickCircleAdapter);
        recyclerSickCircleAdapter.addData(result);

        recyclerSickCircleAdapter.onItemClickListener(new RecyclerSickCircleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, int sickCircleId) {
                Intent intent = new Intent(getActivity(), PatientDetailsActivity.class);
                intent.putExtra("sickCircleId", sickCircleId);
                startActivity(intent);
            }
        });

    }
}
