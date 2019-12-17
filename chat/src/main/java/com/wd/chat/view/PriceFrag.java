package com.wd.chat.view;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.wd.chat.R;
import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.contract.Contract;
import com.wd.chat.presenter.InquiryPresenter;
import com.wd.chat.utils.MyAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * @describe(描述)：PriceFrag
 * @data（日期）: 2019/12/16
 * @time（时间）: 10:48
 * @author（作者）: xin
 **/
public class PriceFrag extends BaseFragment<InquiryPresenter> implements Contract.IView {

    @BindView(R.id.img)
    ImageView img;
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
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.btn_go)
    Button btnGo;
    @BindView(R.id.up)
    ImageView up;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.next)
    ImageView next;
    int page = 1;
    @BindView(R.id.page)
    TextView page1;
    private int deptId;

    @Override
    protected InquiryPresenter providePresenter() {
        return new InquiryPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_price;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences sp = getActivity().getSharedPreferences("departmentId", Context.MODE_PRIVATE);
        deptId = sp.getInt("id", 0);
        mPresenter.DoctorP(deptId, 4, 0, page, 4);
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
        Log.d(TAG, "onDoctorSuccess: " + doctorBean);
        if (doctorBean.getStatus().equals("0000")) {
            List<DoctorBean.ResultBean> result = doctorBean.getResult();
            if (!result.isEmpty()) {
                Glide.with(getContext()).load(result.get(0).getImagePic()).into(img);
                name.setText(result.get(0).getDoctorName() + "");
                address.setText(result.get(0).getInauguralHospital());
                good.setText("好评率 " + result.get(0).getPraise());
                number.setText("服务患者数 " + result.get(0).getPraiseNum());
                money.setText(result.get(0).getServicePrice() + "H币/次");
                page1.setText(""+page);
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
                if (result.size() <= 3) {
                    next.setVisibility(View.GONE);
                } else {
                    next.setVisibility(View.VISIBLE);
                }
                myAdapter.setOnCLickListener(new MyAdapter.OnCLickListener() {
                    @Override
                    public void onclick(int position) {
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

    @OnClick({R.id.up, R.id.next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.up:
                page = page - 1;
                mPresenter.DoctorP(deptId, 4, 0, page, 4);
                page1.setText(""+page);
                break;
            case R.id.next:
                page++;
                mPresenter.DoctorP(deptId, 4, 0, page, 4);
                page1.setText(""+page);
                break;
        }
    }
}
