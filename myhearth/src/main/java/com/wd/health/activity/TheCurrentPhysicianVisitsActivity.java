package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.wd.health.R;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.contract.MyHistoryContract;
import com.wd.health.presenter.MyHistoryPresenter;

import java.text.SimpleDateFormat;

/**
 *@describe(描述)：TheCurrentPhysicianVisitsActivity
 *@data（日期）: 2019/12/30
 *@time（时间）: 9:26
 *@author（作者）: 张安恒 当前问诊
 **/
public class TheCurrentPhysicianVisitsActivity extends BaseActivity<MyHistoryPresenter> implements MyHistoryContract.Iview {
    private ImageView iv_theCurrentPhysicianVisits_back;
    private TextView tv_doctor_name;
    private TextView tv_doctor_position;
    private TextView tv_doctor_subjects;
    private TextView tv_interrogationTime;
    private RelativeLayout rl_currentDoctorInformation;
    private TextView tv_continueToInterrogation;
    private TextView btn_theEndOfTheInterrogation;
    private RelativeLayout rl_currentStatusOfConsultation;
    private RelativeLayout rl_thereIsCurrentlyAConsultation;
    private RelativeLayout rl_noConsultationAtPresent;
    private int recordId;
    private ImageView sdv_doctor_headPortrait;
    private String imagePic;
    private int doctorId;

    @Override
    protected MyHistoryPresenter providePresenter() {
        return new MyHistoryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_the_current_physician_visits;
    }

    @Override
    protected void initView() {
        super.initView();
        iv_theCurrentPhysicianVisits_back = (ImageView) findViewById(R.id.iv_theCurrentPhysicianVisits_back);
        tv_doctor_name = (TextView) findViewById(R.id.tv_doctor_name);
        tv_doctor_position = (TextView) findViewById(R.id.tv_doctor_position);
        tv_doctor_subjects = (TextView) findViewById(R.id.tv_doctor_subjects);
        tv_interrogationTime = (TextView) findViewById(R.id.tv_interrogationTime);
        tv_continueToInterrogation = (TextView) findViewById(R.id.tv_continueToInterrogation);
        btn_theEndOfTheInterrogation = (TextView) findViewById(R.id.btn_theEndOfTheInterrogation);
        rl_currentDoctorInformation = (RelativeLayout) findViewById(R.id.rl_currentDoctorInformation);
        rl_currentStatusOfConsultation = (RelativeLayout) findViewById(R.id.rl_currentStatusOfConsultation);
        rl_noConsultationAtPresent = (RelativeLayout) findViewById(R.id.rl_noConsultationAtPresent);
        rl_thereIsCurrentlyAConsultation = (RelativeLayout) findViewById(R.id.rl_thereIsCurrentlyAConsultation);
        sdv_doctor_headPortrait = (ImageView) findViewById(R.id.sdv_doctor_headPortrait);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.Current();
        //结束问诊
        btn_theEndOfTheInterrogation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.OverEndquity(recordId+"");
            }
        });
    }

    @Override
    public void myhistory(FindHistoryBean findHistoryBean) {

    }

    @Override
    public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {


    }

    //当前问诊
    @Override
    public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {
        Log.i("assevaluationInquiry", "evaluation: " + currentInquiryRecordBean.getMessage());
        CurrentInquiryRecordBean.ResultBean result = currentInquiryRecordBean.getResult();
        if (result == null) {
            rl_noConsultationAtPresent.setVisibility(View.VISIBLE);
            rl_thereIsCurrentlyAConsultation.setVisibility(View.GONE);
        } else {
            rl_noConsultationAtPresent.setVisibility(View.GONE);
            rl_thereIsCurrentlyAConsultation.setVisibility(View.VISIBLE);
            doctorId = result.getDoctorId();
            recordId = result.getRecordId();
            String imagePic = result.getImagePic();
            String doctorName = result.getDoctorName();
            Log.e("recordId", "CurrentInquiryRecordSuccess: " + recordId);
            tv_doctor_name.setText(doctorName);
            tv_doctor_position.setText(result.getJobTitle());
            tv_doctor_subjects.setText(result.getDepartment());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(result.getInquiryTime());
            tv_interrogationTime.setText(format);

            Glide.with(TheCurrentPhysicianVisitsActivity.this).load(result.getImagePic()).into(sdv_doctor_headPortrait);
        }
    }

    @Override
    public void overinquiry(EndInquiryBean endInquiryBean) {
        if (endInquiryBean.getStatus().equals("0000")){
            Toast.makeText(this, endInquiryBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TheCurrentPhysicianVisitsActivity.this, EvaluationInquiryMainActivity.class);
            intent.putExtra("recordId",recordId);
            intent.putExtra("doctorId",doctorId);
            startActivity(intent);
        }else if (endInquiryBean.getStatus().equals("8001")){;
            Toast.makeText(this, endInquiryBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
