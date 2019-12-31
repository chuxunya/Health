package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.FindHistoryInquiryRecordAdapter;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.contract.MyHistoryContract;
import com.wd.health.presenter.MyHistoryPresenter;

import java.util.List;

/**
 *@describe(描述)：MyHistoryActivity
 *@data（日期）: 2019/12/28
 *@time（时间）: 9:58
 *@author（作者）: 张安恒 历史记录
 **/
public class MyHistoryActivity extends BaseActivity<MyHistoryPresenter> implements MyHistoryContract.Iview {

    private ImageView back_history;
    private RecyclerView history_recy;

    @Override
    protected MyHistoryPresenter providePresenter() {
        return new MyHistoryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_history;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.MyHistory("1","5");
        //返回
        back_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        super.initView();
        back_history = findViewById(R.id.back_history);
        history_recy = findViewById(R.id.history_recy);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        history_recy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void myhistory(FindHistoryBean findHistoryBean) {
        Log.i( "xrefindstory", "myhistory: "+findHistoryBean.getMessage());
        List<FindHistoryBean.ResultBean> result = findHistoryBean.getResult();

        FindHistoryInquiryRecordAdapter findHistoryInquiryRecordAdapter = new FindHistoryInquiryRecordAdapter(result,this);
        history_recy.setAdapter(findHistoryInquiryRecordAdapter);
        //用户评论问诊服务
        findHistoryInquiryRecordAdapter.onItemClickListener(new FindHistoryInquiryRecordAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MyHistoryActivity.this,EvaluationInquiryMainActivity.class);
                intent.putExtra("recordId",result.get(position).getRecordId());
                intent.putExtra("doctorId",result.get(position).getDoctorId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {

    }

    @Override
    public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {

    }

    @Override
    public void overinquiry(EndInquiryBean endInquiryBean) {

    }
}
