package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.contract.MyHistoryContract;
import com.wd.health.presenter.MyHistoryPresenter;

/**
 *@describe(描述)：EvaluationInquiryMainActivity
 *@data（日期）: 2019/12/28
 *@time（时间）: 10:23
 *@author（作者）: 张安恒 用户评论问诊服务
 **/
public class EvaluationInquiryMainActivity extends BaseActivity<MyHistoryPresenter> implements MyHistoryContract.Iview {

    private EditText evaluate;
    private RatingBar majorDegree;
    private RatingBar satisfactionDegree;
    private Button evaluation_back;
    private Button evaluation_finish;
    private int recordId;
    private int doctorId;
    private int satisfactionDegrees;
    private int majorDegrees;
    private Editable text;

    @Override
    protected MyHistoryPresenter providePresenter() {
        return new MyHistoryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_evaluation_inquiry_main;
    }

    @Override
    protected void initView() {
        super.initView();
        evaluate = (EditText) findViewById(R.id.evaluate);
        majorDegree = (RatingBar) findViewById(R.id.majorDegree);
        satisfactionDegree = (RatingBar) findViewById(R.id.satisfactionDegree);
        evaluation_back = (Button) findViewById(R.id.evaluation_back);
        evaluation_finish = (Button) findViewById(R.id.evaluation_finish);
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        recordId = intent.getIntExtra("recordId",0);
        doctorId = intent.getIntExtra("doctorId",0);
        Log.i("recoidxxx", "initData: "+recordId);
        text = evaluate.getText();
        //完成评价
        evaluation_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.Evaluation(recordId+"",doctorId+"", text +"","5", "5");
                 }
        });
        //返回
        evaluation_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void myhistory(FindHistoryBean findHistoryBean) {

    }

    //用户评论问诊服务
    @Override
    public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {
        Log.i("xxxevaluationInquir", "evaluation: "+evaluationInquiryBean.getMessage());
        if (evaluationInquiryBean.getStatus().equals("0000")){
            Toast.makeText(this, evaluationInquiryBean.getMessage(), Toast.LENGTH_SHORT).show();

        }else if (evaluationInquiryBean.getStatus().equals("8001")){
            Toast.makeText(this, evaluationInquiryBean.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {

    }

    @Override
    public void overinquiry(EndInquiryBean endInquiryBean) {

    }
}
