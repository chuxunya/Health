package com.wd.chat.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.wd.chat.R;
import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.DoctorInfoBean;
import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.contract.Contract;
import com.wd.chat.presenter.InquiryPresenter;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：医生详情
 * @data（日期）: 2019/12/17
 * @time（时间）: 19:53
 * @author（作者）: xin
 **/
public class PersonalActivity extends BaseActivity<InquiryPresenter> implements Contract.IView {

    private static final String TAG = "PersonalActivity";
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.head_img)
    ImageView headImg;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.work)
    TextView work;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.good)
    TextView good;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.gift)
    TextView gift;
    @BindView(R.id.recrivegift)
    TextView recrivegift;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.like)
    ImageView like;
    @BindView(R.id.jieshao)
    TextView jieshao;
    @BindView(R.id.scaddress)
    TextView scaddress;
    @BindView(R.id.commit_count)
    TextView commitCount;
    @BindView(R.id.recy_commit)
    RecyclerView recyCommit;
    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.go_now)
    Button goNow;

    private int doctorId;

    @Override
    protected InquiryPresenter providePresenter() {
        return new InquiryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        doctorId = intent.getIntExtra("doctorId", 0);
        mPresenter.InfoP(0, null, doctorId);
    }

    @Override
    public void onDepartmentSuccess(FindDepartmentBean findDepartmentBean) {

    }

    @Override
    public void onDepartmentFailure(Throwable e) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean doctorBean) {

    }

    @Override
    public void onDoctorFailure(Throwable e) {

    }

    @Override
    public void onInfoSuccess(DoctorInfoBean doctorInfoBean) {
        Log.d(TAG, "onInfoSuccess: " + doctorInfoBean);
        if (doctorInfoBean.getStatus().equals("0000")) {
            DoctorInfoBean.ResultBean result = doctorInfoBean.getResult();
            if (result != null) {
                price.setText(result.getServicePrice() + "H币/次");
                Glide.with(this).load(result.getImagePic()).into(headImg);
                name.setText(result.getDoctorName());
                work.setText(result.getJobTitle());
                address.setText(result.getInauguralHospital());
                good.setText("好评率 " + result.getPraise());
                number.setText("服务患者数 " + result.getPraiseNum());
                List<DoctorInfoBean.ResultBean.DoctorReceiveGiftListBean> list = result.getDoctorReceiveGiftList();
                if (!list.isEmpty()) {
                    recrivegift.setVisibility(View.GONE);
                    recy.setVisibility(View.VISIBLE);



                } else {
                    recrivegift.setVisibility(View.VISIBLE);
                    recy.setVisibility(View.GONE);
                }


            } else {
                Toast.makeText(this, doctorInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, doctorInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInfoFailure(Throwable e) {
        Log.d(TAG, "onInfoFailure: " + e.getMessage().toString());
    }
}
