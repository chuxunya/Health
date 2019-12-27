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

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.MySickCircleListAdapter;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.contract.MySickContract;
import com.wd.health.presenter.MySickPresenter;

import java.util.List;

/**
 *@describe(描述)：MySickActivity
 *@data（日期）: 2019/12/27
 *@time（时间）: 10:23
 *@author（作者）: 张安恒  我的病友圈
 **/
public class MySickActivity extends BaseActivity<MySickPresenter> implements MySickContract.Iview {


    private RecyclerView mysickcircle_rlv;
    private ImageView message_fanhui;
    private RelativeLayout messageIncludeRelat;

    @Override
    protected MySickPresenter providePresenter() {
        return new MySickPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_sick;
    }

    @Override
    protected void initView() {
        super.initView();
        message_fanhui = findViewById(R.id.message_fanhui);
        mysickcircle_rlv = findViewById(R.id.mysickcircle_rlv);
        messageIncludeRelat = findViewById(R.id.message_include_relat);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mysickcircle_rlv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.MySick("1","5");
    }

    //我的病友圈
    @Override
    public void mysick(MySickCircleListBean mySickCircleListBean) {
        List<MySickCircleListBean.ResultBean> result = mySickCircleListBean.getResult();
        int size = result.size();
        if (result.size()>0){
            //适配器
            MySickCircleListAdapter mySickCircleListAdapter = new MySickCircleListAdapter(result, this);
            mysickcircle_rlv.setAdapter(mySickCircleListAdapter);
            mySickCircleListAdapter.setItemOnClick(new MySickCircleListAdapter.ItemOnClick() {
                @Override
                public void onitem(String id) {
                    Intent intent = new Intent(MySickActivity.this,MySickCircleCommentActivity.class);
                    //intent.putExtra("sickCircleId",id);
                    intent.putExtra("sickCircleId",id);
                    Log.i("sssss555", "onitem: "+id);
                    startActivity(intent);
                }
            });
        }else {
            messageIncludeRelat.setVisibility(View.VISIBLE);
            mysickcircle_rlv.setVisibility(View.GONE);
        }
    }

    @Override
    public void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean) {

    }
}
