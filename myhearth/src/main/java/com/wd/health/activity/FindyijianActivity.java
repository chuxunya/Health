package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.adapter.Findjianyi_Adapter;
import com.wd.health.bean.FindMyAdoptedCommentListBean;
import com.wd.health.contract.FindyijianContract;
import com.wd.health.presenter.FindyijianPresenter;

import java.util.List;
/**
 *@describe(描述)：FindyijianActivity   查询我的意见
 *@data（日期）: 2019/12/25
 *@time（时间）: 10:34
 *@author（作者）: 张安恒
 **/
public class FindyijianActivity extends BaseActivity<FindyijianPresenter> implements FindyijianContract.Iview {

    private RelativeLayout yijiankong;
    private RecyclerView comment_list_recy;
    private List<?> result;
    @Override
    protected FindyijianPresenter providePresenter() {
        return new FindyijianPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_findyijian;
    }

    @Override
    protected void initView() {
        super.initView();
        yijiankong = (RelativeLayout) findViewById(R.id.yijiankong);
        comment_list_recy = (RecyclerView) findViewById(R.id.comment_list_recy);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        comment_list_recy.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.Findyijian("1","5");
    }

    @Override
    public void findyijian(FindMyAdoptedCommentListBean findMyAdoptedCommentListBean) {
        Log.i("xxxyijian", "findyijian: "+findMyAdoptedCommentListBean.getMessage());
        List<?> result = findMyAdoptedCommentListBean.getResult();
        int size = result.size();
        Log.e("size", "FindMyAdoptedCommentListSuccess: "+size);
        if (size>0){
            Findjianyi_Adapter findjianyi_adapter=new Findjianyi_Adapter(result,this);
            comment_list_recy.setAdapter(findjianyi_adapter);
        }else {
            yijiankong.setVisibility(View.VISIBLE);
        }
    }
}
