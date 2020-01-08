package com.wd.health.view;

import android.app.AlertDialog;
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

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.wd.health.JgActivity;
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
import com.wd.health.utils.CommentAdapter;
import com.wd.health.utils.MyGiftAdapter;

import java.util.List;

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
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.rela)
    RelativeLayout rela;
    @BindView(R2.id.head_img)
    ImageView headImg;
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
    @BindView(R2.id.gift)
    TextView gift;
    @BindView(R2.id.recrivegift)
    TextView recrivegift;
    @BindView(R2.id.recy)
    RecyclerView recy;
    @BindView(R2.id.like)
    ImageView like;
    @BindView(R2.id.jieshao)
    TextView jieshao;
    @BindView(R2.id.scaddress)
    TextView scaddress;
    @BindView(R2.id.commit_count)
    TextView commitCount;
    @BindView(R2.id.recy_commit)
    RecyclerView recyCommit;
    @BindView(R2.id.more)
    TextView more;
    @BindView(R2.id.price)
    TextView price;
    @BindView(R2.id.go_now)
    Button goNow;
    @BindView(R2.id.nolike)
    ImageView nolike;


    private int doctorId;
    private int userId;
    private String sesssionId;
    private int servicePrice;
    private DoctorInfoBean.ResultBean result;

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
            result = doctorInfoBean.getResult();
            if (result != null) {
                int followFlag = result.getFollowFlag();
                if (followFlag == 1) {
                    nolike.setVisibility(View.GONE);
                    like.setVisibility(View.VISIBLE);
                }
                servicePrice = result.getServicePrice();
                price.setText(servicePrice + "H币/次");
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
        Log.d(TAG, "onNowSuccess: " + nowIMS);
        if (nowIMS != null) {
            if (nowIMS.getMessage().equals("当前无问诊")) {
                mPresenter.MoneyP(userId, sesssionId);
            } else {
                //弹框提示您尚有咨询在进行中  去结束/取消
            if (nowIMS.getMessage().equals("当前无问诊")) {

            }else {
                View inflate = View.inflate(PersonalActivity.this, R.layout.alertdialoglayout, null);
                TextView textView = inflate.findViewById(R.id.text_data);
                textView.setText("您尚有咨询在进行中请先关闭在开始新的咨询");
                Button button1=inflate.findViewById(R.id.button_qd);
                Button button2=inflate.findViewById(R.id.button_qx);
                button1.setText("去结束");
                button2.setText("取消");
                AlertDialog alertDialog = new AlertDialog.Builder(PersonalActivity.this)
                        .setView(inflate)
                        .create();
                alertDialog.show();
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.EndDoctorData(userId+"",sesssionId,nowIMS.getResult().getRecordId());
                        alertDialog.cancel();
                    }
                });
            }
            }
        } else {
            Toast.makeText(this, nowIMS.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNowFailure(Throwable e) {
        Log.d(TAG, "onNowFailure: " + e.getMessage());
    }

    @Override
    public void onMoneySuccess(MyMoneyBean myMoneyBean) {
        Log.d(TAG, "onMoneySuccess: " + myMoneyBean);
        if (myMoneyBean != null) {
            int result = myMoneyBean.getResult();
            if (result > servicePrice) {
                View inflate = View.inflate(PersonalActivity.this, R.layout.alertdialoglayout, null);
                TextView textView = inflate.findViewById(R.id.text_data);
                textView.setText("本次咨询将扣除500H币");
                Button button1=inflate.findViewById(R.id.button_qd);
                Button button2=inflate.findViewById(R.id.button_qx);
                button1.setText("去咨询");
                button2.setText("取消");
                AlertDialog alertDialog = new AlertDialog.Builder(PersonalActivity.this)
                        .setView(inflate)
                        .create();
                alertDialog.show();
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
                //提示扣除H币 取消/去咨询
                //跳转到聊天页面
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.ConsultDoctorP(userId+"",sesssionId,doctorId);
                        alertDialog.cancel();
                    }
                });

            } else {
                //弹框提示H币不足 去充值/取消
                View inflate = View.inflate(PersonalActivity.this, R.layout.alertdialoglayout, null);
                TextView textView = inflate.findViewById(R.id.text_data);
                textView.setText("H币补足500,充值再来吧!");
                Button button1=inflate.findViewById(R.id.button_qd);
                Button button2=inflate.findViewById(R.id.button_qx);
                button1.setText("去充值");
                button2.setText("取消");
                AlertDialog alertDialog = new AlertDialog.Builder(PersonalActivity.this)
                        .setView(inflate)
                        .create();
                alertDialog.show();
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
            }
        } else {
            Toast.makeText(this, myMoneyBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMoneyFailure(Throwable e) {
        Log.d(TAG, "onMoneyFailure: " + e.getMessage());
    }

    @Override
    public void onConsultDoctorSuccess(ConsultBean bean) {
        Log.d("aaa", "onConsultDoctorSuccess: "+bean.toString());
        if (bean.getStatus().equals("0000")){
            Intent intent = new Intent(PersonalActivity.this,JgActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onConsultDoctorFailure(Throwable e) {

    }

    @Override
    public void onEndDoctorSuccess(EndBean bean) {
        Log.d(TAG, "onEndDoctorSuccess: "+bean.toString());
        Toast.makeText(this,bean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEndDoctorFailure(Throwable e) {

    }


    @OnClick({R2.id.back, R2.id.nolike, R2.id.like, R2.id.go_now})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.nolike) {
            if (userId != 0 && !sesssionId.isEmpty()) {
                mPresenter.followP(userId, sesssionId, doctorId);
            } else {
                Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.like) {
            if (userId != 0 && !sesssionId.isEmpty()) {
                mPresenter.canceP(userId, sesssionId, doctorId);
            }
        } else if (id == R.id.go_now) {
            mPresenter.NowP(userId, sesssionId);
        }
    }

}
