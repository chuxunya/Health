package com.wd.home.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.app.Constant;
import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bawei.lizekai.mylibrary.utils.ToastUtils;
import com.bumptech.glide.Glide;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.home.R;
import com.wd.home.adapter.RecyclerSickCircleCommentListAdapter;
import com.wd.home.bean.CommentCircleBean;
import com.wd.home.bean.PatientDetailsBean;
import com.wd.home.bean.QueryCommentBean;
import com.wd.home.contract.SickCircleContract;
import com.wd.home.presenter.SickCirclePresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor hp
 * @time 2019/12/20 19:53
 */
public class PatientDetailsActivity extends BaseActivity<SickCirclePresenter> implements SickCircleContract.Iview {


    private ImageView patient_activity_iv_intent_release_sickCircle;
    private ImageView patient_activity_iv_cancel;
    private ImageView patient_activity_iv_content;
    private RelativeLayout patient_activity_relative_content;
    private RelativeLayout patient_activity_relative_release_sickCircle;
    private EditText patient_activity_et_content;
    private ImageView patient_activity_iv_send_content;
    private ImageView patient_activity_iv_picture;
    private TextView patient_activity_tv_title;
    private TextView patient_activity_tv_adoptNickName;
    private TextView patient_activity_tv_disease;
    private TextView patient_activity_tv_department;
    private TextView patient_activity_tv_detail;
    private TextView patient_activity_tv_treatmentProcess;
    private TextView patient_activity_tv_treatment_time;
    private TextView patient_activity_tv_commentNum;
    private TextView patient_activity_tv_collectionNum;
    private TextView nameNickName;
    private TextView textadoptComment;
   private SimpleDraweeView imgHeadPic;
   private RecyclerView recycler_sick_circle_comment_list;
    private RecyclerSickCircleCommentListAdapter recyclerSickCircleCommentListAdapter;

    @Override
    protected SickCirclePresenter providePresenter() {
        return new SickCirclePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_patient_details;
    }

    @Override
    protected void initView() {
        super.initView();
        patient_activity_iv_cancel = findViewById(R.id.patient_activity_iv_cancel);
        patient_activity_relative_content = findViewById(R.id.patient_activity_relative_content);
        patient_activity_relative_release_sickCircle = findViewById(R.id.patient_activity_relative_release_sickCircle);
        patient_activity_iv_intent_release_sickCircle = findViewById(R.id.patient_activity_iv_intent_release_sickCircle);
        patient_activity_et_content = findViewById(R.id.patient_activity_et_content);
        patient_activity_iv_send_content = findViewById(R.id.patient_activity_iv_send_content);
        patient_activity_tv_title = findViewById(R.id.patient_activity_tv_title);
        patient_activity_tv_adoptNickName = findViewById(R.id.patient_activity_tv_adoptNickName);
        patient_activity_tv_disease = findViewById(R.id.patient_activity_tv_disease);
        patient_activity_tv_department = findViewById(R.id.patient_activity_tv_department);
        patient_activity_tv_detail = findViewById(R.id.patient_activity_tv_detail);
        patient_activity_tv_treatmentProcess = findViewById(R.id.patient_activity_tv_treatmentProcess);
        patient_activity_tv_treatment_time = findViewById(R.id.patient_activity_tv_treatment_time);
        patient_activity_iv_picture = findViewById(R.id.patient_activity_iv_picture);
        patient_activity_tv_commentNum = findViewById(R.id.patient_activity_tv_commentNum);
        patient_activity_tv_collectionNum = findViewById(R.id.patient_activity_tv_collectionNum);
        imgHeadPic = findViewById(R.id.img_HeadPic);
        nameNickName = findViewById(R.id.name_NickName);
        patient_activity_iv_content = findViewById(R.id.patient_activity_iv_content);
        textadoptComment = findViewById(R.id.text_adoptComment);
        recycler_sick_circle_comment_list = findViewById(R.id.recycler_sick_circle_comment_list);

    }



