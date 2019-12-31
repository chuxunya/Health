package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.MySickCircleCommentListAdapter;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.contract.MySickContract;
import com.wd.health.presenter.MySickPresenter;

public class MySickCircleCommentActivity extends BaseActivity<MySickPresenter> implements MySickContract.Iview {


    private ImageView message_fanhui;
    private RecyclerView mysickcircle_rlv;
    private RelativeLayout messageIncludeRelat;
    private TextView message_include_text;

    @Override
    protected MySickPresenter providePresenter() {
        return new MySickPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_sick_circle_comment;
    }

    @Override
    protected void initView() {
        super.initView();
        message_fanhui = findViewById(R.id.message_fanhui);
        mysickcircle_rlv = findViewById(R.id.mysickcircle_rlv);
        messageIncludeRelat = findViewById(R.id.message_include_relat);
        message_include_text = findViewById(R.id.message_include_text);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mysickcircle_rlv.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        //int sickCircleId = intent.getIntExtra("sickCircleId", 0);
        String sickCircleId = intent.getStringExtra("sickCircleId");
        Log.i("ppppppp", "initData:"+sickCircleId);
        mPresenter.MySickCircleCommentList("5","1","5");
    }

    @Override
    public void mysick(MySickCircleListBean mySickCircleListBean) {

    }

    @Override
    public void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean) {
        Log.i("xasmySickCircle", "mySickCircleCommentList: "+mySickCircleCommentListBean.getMessage());
        MySickCircleCommentListBean.ResultBean result = mySickCircleCommentListBean.getResult();
        if (result.getOtherSickCircleCommentList().size()>0){
            MySickCircleCommentListAdapter mySickCircleCommentListAdapter = new MySickCircleCommentListAdapter(result,this);
            mysickcircle_rlv.setAdapter(mySickCircleCommentListAdapter);
        }else {
            messageIncludeRelat.setVisibility(View.VISIBLE);
            mysickcircle_rlv.setVisibility(View.GONE);
            message_include_text.setText("暂无评论");
        }
     }
}
