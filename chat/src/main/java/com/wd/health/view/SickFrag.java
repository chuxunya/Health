package com.wd.health.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.wd.health.R;
import com.wd.health.R2;
import com.wd.health.bean.ConsultBean;
import com.wd.health.bean.ConsultDoctorBean;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.EndBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;
import com.wd.health.contract.Contract;
import com.wd.health.presenter.InquiryPresenter;
import com.wd.health.utils.MyAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @describe(描述)：SickFrag
 * @data（日期）: 2019/12/16
 * @time（时间）: 8:52
 * @author（作者）: xin
 **/
public class SickFrag extends BaseFragment<InquiryPresenter> implements Contract.IView {
    private static final String TAG = "SickFrag";
    @BindView(R2.id.tablayout)
    TabLayout tablayout;
    @BindView(R2.id.img)
    ImageView img;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.work)
    TextView work;
    @BindView(R2.id.address)
    TextView address;
    @BindView(R2.id.good)
    TextView good;
    @BindView(R2.id.number)
    TextView number;
    @BindView(R2.id.more)
    ImageView more;
    @BindView(R2.id.money)
    TextView money;
    @BindView(R2.id.btn_go)
    Button btnGo;
    @BindView(R2.id.up)
    ImageView up;
    @BindView(R2.id.recy)
    RecyclerView recy;
    @BindView(R2.id.next)
    ImageView next;
    @BindView(R2.id.page)
    TextView page1;

    private int departmentId;
    private int position;
    int page = 1;
    private int doctorId;

    @Override
    protected InquiryPresenter providePresenter() {
        return new InquiryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.sick_frag;
    }

    @Override
    protected void initView() {
        super.initView();

        tablayout.addTab(tablayout.newTab().setText("综合"));
        tablayout.addTab(tablayout.newTab().setText("好评"));
        tablayout.addTab(tablayout.newTab().setText("咨询数"));
        tablayout.addTab(tablayout.newTab().setText("价格"));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (position==0){
                    mPresenter.DoctorP(departmentId, 1, 0, page, 3);
                }
                if (position==1){
                    mPresenter.DoctorP(departmentId, 2, 0, page, 3);
                }
                if (position==2){
                    mPresenter.DoctorP(departmentId, 3, 0, page, 3);
                }
                if (position==3){
                    mPresenter.DoctorP(departmentId, 4, 0, page, 3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        Bundle arguments = getArguments();
        departmentId = arguments.getInt("departmentId");
        mPresenter.DoctorP(departmentId, 1, 0, page, 3);


    }

    @Override
    public void onDepartmentSuccess(FindDepartmentBean findDepartmentBean) {

    }

    @Override
    public void onDepartmentFailure(Throwable e) {

    }

    @Override
    public void onDoctorSuccess(DoctorBean doctorBean) {
        Log.d(TAG, "onDoctorSuccess: " + doctorBean);
        if (doctorBean.getStatus().equals("0000")) {
            final List<DoctorBean.ResultBean> result = doctorBean.getResult();
            if (!result.isEmpty()) {
                doctorId = result.get(0).getDoctorId();
                Glide.with(getContext()).load(result.get(0).getImagePic()).into(img);
                name.setText(result.get(0).getDoctorName() + "");
                address.setText(result.get(0).getInauguralHospital());
                good.setText("好评率 " + result.get(0).getPraise());
                number.setText("服务患者数 " + result.get(0).getPraiseNum());
                money.setText(result.get(0).getServicePrice() + "H币/次");
                page1.setText("" + page);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recy.setLayoutManager(linearLayoutManager);
                MyAdapter myAdapter = new MyAdapter(result, getActivity());
                recy.setAdapter(myAdapter);
                if (page <= 1) {
                    up.setVisibility(View.GONE);
                } else {
                    up.setVisibility(View.VISIBLE);
                }
                if (result.size() <= 2) {
                    next.setVisibility(View.GONE);
                } else {
                    next.setVisibility(View.VISIBLE);
                }

                myAdapter.setOnCLickListener(new MyAdapter.OnCLickListener() {
                    @Override
                    public void onclick(int position) {
                        doctorId = result.get(position).getDoctorId();
                        Glide.with(getContext()).load(result.get(position).getImagePic()).into(img);
                        name.setText(result.get(position).getDoctorName() + "");
                        address.setText(result.get(position).getInauguralHospital());
                        good.setText("好评率 " + result.get(position).getPraise());
                        number.setText("服务患者数 " + result.get(position).getPraiseNum());
                        money.setText(result.get(position).getServicePrice() + "H币/次");
                    }
                });

            } else {
                Toast.makeText(getActivity(), "暂无更多数据", Toast.LENGTH_SHORT).show();
                next.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(getActivity(), doctorBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDoctorFailure(Throwable e) {
        Log.d(TAG, "onDoctorFailure: " + e.getMessage());
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

    @Override
    public void onConsultDoctorSuccess(ConsultBean bean) {

    }

    @Override
    public void onConsultDoctorFailure(Throwable e) {

    }

    @Override
    public void onEndDoctorSuccess(EndBean bean) {

    }

    @Override
    public void onEndDoctorFailure(Throwable e) {

    }

    @OnClick({R2.id.up, R2.id.next, R2.id.more})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.up) {
            page = page - 1;
            if (position == 0) {
                mPresenter.DoctorP(departmentId, 1, 0, page, 3);
            }
            if (position == 1) {
                mPresenter.DoctorP(departmentId, 2, 0, page, 3);
            }
            if (position == 2) {
                mPresenter.DoctorP(departmentId, 3, 0, page, 3);
            }
            if (position == 3) {
                mPresenter.DoctorP(departmentId, 4, 0, page, 3);
            }
            page1.setText("" + page);
        } else if (id == R.id.next) {
            page++;
            if (position == 0) {
                mPresenter.DoctorP(departmentId, 1, 0, page, 3);
            }
            if (position == 1) {
                mPresenter.DoctorP(departmentId, 2, 0, page, 3);
            }
            if (position == 2) {
                mPresenter.DoctorP(departmentId, 3, 0, page, 3);
            }
            if (position == 3) {
                mPresenter.DoctorP(departmentId, 4, 0, page, 3);
            }
            page1.setText("" + page);
        } else if (id == R.id.more) {
            Intent intent = new Intent(getActivity(), PersonalActivity.class);
            intent.putExtra("doctorId", doctorId);
            startActivity(intent);
        }
    }

}
