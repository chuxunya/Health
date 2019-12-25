package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.MyVideoAdapter;
import com.wd.health.adapter.VideoVoListAdapter;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.MydeleVideoBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.contract.MyBuyVideoContract;
import com.wd.health.presenter.MyBuyVideoPresenter;

import java.util.List;

/**
 *@describe(描述)：MyBuyVideoActivity  我购买的视频
 *@data（日期）: 2019/12/24
 *@time（时间）: 15:39
 *@author（作者）: 张安恒
 **/
public class MyBuyVideoActivity extends BaseActivity<MyBuyVideoPresenter> implements MyBuyVideoContract.Iview {

    private int userId;
    private String sessionId;
    private RelativeLayout videokong;
    private RecyclerView myvideo_recy;
    private List<MyBuyVideoBean.ResultBean> result;

    @Override
    protected MyBuyVideoPresenter providePresenter() {
        return new MyBuyVideoPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_my_buy_video;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.MyBuyVideo("1", "5");
    }

    @Override
    protected void initView() {
        super.initView();
        videokong = findViewById(R.id.videokong);
        myvideo_recy = findViewById(R.id.myvideo_recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myvideo_recy.setLayoutManager(linearLayoutManager);
    }

    //购买视频
    @Override
    public void mybuyvideo(MyBuyVideoBean myBuyVideoBean) {
        Log.i("xmyBuyVideoBean", "mybuyvideo: " + myBuyVideoBean.getMessage());
        result = myBuyVideoBean.getResult();
        if (myBuyVideoBean.getResult().size() > 0) {
            MyVideoAdapter myVideoAdapter = new MyVideoAdapter(result, this);
            myvideo_recy.setAdapter(myVideoAdapter);

            //删除视频
            myVideoAdapter.onItemClickListener(new MyVideoAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    int videoId = result.get(position).getVideoId();
                    mPresenter.MyDeleVideo(videoId + "");
                }
            });
        } else {
            videokong.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void mydeletevideo(MydeleVideoBean mydeleVideoBean) {
        if (mydeleVideoBean.getStatus().equals("0000")) {
            Toast.makeText(this, mydeleVideoBean.getMessage(), Toast.LENGTH_SHORT).show();
            mPresenter.MyBuyVideo("1", "5");
        } else {
            Toast.makeText(this, mydeleVideoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

