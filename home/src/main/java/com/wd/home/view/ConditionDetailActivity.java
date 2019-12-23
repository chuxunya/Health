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
 * @anthor hp
 * @time 2019/12/19 8:56
 */
public class ConditionDetailActivity extends BaseActivity<DiseaseKnowPresenter> implements DiseaseKnowContract.Iview {

    private Intent intent;
    private String id;
    private String name;
    private DrugsknowledgeBean.ResultBean result;
    private TextView disease_name_yp,yaoping_Cf,yongyao_jj,gongneng_zz,yfyl,ypxz,bzgg,blfy,zzsx,pzwh;

    @Override
    protected DiseaseKnowPresenter providePresenter() {
        return new DiseaseKnowPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_yp_details;
    }

    @Override
    protected void initView() {
        super.initView();
        disease_name_yp = findViewById(R.id.disease_name_yp);
        yaoping_Cf = findViewById(R.id.yaoping_Cf);
        yongyao_jj = findViewById(R.id.yongyao_jj);
        gongneng_zz = findViewById(R.id.gongneng_zz);
        yfyl = findViewById(R.id.yfyl);
        ypxz = findViewById(R.id.ypxz);
        bzgg = findViewById(R.id.bzgg);
        blfy = findViewById(R.id.blfy);
        zzsx = findViewById(R.id.zzsx);
        pzwh = findViewById(R.id.pzwh);

        intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        disease_name_yp.setText(name);
        mPresenter.drugsknowledge(id);
    }

    @Override
    public void diseaseknowledge(DiseaseknowledgeBean diseaseknowledgeBean) {

    }

    @Override
    public void drugsknowledge(DrugsknowledgeBean drugsknowledgeBean) {
        result = drugsknowledgeBean.getResult();
        yaoping_Cf.setText(result.getComponent());
        yongyao_jj.setText(result.getMindMatter());
        gongneng_zz.setText(result.getEffect());
        yfyl.setText(result.getUsage());
        ypxz.setText(result.getShape());
        bzgg.setText(result.getPacking());
        blfy.setText(result.getSideEffects());
        zzsx.setText(result.getTaboo());
        pzwh.setText(result.getApprovalNumber());



    }
}
