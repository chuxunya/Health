package com.wd.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.activity.FavoriteMainActivity;
import com.wd.health.activity.FindDoctorActivity;
import com.wd.health.activity.FindyijianActivity;
import com.wd.health.activity.MyBuyVideoActivity;
import com.wd.health.activity.MywalletActivity;
import com.wd.health.bean.AddSignBean;
import com.wd.health.contract.MyHertContract;
import com.wd.health.presenter.MyHertPresenter;

/**
 *@describe(描述)：myheart  我的关注
 *@data（日期）: 2019/12/23
 *@time（时间）: 15:57
 *@author（作者）: 张安恒
 **/
public class MyhearthMainActivity extends BaseActivity<MyHertPresenter> implements MyHertContract.Iview {


    private ImageView attention,favorite,myvideo,my_money,yijian;
    private Button mine_activity_btn_sign_in;


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
        my_money = findViewById(R.id.my_money);
        mine_activity_btn_sign_in = findViewById(R.id.mine_activity_btn_sign_in);
        yijian = findViewById(R.id.yijian);
    }

    @Override
    protected MyHertPresenter providePresenter() {
        return new MyHertPresenter();
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
        //我的钱包
        my_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyhearthMainActivity.this, MywalletActivity.class));
            }
        });
        //查询我的被采纳的建议
        yijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyhearthMainActivity.this, FindyijianActivity.class));
            }
        });
        //签到
        mine_activity_btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //做签到任务
              mPresenter.Addsign();
            }
        });
    }

    @Override
    public void addsign(AddSignBean addSignBean) {

    }
}
