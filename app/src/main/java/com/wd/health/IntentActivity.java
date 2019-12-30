package com.wd.health;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentActivity extends BaseActivity {

    @BindView(R.id.image_guide)
    ImageView imageGuide;
    @BindView(R.id.text_time)
    TextView textTime;
    private int i = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if (i > 0) {
                        i--;
                        textTime.setText("" + i+"s");
                        handler.sendEmptyMessageDelayed(0, 1000);
                    } else {
                        ARouter.getInstance().build("/home/view/HomeActivity")
                                .navigation();
                        finish();
                    }
                    break;
            }
        }
    };

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_intent;
    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(0, 1000);
    }


    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
