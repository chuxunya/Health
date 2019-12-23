package com.wd.health;

import android.widget.Button;


import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn)
    Button btn;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.btn)
    public void onViewClicked() {
        ARouter.getInstance().build("/login/LoginActivity")
                .withString("name", "张三")
                .navigation();
    }
}
