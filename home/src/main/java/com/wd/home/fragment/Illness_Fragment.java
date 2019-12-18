package com.wd.home.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.adapter.consultation.DrugAdapter;
import com.wd.home.adapter.consultation.QueryDrugAdapter;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.contract.DrugsContract;
import com.wd.home.presenter.DrugsPresenter;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.fragment
 * @anthor 药品科目分类列表查询
 * @time 2019/12/18 13:57
 */
public class Illness_Fragment extends BaseFragment<DrugsPresenter> implements DrugsContract.Iview {


    private List<DrugsBean.ResultBean> result;
    private RecyclerView drug_recy;
    private RecyclerView querydrug_recy;
    private List<DrugsKnowBean.ResultBean> result1;
    private DrugAdapter drugAdapter;

    @Override
    protected DrugsPresenter providePresenter() {
        return new DrugsPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_drug;
    }

    @Override
    protected void initView() {
        super.initView();
        drug_recy = getActivity().findViewById(R.id.drug_recy);
        querydrug_recy = getActivity().findViewById(R.id.querydrug_recy);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        drug_recy.setLayoutManager(linearLayoutManager);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        querydrug_recy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.drugscate();
        mPresenter.drugscateknow(1,1,5);
    }

    @Override
    public void drugscate(DrugsBean drugsBean) {
        result = drugsBean.getResult();
        drugAdapter = new DrugAdapter(result,getContext());
        drug_recy.setAdapter(drugAdapter);
        drugAdapter.onItemClickListener(new DrugAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int id = result.get(position).getId();
                mPresenter.drugscateknow(id,1,5);
            }
        });
    }

    @Override
    public void drugscateknow(DrugsKnowBean drugsKnowBean) {
        result1 = drugsKnowBean.getResult();
        QueryDrugAdapter queryDrugAdapter = new QueryDrugAdapter(result1,getContext());
        querydrug_recy.setAdapter(queryDrugAdapter);
    }
}
