package com.wd.home.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.adapter.consultation.DepartmentAdapter;
import com.wd.home.adapter.consultation.DrugAdapter;
import com.wd.home.adapter.consultation.IllnessAdapter;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DoTaskBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.ReleasePatientsBean;
import com.wd.home.bean.UploadPatientBean;
import com.wd.home.contract.DiseaseContract;
import com.wd.home.presenter.BannerPresenter;
import com.wd.home.presenter.DiseasePresenter;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment
 * @anthor hp
 * @time 2019/12/18 13:57
 */
public class Drug_Fragment extends BaseFragment<DiseasePresenter> implements DiseaseContract.Iview {

    private RecyclerView illness_recy;
    private RecyclerView department_recy;
    private List<DepartmentBean.ResultBean> result;
    private List<DiseaseBean.ResultBean> result1;

    @Override
    protected DiseasePresenter providePresenter() {
        return new  DiseasePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_illness;
    }

    @Override
    protected void initView() {
        super.initView();
        illness_recy = getActivity().findViewById(R.id.illness_recy);
        department_recy = getActivity().findViewById(R.id.department_recy);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        department_recy.setLayoutManager(linearLayoutManager);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        illness_recy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.depart();
        mPresenter.disease(7);
    }

   //查询科室
    @Override
    public void depart(DepartmentBean departmentBean) {
        result = departmentBean.getResult();
        DepartmentAdapter departmentAdapter = new DepartmentAdapter(result, getContext());
        department_recy.setAdapter(departmentAdapter);

        departmentAdapter.onItemClickListener(new DepartmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = result.get(position).getId();
                mPresenter.disease(id);
            }
        });

    }

   //根据科室查询对应病症
    @Override
    public void disease(DiseaseBean diseaseBean) {
        result1 = diseaseBean.getResult();
        IllnessAdapter illnessAdapter = new IllnessAdapter(result1,getContext());
        illness_recy.setAdapter(illnessAdapter);

    }

    @Override
    public void uploadsick(UploadPatientBean uploadPatientBean) {

    }

    @Override
    public void publishsick(ReleasePatientsBean releasePatientsBean) {

    }

    @Override
    public void dotask(DoTaskBean doTaskBean) {

    }


}
