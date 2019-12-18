package com.wd.home.view;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor 健康评测
 * @time 2019/12/16 16:01
 */
public class ReviewsMainActivity extends BaseActivity {


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_reviews_main;
    }

    @Override
    protected void initData() {
        super.initData();

        WebView reviews_web = findViewById(R.id.reviews_web);
        reviews_web.loadUrl("https://www.wjx.cn/jq/33939807.aspx");
        WebSettings settings = reviews_web.getSettings();
        settings.setJavaScriptEnabled(true);
    }
}
