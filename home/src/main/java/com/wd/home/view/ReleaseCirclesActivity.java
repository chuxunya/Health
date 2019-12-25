package com.wd.home.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.bumptech.glide.Glide;
import com.wd.home.R;
import com.wd.home.adapter.ConsultationTwoAdapter;
import com.wd.home.adapter.DiseaAdapter;
import com.wd.home.adapter.consultation.IllnessAdapter;
import com.wd.home.api.ImageUtil;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DoTaskBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.KeywordSearchBean;
import com.wd.home.bean.ReleasePatientsBean;
import com.wd.home.bean.UploadPatientBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.DiseaseContract;
import com.wd.home.presenter.BannerPresenter;
import com.wd.home.presenter.DiseasePresenter;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor 发布病友圈
 * @time 2019/12/19 18:46
 */
public class ReleaseCirclesActivity extends BaseActivity<DiseasePresenter> implements DiseaseContract.Iview {

    private Switch item_switch;
    private LinearLayout linearLayout;
    private RelativeLayout release_circle_iv_startTime;
    private RelativeLayout release_circle_iv_choose_department;
    private RelativeLayout release_circle_iv_choose_disease;
    private RelativeLayout release_circle_iv_endTime;
    Calendar calendar = Calendar.getInstance(Locale.CHINA);
    private TextView release_circle_tv_startTime1;
    private TextView release_circle_tv_endTime;
    private ImageView release_circle_iv_upload_Picture;
    private ImageView release_circle_iv_delete_Picture;
    private RecyclerView popup_recycler_department;
    private PopupWindow popWindow;
    private RecyclerView popup_recycler_disease;
    private PopupWindow popWindowDisease;
    private int id;
    private Button release_circle_btn_publish;
    private TextView release_circle_tv_choose_department;
    private TextView release_circle_tv_choose_disease;
    private String path;
    private MultipartBody.Part picture;
    private EditText release_circle_et_title;
    private EditText release_circle_et_detail;
    private EditText release_circle_et_treatmentHospital;
    private EditText release_circle_et_treatmentProcess;
    private TextView release_circle_tv_startTime;
    private String sessionId = "1577171191460446";
    private int userId = 446;
    private int sickCircleId;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_release_circles;
    }

    @Override
    protected void initView() {
        super.initView();
        item_switch = findViewById(R.id.item_switch);
        release_circle_iv_upload_Picture = findViewById(R.id.release_circle_iv_upload_Picture);
        linearLayout = findViewById(R.id.xuanshangedu_linear);
        release_circle_iv_delete_Picture = findViewById(R.id.release_circle_iv_delete_Picture);
        release_circle_iv_startTime = findViewById(R.id.release_circle_iv_startTime);
        release_circle_tv_startTime1 = findViewById(R.id.release_circle_tv_startTime);
        release_circle_iv_endTime = findViewById(R.id.release_circle_iv_endTime);
        release_circle_tv_endTime = findViewById(R.id.release_circle_tv_endTime);
        release_circle_iv_choose_department = findViewById(R.id.release_circle_iv_choose_department);
        release_circle_iv_choose_disease = findViewById(R.id.release_circle_iv_choose_disease);
        release_circle_btn_publish = findViewById(R.id.release_circle_btn_publish);
        release_circle_tv_choose_department = findViewById(R.id.release_circle_tv_choose_department);
        release_circle_tv_choose_disease = findViewById(R.id.release_circle_tv_choose_disease);
        release_circle_et_title = findViewById(R.id.release_circle_et_title);
        release_circle_et_detail = findViewById(R.id.release_circle_et_detail);
        release_circle_tv_startTime = findViewById(R.id.release_circle_tv_startTime);
        release_circle_et_treatmentHospital = findViewById(R.id.release_circle_et_treatmentHospital);
        release_circle_et_treatmentProcess = findViewById(R.id.release_circle_et_treatmentProcess);
    }

    @Override
    protected DiseasePresenter providePresenter() {
        return new DiseasePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //悬赏额度的开关
        item_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });
        //开始时间
        release_circle_iv_startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        release_circle_tv_startTime1.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });
        //结束时间
        release_circle_iv_endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ReleaseCirclesActivity.this);
                final View view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog_date, null);
                final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
                //设置日期简略显示 否则详细显示 包括:星期\周
                datePicker.setCalendarViewShown(false);
                //初始化当前日期
                calendar.setTimeInMillis(System.currentTimeMillis());
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), null);
                //设置date布局
                builder.setView(view);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //日期格式
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        release_circle_tv_endTime.setText(sb);
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });

        //请选择就诊科室
        release_circle_iv_choose_department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindowDepartment(v);
            }


        });

        //对应病症
        release_circle_iv_choose_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindowDisease(v);
            }
        });


        //打开相册
        release_circle_iv_upload_Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ReleaseCirclesActivity.this, "打开相册", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });
        //删除选中图片
        release_circle_iv_delete_Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                release_circle_iv_upload_Picture.setImageResource(R.mipmap.add);
            }
        });

        release_circle_btn_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //标题
                String title = release_circle_et_title.getText().toString().trim();
                //病症详情
                String detail = release_circle_et_detail.getText().toString().trim();
                //病症描述
                String disease = release_circle_tv_choose_disease.getText().toString().trim();
                //治疗医院
                String treatmentHospital = release_circle_et_treatmentHospital.getText().toString().trim();
                //治疗开始时间 格式’2018-3-26’
                String treatmentStartTime = release_circle_tv_startTime.getText().toString().trim();
                //	治疗结束时间 格式’2018-6-26’
                String treatmentEndTime = release_circle_tv_endTime.getText().toString().trim();

                String treatmentProcess = release_circle_et_treatmentProcess.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "标题不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(detail)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入病症详情", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(disease)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "病症描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentStartTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗开始时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentEndTime)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请选择治疗结束时间", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentHospital)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "请输入治疗医院", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(treatmentProcess)) {
                    Toast.makeText(ReleaseCirclesActivity.this, "治疗过程描述", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String, Object> map = new HashMap<>();
                map.put("title", title);
                map.put("departmentId", id);
                map.put("disease", disease);
                map.put("detail", detail);
                map.put("treatmentHospital", treatmentHospital);
                map.put("treatmentStartTime", treatmentStartTime);
                map.put("treatmentEndTime", treatmentEndTime);
                map.put("treatmentProcess", treatmentProcess);
                map.put("amount", 0);
                //调发布圈子接口
                mPresenter.publishsick(userId, sessionId, map);
                mPresenter.uploadsick(userId, sessionId, sickCircleId, picture);


            }
        });

    }
    ////科室列表
    private void initPopWindowDepartment(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_popip_department, null, false);
        popup_recycler_department = view.findViewById(R.id.popup_recycler_department);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindow.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindow.showAsDropDown(v, 50, 0);
        mPresenter.depart();
    }
    //根据科室查询对应病症
    private void initPopWindowDisease(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_popip_disease, null, false);
        popup_recycler_disease = view.findViewById(R.id.popup_recycler_disease);
        //1.构造一个PopupWindow，参数依次是加载的View，宽高
        popWindowDisease = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindowDisease.setAnimationStyle(R.anim.anim_pop);  //设置加载动画
        //这些为了点击非PopupWindow区域，PopupWindow会消失的，如果没有下面的
        //代码的话，你会发现，当你把PopupWindow显示出来了，无论你按多少次后退键
        //PopupWindow并不会关闭，而且退不出程序，加上下述代码可以解决这个问题
        popWindowDisease.setTouchable(true);
        popWindowDisease.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindowDisease.setBackgroundDrawable(new ColorDrawable(0x00000000));    //要为popWindow设置一个背景才有效
        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindowDisease.showAsDropDown(v, 50, 0);

        //根据科室查询对应病症
        mPresenter.disease(id);
    }

  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是不是选中图片了
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {
                    //用一个工具类获取图片的绝对路径,我会粘到下方
                    path = ImageUtil.getPath(this, uri);
                    Glide.with(this).load(path)
                            .placeholder(R.mipmap.add)
                            .error(R.mipmap.add)
                            .into(release_circle_iv_upload_Picture);
                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        picture = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                    }
                }
            } else {
                Toast.makeText(this, "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
    //科室
    @Override
    public void depart(DepartmentBean departmentBean) {
        List<DepartmentBean.ResultBean> result = departmentBean.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        ConsultationTwoAdapter consultationTwoAdapter = new ConsultationTwoAdapter(result, this);
        popup_recycler_department.setLayoutManager(gridLayoutManager);
        popup_recycler_department.setAdapter(consultationTwoAdapter);

        consultationTwoAdapter.onItemClickListener(new ConsultationTwoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                id = result.get(position).getId();
                release_circle_tv_choose_department.setText(result.get(position).getDepartmentName());
                Toast.makeText(ReleaseCirclesActivity.this, result.get(position).getDepartmentName(), Toast.LENGTH_SHORT).show();
                popWindow.dismiss();
            }
        });
    }

    //根据科室查询对应症状
    @Override
    public void disease(DiseaseBean diseaseBean) {
        List<DiseaseBean.ResultBean> result = diseaseBean.getResult();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        DiseaAdapter illnessAdapter = new DiseaAdapter(result, this);
        popup_recycler_disease.setLayoutManager(gridLayoutManager);
        popup_recycler_disease.setAdapter(illnessAdapter);
        illnessAdapter.onItemClickListener(new IllnessAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String name = result.get(position).getName();
                release_circle_tv_choose_disease.setText(name + "");
                popWindowDisease.dismiss();
            }
        });
    }

    //发布照片
    @Override
    public void uploadsick(UploadPatientBean uploadPatientBean) {
        if (uploadPatientBean.getStatus().equals("0000")) {
            Toast.makeText(this, uploadPatientBean.getMessage(), Toast.LENGTH_SHORT).show();
            //做任务
            mPresenter.dotask(userId, sessionId, 1003);

            finish();
        } else {
            Toast.makeText(this, uploadPatientBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //发布病友圈
    @Override
    public void publishsick(ReleasePatientsBean releasePatientsBean) {
        if (releasePatientsBean.getStatus().equals("0000")) {
            Toast.makeText(this, releasePatientsBean.getMessage(), Toast.LENGTH_SHORT).show();
            sickCircleId = releasePatientsBean.getResult();

            if (picture != null) {
                mPresenter.uploadsick(userId, sessionId, sickCircleId, picture);
            } else {
                //做任务
               mPresenter.dotask(userId, sessionId, 1003);

                finish();
            }
        } else {
            Toast.makeText(this, releasePatientsBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void dotask(DoTaskBean doTaskBean) {
        if (doTaskBean.getStatus().equals("0000")) {
            Toast.makeText(this, "每日首发病友圈完成!快去领取奖励吧", Toast.LENGTH_SHORT).show();
            mPresenter.uploadsick(userId, sessionId, sickCircleId, picture);
        }
    }
}
