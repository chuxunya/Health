package com.wd.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.activity.FavoriteMainActivity;
import com.wd.health.activity.FindDoctorActivity;
import com.wd.health.activity.MyBuyVideoActivity;

/**
 *@describe(描述)：myheart  我的关注
 *@data（日期）: 2019/12/23
 *@time（时间）: 15:57
 *@author（作者）: 张安恒
 **/
public class MyhearthMainActivity extends BaseActivity {


    private ImageView attention,favorite,myvideo;

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
        favorite = findViewById(R.id.favorite);
        myvideo = findViewById(R.id.myvideo);
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
        //我的收藏
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyhearthMainActivity.this, FavoriteMainActivity.class));
            }
        });
        //我购买的视频
        myvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyhearthMainActivity.this, MyBuyVideoActivity.class));
            }
        });
    }
}