    @Override
    protected void initData() {
        super.initData();

        Intent intent = getIntent();
        int sickCircleId = intent.getIntExtra("sickCircleId", 0);
        mPresenter.sickcircleinfo(sickCircleId);

        patient_activity_iv_intent_release_sickCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientDetailsActivity.this, ReleaseCirclesActivity.class);
                startActivity(intent);
            }
        });

        //关闭帖子
        patient_activity_iv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient_activity_relative_content.setVisibility(View.GONE);
                patient_activity_relative_release_sickCircle.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(patient_activity_et_content.getWindowToken(), 0);
            }
        });
        //发表评论
        patient_activity_iv_send_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = patient_activity_et_content.getText().toString().trim();
                mPresenter.publishcomment(445, "1576550914923445", sickCircleId, trim);
            }
        });
    }


    @Override
    public void sickcircleinfo(PatientDetailsBean patientDetailsBean) {
        PatientDetailsBean.ResultBean result = patientDetailsBean.getResult();
        patient_activity_tv_title.setText(result.getTitle() + "");
        patient_activity_tv_adoptNickName.setText(result.getAdoptNickName() + "");
        patient_activity_tv_disease.setText(result.getDisease() + "");
        patient_activity_tv_department.setText(result.getDepartment() + "");
        patient_activity_tv_detail.setText(result.getDetail() + "");
        patient_activity_tv_treatmentProcess.setText(result.getTreatmentProcess() + "");
        long treatmentStartTime = result.getTreatmentStartTime();
        long treatmentEndTime = result.getTreatmentEndTime();
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endTimes = format0.format(treatmentEndTime);
        String startTimes = format0.format(treatmentStartTime);
        patient_activity_tv_treatment_time.setText(startTimes + "----" + endTimes);
        Glide.with(this).load(result.getPicture())
                .placeholder(R.drawable.none_comment)
                .error(R.drawable.none_comment)
                .into(patient_activity_iv_picture);
        patient_activity_tv_commentNum.setText(result.getCommentNum() + "");
        patient_activity_tv_collectionNum.setText(result.getCollectionNum() + "");
        int sickCircleId = result.getSickCircleId();

        Uri parse = Uri.parse(result.getAdoptHeadPic());
        imgHeadPic.setImageURI(parse);
        nameNickName.setText(result.getAdoptNickName());
        textadoptComment.setText(result.getAdoptComment());
        Date date1 = new Date(result.getTreatmentEndTime());
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        textadoptComment.setText(simpleDateFormat1.format(date1));
        patient_activity_iv_intent_release_sickCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientDetailsActivity.this, ReleaseCirclesActivity.class);
                startActivity(intent);
            }
        });
        patient_activity_iv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.querycommentbean(sickCircleId, 1, 10);
                patient_activity_relative_content.setVisibility(View.VISIBLE);
                patient_activity_relative_release_sickCircle.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void publishcomment(CommentCircleBean commentCircleBean) {
        if (commentCircleBean.getStatus() == Constant.SUCCESS_CODE) {
            ToastUtils.show(commentCircleBean.getMessage());
        } else {
            ToastUtils.show(commentCircleBean.getMessage());
        }
    }

    @Override
    public void querycommentbean(QueryCommentBean queryCommentBean) {
        if (queryCommentBean.getStatus().equals("0000")) {
            List<QueryCommentBean.ResultBean> result = queryCommentBean.getResult();
            SyLinearLayoutManager syLinearLayoutManager = new SyLinearLayoutManager(this, SyLinearLayoutManager.VERTICAL, false);
            recyclerSickCircleCommentListAdapter = new RecyclerSickCircleCommentListAdapter(this);
            recyclerSickCircleCommentListAdapter.addData(result);
            recycler_sick_circle_comment_list.setLayoutManager(syLinearLayoutManager);
            recycler_sick_circle_comment_list.setAdapter(recyclerSickCircleCommentListAdapter);
        }
    }
}
