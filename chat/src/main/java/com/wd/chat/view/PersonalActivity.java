package com.wd.chat.view;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.wd.chat.bean.LikeBean;
import com.wd.chat.bean.MyMoneyBean;
import com.wd.chat.bean.NoLikeBean;
import com.wd.chat.bean.NowIMS;
import com.wd.chat.contract.Contract;
import com.wd.chat.presenter.InquiryPresenter;
import com.wd.chat.utils.CommentAdapter;
import com.wd.chat.utils.MyGiftAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.nolike)
    ImageView nolike;

    private int doctorId;
    private int userId;
    private String sesssionId;

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
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        userId = user.getInt("userId", 0);
        sesssionId = user.getString("sesssionId", "");
        if (userId != 0 && !sesssionId.isEmpty()) {
            mPresenter.InfoP(userId, sesssionId, doctorId);
        } else {
            mPresenter.InfoP(0, null, doctorId);
        }
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
                int followFlag = result.getFollowFlag();
                if (followFlag == 1) {
                    nolike.setVisibility(View.GONE);
                    like.setVisibility(View.VISIBLE);
                }
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
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PersonalActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                    recy.setLayoutManager(linearLayoutManager);
                    MyGiftAdapter myGiftAdapter = new MyGiftAdapter(list, PersonalActivity.this);
                    recy.setAdapter(myGiftAdapter);
                } else {
                    recrivegift.setVisibility(View.VISIBLE);
                    recy.setVisibility(View.GONE);
                }
                jieshao.setText(result.getPersonalProfile());
                scaddress.setText(result.getGoodField());
                commitCount.setText("(" + result.getCommentNum() + "条评论)");
                if (result.getCommentNum() != 0) {
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PersonalActivity.this);
                    linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyCommit.setLayoutManager(linearLayoutManager);
                    List<DoctorInfoBean.ResultBean.CommentListBean> commentList = result.getCommentList();
                    CommentAdapter commentAdapter = new CommentAdapter(commentList, PersonalActivity.this);
                    recyCommit.setAdapter(commentAdapter);
                    if (commentList.size() == 3 && result.getCommentNum() > 3) {
                        more.setVisibility(View.VISIBLE);
                        more.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(PersonalActivity.this, CommentActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
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

    @Override
    public void onfollowSuccess(LikeBean likeBean) {
        Log.d(TAG, "onfollowSuccess: " + likeBean);
        if (likeBean.getStatus().equals("0000")) {
            nolike.setVisibility(View.GONE);
            like.setVisibility(View.VISIBLE);
            Toast.makeText(this, likeBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onfollowFailure(Throwable e) {
        Log.d(TAG, "onfollowFailure: " + e.getMessage());
    }

    @Override
    public void oncancelSuccess(NoLikeBean noLikeBean) {
        Log.d(TAG, "oncancelSuccess: " + noLikeBean);
        if (noLikeBean.getStatus().equals("0000")) {
            nolike.setVisibility(View.VISIBLE);
            like.setVisibility(View.GONE);
            Toast.makeText(this, noLikeBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void oncancelFailure(Throwable e) {
        Log.d(TAG, "oncancelFailure: " + e.getMessage());
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

    @OnClick({R.id.back, R.id.nolike, R.id.like, R.id.go_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.nolike:
                if (userId != 0 && !sesssionId.isEmpty()) {
                    mPresenter.followP(userId, sesssionId, doctorId);
                } else {
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.like:
                if (userId != 0 && !sesssionId.isEmpty()) {
                    mPresenter.canceP(userId, sesssionId, doctorId);
                }
                break;
            case R.id.go_now:

                break;
        }
    }
}
