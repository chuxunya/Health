package com.wd.health;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.utils.Logger;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.adapter.RecordAdapter;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.PushMessagedBean;
import com.wd.health.bean.RecordListBean;
import com.wd.health.contract.IRecordContract;
import com.wd.health.presenter.IRecordContractPresenter;
import com.wd.health.utils.RsaCoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.event.NotificationClickEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.api.BasicCallback;

/**
 * @describe(描述)：jgActivity
 * @data（日期）: 2019/12/20
 * @time（时间）: 19:46
 * @author（作者）: 李泽楷
 **/

public class JgActivity extends BaseActivity<IRecordContractPresenter> implements IRecordContract.IRecordView {

    @BindView(R2.id.emotion_voice)
    ImageView emotionVoice;
    @BindView(R2.id.edit_text)
    EditText editText;
    @BindView(R2.id.voice_text)
    TextView voiceText;
    @BindView(R2.id.emotion_button)
    ImageView emotionButton;
    @BindView(R2.id.emotion_add)
    ImageView emotionAdd;
    @BindView(R2.id.emotion_fa)
    ImageView emotionFa;
    public static final String TAG = "JgActivity";
    @BindView(R2.id.sim_wenzhen_fanhui)
    SimpleDraweeView simWenzhenFanhui;
    @BindView(R2.id.title_name)
    TextView titleName;
    @BindView(R2.id.recy_record)
    RecyclerView recyRecord;
    @BindView(R2.id.line_jg)
    LinearLayout lineJg;
    private List<RecordListBean.ResultBean> result;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i(TAG, "handleMessage111: " + msg.what);

            switch (msg.what) {
                case 0:
                    Log.i(TAG, "handleMessage111: " + result.size());
                    recyRecord.scrollToPosition(result.size() - 1);
                    break;
            }
        }
    };
    private RecordAdapter adapter;
    private CurrentInquiryRecordBean.ResultBean result1;
    private int userId;
    private String sesssionId;
    private String s;

    @Override
    protected IRecordContractPresenter providePresenter() {
        return new IRecordContractPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_jg;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
        userId = user.getInt("userId", 0);
        sesssionId = user.getString("sesssionId", "");

        try {
            String jgpwd = RsaCoder.decryptByPublicKey("Ulljg1biEvGM7p6u82IEqmFuqQw24JwfBBr3XMzzQEV1NhChkPsw2xoS+ePiuh7SfXASBPGe25RNgl3Vmf0Wz5VGbhdNsHtjXLQsjf/TI3AsEh1TS/pqUmHg78eVnSonV4CTyvQECfmM7roSCcTjcvLyVvvMcYcngtDVch6ff4c=");
            s = MD5(jgpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = editText.getText().toString();
                if (s.equals("")) {

                    emotionFa.setVisibility(View.GONE);
                    emotionAdd.setVisibility(View.VISIBLE);

                } else {
                    emotionFa.setVisibility(View.VISIBLE);
                    emotionAdd.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        JMessageClient.registerEventReceiver(this);
        mPresenter.getCurrentInquiryRecorPresenter(userId+"", sesssionId);
        JMessageClient.login("CRMBNechu0117", s, new BasicCallback() {
            @Override
            public void gotResult(int i, String s) {
                Log.i(TAG, "gotResult: "+s);
                if (i==0) {
                    Toast.makeText(JgActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onCurrentInquiryRecorSuccess(CurrentInquiryRecordBean bean) {
        Logger.i(TAG, "onCurrentInquiryRecorSuccess: " + bean.getMessage());
        if (bean.getStatus().equals("0000")) {
            if (bean.getResult() != null) {
                titleName.setText(bean.getResult().getDoctorName());
                result1 = bean.getResult();
                mPresenter.getRecordListPresenter(userId+"", sesssionId, bean.getResult().getRecordId() + "", "1", "50");

            }
        } else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPushMessageSuccess(PushMessagedBean bean) {
        if (bean.getStatus().equals("0000")){
            if (bean.getMessage().equals("推送成功")){
                mPresenter.getRecordListPresenter(userId+"", sesssionId, result1.getRecordId() + "", "1", "50");
                editText.setText("");
            }
        }else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRecordListSuccess(RecordListBean bean) {
        if (bean.getStatus().equals("0000")) {
            if (bean.getResult() != null) {
                result = bean.getResult();
                List<RecordListBean.ResultBean>list=new ArrayList<>();
                for (int i = bean.getResult().size()-1; i >-1 ; i--) {
                    list.add(result.get(i));
                }

                        adapter = new RecordAdapter(list, JgActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(JgActivity.this);
                linearLayoutManager.setStackFromEnd(true);
                recyRecord.setLayoutManager(linearLayoutManager);
                recyRecord.setAdapter(adapter);

                recyRecord.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        hideSoftInput(JgActivity.this, editText);
                        return false;
                    }
                });
            }
        } else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Throwable e) {
        Logger.i(TAG, "onFailure: " + e.toString());
    }

    //弹出键盘
    public static void showSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }

    //隐藏键盘
    public static void hideSoftInput(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    @OnClick(R2.id.emotion_fa)
    public void onClick() {
        String s = editText.getText().toString();
        Conversation conversation = Conversation.createSingleConversation(result1.getUserName(), "b5f102cc307091e167ce52e0");
        TextContent content = new TextContent(s);
        cn.jpush.im.android.api.model.Message sendMessage = conversation.createSendMessage(content);
        JMessageClient.sendMessage(sendMessage);
        mPresenter.getPushMessagePresenter(userId+"", sesssionId,result1.getRecordId()+"",s,1+"",result1.getDoctorId()+"");
    }
    //接受消息的事件
    public void onEventMainThread(MessageEvent event) {
        cn.jpush.im.android.api.model.Message message = event.getMessage();
        switch (message.getContentType()) {
            case text:
                // 处理文字消息
                TextContent textContent = (TextContent) message.getContent();
                String text = textContent.getText();
                Logger.i(TAG, "onEventMainThread: "+text);
                mPresenter.getRecordListPresenter(userId+"", sesssionId, result1.getRecordId() + "", "1", "50");
                break;
        }
    }
    public void onEvent(NotificationClickEvent event) {
        Intent notificationIntent = new Intent(this, JgActivity.class);
        this.startActivity(notificationIntent);// 自定义跳转到指定页面
    }

    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        JMessageClient.unRegisterEventReceiver(this);
    }
}
