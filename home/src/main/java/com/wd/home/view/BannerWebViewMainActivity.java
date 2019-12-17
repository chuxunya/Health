package com.wd.home.view;

import android.content.Intent;
import android.os.Bundle;

import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.home.R;

/**
 * @author 2019/11/7
 * @author 9:54
 * 席贵
 * Banner
 */
public class BannerWebViewMainActivity extends AppCompatActivity {

    private WebView bannerweb;
    private String jumpUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_web_view_main);
        initView();
        Intent intent = getIntent();
        //banner跳转地址
        jumpUrl = intent.getStringExtra("jumpUrl");
        WebSettings settings = bannerweb.getSettings();
        settings.setJavaScriptEnabled(true);
        bannerweb.loadUrl(jumpUrl);
    }

    private void initView() {
        //获取资源ID
        bannerweb =  findViewById(R.id.bannerweb);
    }
}
