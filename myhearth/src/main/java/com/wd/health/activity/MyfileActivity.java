package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.XiuBean;
import com.wd.health.contract.FindDangContract;
import com.wd.health.presenter.FindDangPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *@describe(描述)：MyfileActivity
 *@data（日期）: 2019/12/30
 *@time（时间）: 10:47
 *@author（作者）: 张安恒  用户查看自己的档案
 **/
public class MyfileActivity extends BaseActivity<FindDangPresenter> implements FindDangContract.Iview {

    private ImageView back;
    private ImageView fil_tus;
    private TextView addFilesText;
    private RelativeLayout fil_dangs;
    private TextView diMain;
    private TextView diNow;
    private TextView diBefore;
    private TextView treRecent;
    private TextView start;
    private TextView end;
    private TextView treProcess;
    private RecyclerView filsss_recyclerView;
    private TextView del;
    private TextView update;
    private ScrollView fil_scrollView;
    private long treatmentStartTime;
    private long treatmentEndTime;
    private int id;
    private String picture;
    private String treatmentProcess;
    private String treatmentHospitalRecent;
    private String diseaseBefore;
    private String diseaseNow;
    private String diseaseMain;

    @Override
    protected FindDangPresenter providePresenter() {
        return new FindDangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_myfile;
    }

    @Override
    protected void initView() {
        super.initView();
        back = (ImageView) findViewById(R.id.back);
        fil_tus = (ImageView) findViewById(R.id.fil_tus);
        addFilesText = (TextView) findViewById(R.id.addFilesText);
        fil_dangs = (RelativeLayout) findViewById(R.id.fil_dangs);
        diMain = (TextView) findViewById(R.id.diMain);
        diNow = (TextView) findViewById(R.id.diNow);
        diBefore = (TextView) findViewById(R.id.diBefore);
        treRecent = (TextView) findViewById(R.id.treRecent);
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        treProcess = (TextView) findViewById(R.id.treatmentProcess);
        filsss_recyclerView = (RecyclerView) findViewById(R.id.filsss_RecyclerView);
        del = (TextView) findViewById(R.id.del);
        update = (TextView) findViewById(R.id.update);
        fil_scrollView = (ScrollView) findViewById(R.id.fil_ScrollView);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.FindDang();

        //点击返回按钮进行销毁当前页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //点击删除进行删除档案
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.DeleDang(id+"");
                fil_dangs.setVisibility(View.VISIBLE);
            }
        });

        //点击编辑进入编辑页面
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MyfileActivity.this, MyxiufileActivity.class);
                //档案id
                intent1.putExtra("id",id);
                //主要病状
                intent1.putExtra("diMain",diseaseMain);
                //现病史
                intent1.putExtra("dinow",diseaseNow);
                //既往史
                intent1.putExtra("diseaseBefore",diseaseBefore);
                //最近治疗医院
                intent1.putExtra("Recent",treatmentHospitalRecent);
                //治疗过程
                intent1.putExtra("tProcess",treatmentProcess);
                //开始时间格式
                intent1.putExtra("StTime",treatmentStartTime);
                //结束时间
                intent1.putExtra("ETime",treatmentEndTime);
                //图片
                intent1.putExtra("pic",picture);
                startActivity(intent1);
                finish();
            }
        });

    }

    @Override
    public void finddang(FindUserArchivesBean findUserArchivesBean) {
        String message = findUserArchivesBean.getMessage();
        if (message.equals("档案为空，快去添加吧！")) {
            fil_dangs.setVisibility(View.VISIBLE);
            //点击添加
            addFilesText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyfileActivity.this, MyaddfileActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            id = findUserArchivesBean.getResult().getId();
            //主要病症
            diseaseMain = findUserArchivesBean.getResult().getDiseaseMain();
            diMain.setText(diseaseMain);
            //现病史
            diseaseNow = findUserArchivesBean.getResult().getDiseaseNow();
            diNow.setText(diseaseNow);
            //既往史
            diseaseBefore = findUserArchivesBean.getResult().getDiseaseBefore();
            diBefore.setText(diseaseBefore);
            //最近治疗医院
            treatmentHospitalRecent = findUserArchivesBean.getResult().getTreatmentHospitalRecent();
            treRecent.setText(treatmentHospitalRecent);
            //治疗过程
            treatmentProcess = findUserArchivesBean.getResult().getTreatmentProcess();
            treProcess.setText(treatmentProcess);
            //开始时间
            treatmentStartTime = findUserArchivesBean.getResult().getTreatmentStartTime();
            start.setText(getTime());
            //结束时间
            treatmentEndTime = findUserArchivesBean.getResult().getTreatmentEndTime();
            end.setText(getTime1());
            //相关图片
        //    picture = findUserArchivesBean.getResult().getPicture();

            //图片的布局
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MyfileActivity.this, 1);
            filsss_recyclerView.setLayoutManager(gridLayoutManager);
            //适配器
         /*   MyfileAdapter tuAdapter = new MyfileAdapter(picture, MyfileActivity.this);
            filsss_recyclerView.setAdapter(tuAdapter);*/

        }
    }

    @Override
    public void deledang(DeleDangBean deleDangBean) {

    }

    @Override
    public void xiudang(XiuBean xiuBean) {

    }

    private String getTime() {

        //日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM月-dd日");

        //当前的时间多少毫秒
        Date date = new Date(treatmentStartTime);

        //日期格式的 格式为 data
        String format = simpleDateFormat.format(date);

        //返回format
        return format;
    }

    private String getTime1() {

        //日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");

        //当前的时间多少毫秒
        Date date = new Date(treatmentStartTime);

        //日期格式的 格式为 data
        String format = simpleDateFormat.format(date);

        //返回format
        return format;
    }

}
