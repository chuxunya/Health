package com.wd.health.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.health.R;

import com.wd.health.adapter.FindUserDoctorFollowListAdapter;
import com.wd.health.bean.ConsultationBean;
import com.wd.health.bean.FindDoctorBean;
import com.wd.health.contract.FindDoctorContract;
import com.wd.health.presenter.FindDoctorPresenter;

import java.util.List;
/**
 *@describe(描述)：FindDoctorActivity  关查看注医生
 *@data（日期）: 2019/12/24
 *@time（时间）: 8:32
 *@author（作者）: 张安恒
 **/
public class FindDoctorActivity extends BaseActivity<FindDoctorPresenter> implements FindDoctorContract.Iview {

    private XRecyclerView attention_recy;
    private RelativeLayout guanzhukong;
    private FindUserDoctorFollowListAdapter findUserDoctorFollowListAdapter;
    private  int a=1;
    @Override
    protected FindDoctorPresenter providePresenter() {
        return new FindDoctorPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_find_doctor;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.FindDoctor("1","5");
        attention_recy = findViewById(R.id.attention_recy);
        guanzhukong = (RelativeLayout) findViewById(R.id.guanzhukong);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        attention_recy.setLayoutManager(linearLayoutManager);

        attention_recy.setLoadingMoreEnabled(true);
        attention_recy.setPullRefreshEnabled(true);
        attention_recy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                 a=1;
                mPresenter.FindDoctor(a+"","7");
                attention_recy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                a++;
                mPresenter.FindDoctor(a+"","7");
                 attention_recy.loadMoreComplete();
            }
        });
    }


    @Override
    public void finddoctor(FindDoctorBean findDoctorBean) {
        Log.i("FindDoctorBean", "finddoctor: "+findDoctorBean.getMessage());
        List<FindDoctorBean.ResultBean> result = findDoctorBean.getResult();
        int size = result.size();
        if (result.size()>0){
            findUserDoctorFollowListAdapter = new FindUserDoctorFollowListAdapter(result,this);
            attention_recy.setAdapter(findUserDoctorFollowListAdapter);

            //滑动取消关注
           findUserDoctorFollowListAdapter.setSetDeleteListen(new FindUserDoctorFollowListAdapter.setDeleteListen() {
               @Override
               public void setdelete(int id) {
                   Log.i("zzsetdelete", "setdelete: "+id);
                   mPresenter.QuxiaoDoctor(id+"");
                   findUserDoctorFollowListAdapter.notifyDataSetChanged();
               }
           });
        }else {
            guanzhukong.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void quxiaodoctor(ConsultationBean consultationBean) {
        Log.i("consultationBean", "quxiaodoctor: "+consultationBean.getMessage());
        if (consultationBean.getStatus().equals("0000")){
            Toast.makeText(this, consultationBean.getMessage(), Toast.LENGTH_SHORT).show();
            //滑动取消关注
            mPresenter.FindDoctor("1","5");
        }else {
            Toast.makeText(this, consultationBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onFraily(String e) {

    }
}
