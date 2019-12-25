package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.RecyclerUserCRAdapter;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.contract.MyWalletContract;
import com.wd.health.presenter.MyWalletPresenter;

import java.util.List;
/**
 *@describe(描述)：MywalletActivity 我的钱包
 *@data（日期）: 2019/12/24
 *@time（时间）: 20:33
 *@author（作者）: 张安恒
 **/
public class MywalletActivity extends BaseActivity<MyWalletPresenter> implements MyWalletContract.Iview {

    private TextView hbi;
    private RecyclerView mywallet_recycler;
    private List<FindUserCRBean.ResultBean> userCRResult;
    private RecyclerUserCRAdapter recyclerUserCRAdapter;

    @Override
    protected MyWalletPresenter providePresenter() {
        return new MyWalletPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_mywallet;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.MyWallet();
        mPresenter.FindUserRC("1","5");
    }

    @Override
    protected void initView() {
        super.initView();
        hbi = findViewById(R.id.hbi);
        mywallet_recycler = findViewById(R.id.mywallet_recycler);
    }

    //查询用户余额
    @Override
    public void mywallet(MyWalletBean myWalletBean) {
        Log.i("xmyWalletBean", "mywallet: " + myWalletBean.getMessage());
        if (myWalletBean.getStatus().equals("0000")) {
            Toast.makeText(this, myWalletBean.getMessage(), Toast.LENGTH_SHORT).show();
            hbi.setText(myWalletBean.getResult() + "");
        } else {
            Toast.makeText(this, myWalletBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //查询用户消费记录
    @Override
    public void findusercr(FindUserCRBean findUserCRBean) {
        if (findUserCRBean.getStatus().equals("0000")) {
            userCRResult = findUserCRBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerUserCRAdapter = new RecyclerUserCRAdapter(this);
            recyclerUserCRAdapter.addData(userCRResult);
            mywallet_recycler.setLayoutManager(linearLayoutManager);
            mywallet_recycler.setAdapter(recyclerUserCRAdapter);
        } else {
            Toast.makeText(this, findUserCRBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
