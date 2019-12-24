package com.wd.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.activity.FindDoctorActivity;

/**
 *@describe(描述)：myheart  我的关注
 *@data（日期）: 2019/12/23
 *@time（时间）: 15:57
 *@author（作者）: 张安恒
 **/
public class MyhearthMainActivity extends BaseActivity {


    private ImageView attention;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.myhearth_main;
    }

    @Override
    protected void initView() {
        super.initView();
        attention = findViewById(R.id.attention);
    }

    @Override
    protected void initData() {
        super.initData();
        //我的关注
        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyhearthMainActivity.this, FindDoctorActivity.class));
            }
        });
    }
}
