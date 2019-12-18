package com.wd.home.view;

import android.content.Intent;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.home.R;

import com.wd.home.bean.DiseaseknowledgeBean;

import com.wd.home.bean.DrugsknowledgeBean;
import com.wd.home.contract.DiseaseKnowContract;
import com.wd.home.presenter.DiseaseKnowPresenter;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor 查询常见病症详情
 * @time 2019/12/18 20:00
 */
public class ConditionDetailsActivity extends BaseActivity<DiseaseKnowPresenter> implements DiseaseKnowContract.Iview{

    private Intent intent;
    private String id;
    private TextView diseaseName, diseasePathology, diseaseSymptom, diseaseBenefitTaboo, diseaseWesternMedicineTreatment, diseaseChineseMedicineTreatment;
    private String name;
    private DiseaseknowledgeBean.ResultBean result;

    @Override
    protected DiseaseKnowPresenter providePresenter() {
        return new DiseaseKnowPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_condition_details;
    }

    @Override
    protected void initView() {
        super.initView();
        diseaseName = findViewById(R.id.disease_name);
        diseasePathology = findViewById(R.id.disease_pathology);
        diseaseSymptom = findViewById(R.id.disease_symptom);
        diseaseBenefitTaboo = findViewById(R.id.disease_benefitTaboo);
        diseaseWesternMedicineTreatment = findViewById(R.id.disease_westernMedicineTreatment);
        diseaseChineseMedicineTreatment = findViewById(R.id.disease_chineseMedicineTreatment);

        intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        diseaseName.setText(name);
        mPresenter.diseaseknowledge(id);
    }

    // 查询常见病症详情
    @Override
    public void diseaseknowledge(DiseaseknowledgeBean diseaseknowledgeBean) {
        result = diseaseknowledgeBean.getResult();
        diseasePathology.setText(result.getPathology());
        diseaseSymptom.setText(result.getSymptom());
        diseaseBenefitTaboo.setText(result.getBenefitTaboo());
        diseaseChineseMedicineTreatment.setText(result.getChineseMedicineTreatment());
    }

    @Override
    public void drugsknowledge(DrugsknowledgeBean drugsknowledgeBean) {

    }
}
