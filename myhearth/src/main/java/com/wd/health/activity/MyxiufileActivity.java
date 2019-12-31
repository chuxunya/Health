package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.MultipartBody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.health.R;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.XiuBean;
import com.wd.health.contract.FindDangContract;
import com.wd.health.presenter.FindDangPresenter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@describe(描述)：MyxiufileActivity
 *@data（日期）: 2019/12/31
 *@time（时间）: 9:32
 *@author（作者）: 张安恒  修改档案
 **/
public class MyxiufileActivity extends BaseActivity<FindDangPresenter> implements FindDangContract.Iview {
    private ImageView back;
    private EditText diseaseMai;
    private LinearLayout line;
    private EditText diseaseNo;
    private LinearLayout lin22;
    private EditText diseaseBefor;
    private LinearLayout lin33;
    private EditText treatmentHospitalRecen;
    private LinearLayout lin44;
    private TextView star;
    private TextView edit_starttim;
    private RelativeLayout startTim;
    private LinearLayout lin55;
    private TextView en;
    private TextView edit_endtim;
    private RelativeLayout endTim;
    private LinearLayout lin66;
    private EditText treatmentProces;
    private LinearLayout lin77;
    private RecyclerView bo_image_lis;
    private ImageView add_imag;
    private Button addFile;
    private LinearLayout lin88;
    private String stTime;
    private String eTime;

    private int id;
    private ImageView start_ima;
    private ImageView end_ima;
    private List<File> fileList =new ArrayList<>();
    private List<MultipartBody.Part> partList =new ArrayList<>();

    private String pic;

    @Override
    protected FindDangPresenter providePresenter() {
        return new FindDangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_myxiufile;
    }

    @Override
    protected void initView() {
        super.initView();
        back = (ImageView) findViewById(R.id.back);
        diseaseMai = (EditText) findViewById(R.id.diseaseMai);
        line = (LinearLayout) findViewById(R.id.line);
        diseaseNo = (EditText) findViewById(R.id.diseaseNo);
        lin22 = (LinearLayout) findViewById(R.id.lin);
        diseaseBefor = (EditText) findViewById(R.id.diseaseBefor);
        lin33 = (LinearLayout) findViewById(R.id.lin33);
        treatmentHospitalRecen = (EditText) findViewById(R.id.treatmentHospitalRecen);
        lin44 = (LinearLayout) findViewById(R.id.lin44);
        star = (TextView) findViewById(R.id.star);
        edit_starttim = (TextView) findViewById(R.id.edit_starttim);
        startTim = (RelativeLayout) findViewById(R.id.startTim);
        lin55 = (LinearLayout) findViewById(R.id.lin55);
        en = (TextView) findViewById(R.id.en);
        edit_endtim = (TextView) findViewById(R.id.edit_endtim);
        endTim = (RelativeLayout) findViewById(R.id.endTim);
        lin66 = (LinearLayout) findViewById(R.id.lin66);
        treatmentProces = (EditText) findViewById(R.id.treatmentProces);
        lin77 = (LinearLayout) findViewById(R.id.lin77);
        bo_image_lis = (RecyclerView) findViewById(R.id.bo_image_lis);
        add_imag = (ImageView) findViewById(R.id.add_imag);
        addFile = (Button) findViewById(R.id.addFile);
        lin88 = (LinearLayout) findViewById(R.id.lin88);
        start_ima =(ImageView) findViewById(R.id.start_ima);
        end_ima =(ImageView) findViewById(R.id.end_ima);


        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        String diMain = intent.getStringExtra("diMain");
        String dinow = intent.getStringExtra("dinow");
        String Before = intent.getStringExtra("diseaseBefore");
        String recent = intent.getStringExtra("Recent");
        String tProcess = intent.getStringExtra("tProcess");
        stTime = intent.getStringExtra("StTime");
        eTime = intent.getStringExtra("ETime");
        pic = intent.getStringExtra("pic");

        diseaseMai.setText(diMain);
        diseaseNo.setText(dinow);
        diseaseBefor.setText(Before);
        treatmentHospitalRecen.setText(recent);
        treatmentProces.setText(tProcess);
        edit_starttim.setText(stTime);
        edit_endtim.setText(eTime);
    }

    @Override
    protected void initData() {
        super.initData();
        //点击返回按钮进行销毁当前页面
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //主要病症
                String main = diseaseMai.getText().toString().trim();
                //现病史
                String now = diseaseNo.getText().toString().trim();
                //既往史
                String before = diseaseBefor.getText().toString().trim();
                //最近治疗医院
                String recent = treatmentHospitalRecen.getText().toString().trim();
                //治疗过程
                String process = treatmentProces.getText().toString().trim();
                String startte = edit_starttim.getText().toString().trim();
                String endte = edit_endtim.getText().toString().trim();

                HashMap<String, String> hashMa = new HashMap<>();
                hashMa.put("archivesId", String.valueOf(id));
                hashMa.put("diseaseMain",main);
                hashMa.put("diseaseNow",now);
                hashMa.put("diseaseBefore",before);
                hashMa.put("treatmentHospitalRecent",recent);
                hashMa.put("treatmentProcess",process);
                hashMa.put("treatmentStartTime",startte);
                hashMa.put("treatmentEndTime",endte);
                mPresenter.XiuDang(hashMa);
            }
        });
    }

    @Override
    public void finddang(FindUserArchivesBean findUserArchivesBean) {

    }

    @Override
    public void deledang(DeleDangBean deleDangBean) {

    }

    @Override
    public void xiudang(XiuBean xiuBean) {
        String message = xiuBean.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

}
