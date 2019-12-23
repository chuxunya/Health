package com.wd.home.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor 发布病友圈
 * @time 2019/12/19 18:46
 */
public class ReleaseCirclesActivity extends BaseActivity {

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

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

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
               // initPopWindowDepartment(v);
            }
        });

        //对应病症
        release_circle_iv_choose_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // initPopWindowDisease(v);
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

    }
}
