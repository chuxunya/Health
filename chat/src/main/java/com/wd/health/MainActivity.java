package com.wd.health;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.InquiryPresenter;
import com.wd.health.utils.MySickAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * @describe(描述)：MainActivity
 * @data（日期）: 2019/12/14
 * @time（时间）: 9:39
 * @author（作者）: xin
 **/
@Route(path = "/chat/MainActivity")
public class MainActivity extends BaseActivity<InquiryPresenter> implements Contract.IView {
    @Autowired(name = "id")
    public int id;
    private static final String TAG = "MainActivity";
    @BindView(R.id.head)
    ImageView head;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<String> list=new ArrayList<>();
    String sesssionId = "1576720687367475";
    int userId = 475;
    private SharedPreferences.Editor edit;
    private SharedPreferences sp;

    @Override
    protected InquiryPresenter providePresenter() {
        return new InquiryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        ARouter.getInstance().inject(this);
        Log.d("测试", "initData: "+id);
        mPresenter.DepartmentP();
        sp = getSharedPreferences("user", MODE_PRIVATE);
        edit = sp.edit();
        edit.putInt("userId",userId).commit();
        edit.putString("sesssionId",sesssionId).commit();
    }

    @Override
    public void onDepartmentSuccess(FindDepartmentBean findDepartmentBean) {
        Log.d(TAG, "onDepartmentSuccess: " + findDepartmentBean);
        if (findDepartmentBean.getStatus().equals("0000")){
            List<FindDepartmentBean.ResultBean> result = findDepartmentBean.getResult();
            if (result!=null){

                for (int i = 0; i < result.size(); i++) {
                    list.add(result.get(i).getDepartmentName());
                }

                tab.setupWithViewPager(pager);
                MySickAdapter mySickAdapter = new MySickAdapter(getSupportFragmentManager(), list, result);
                pager.setAdapter(mySickAdapter);
                pager.setOffscreenPageLimit(list.size());
            }else {
                Toast.makeText(this, findDepartmentBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, findDepartmentBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onDepartmentFailure(Throwable e) {
        Log.d(TAG, "onDepartmentFailure: " + e.getMessage().toString());
    }

    @Override
    public void onDoctorSuccess(DoctorBean doctorBean) {

    }

    @Override
    public void onDoctorFailure(Throwable e) {

    }

    @Override
    public void onInfoSuccess(DoctorInfoBean doctorInfoBean) {

    }

    @Override
    public void onInfoFailure(Throwable e) {

    }

    @Override
    public void onfollowSuccess(LikeBean likeBean) {

    }

    @Override
    public void onfollowFailure(Throwable e) {

    }

    @Override
    public void oncancelSuccess(NoLikeBean noLikeBean) {

    }

    @Override
    public void oncancelFailure(Throwable e) {

    }

    @Override
    public void onNowSuccess(NowIMS nowIMS) {

    }

    @Override
    public void onNowFailure(Throwable e) {

    }

    @Override
    public void onMoneySuccess(MyMoneyBean myMoneyBean) {

    }

    @Override
    public void onMoneyFailure(Throwable e) {

    }
}
