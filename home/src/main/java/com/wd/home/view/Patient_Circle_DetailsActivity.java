package com.wd.home.view;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor h病友圈详情
 * @time 2019/12/19 15:43
 */
public class Patient_Circle_DetailsActivity extends BaseActivity {


    private ImageView patient_activity_iv_intent_release_sickCircle;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_patient_circle_details;
    }

    @Override
    protected void initView() {
        super.initView();

        patient_activity_iv_intent_release_sickCircle = findViewById(R.id.patient_activity_iv_intent_release_sickCircle);
        //跳转发布病友圈
        patient_activity_iv_intent_release_sickCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Patient_Circle_DetailsActivity.this, ReleaseCirclesActivity.class);
                startActivity(intent1);
            }
        });

    }
}
