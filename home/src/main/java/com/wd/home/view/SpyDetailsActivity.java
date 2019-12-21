package com.wd.home.view;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.bean.FindinformatBean;
import com.wd.home.contract.HomeContract;
import com.wd.home.contract.HomepageContract;
import com.wd.home.presenter.HomePagePresenter;
import com.wd.home.presenter.HomePresenter;

import butterknife.BindView;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor hp
 * @time 2019/12/20 14:14
 */
public class SpyDetailsActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    private TextView sypTitle;
    private TextView spyName;
    private ImageView titlesTouxiang;
    private TextView titlesName;
    private ImageView homeXiaoxi;
    private WebView spyWib;
    private FindinformatBean.ResultBean result;


    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_spy_details;
    }

    @Override
    protected void initView() {
        super.initView();
        sypTitle  = findViewById(R.id.syp_title);
        spyName  = findViewById(R.id.spy_name);
        titlesTouxiang  = findViewById(R.id.titles_touxiang);
        titlesName  = findViewById(R.id.titles_name);
        homeXiaoxi  = findViewById(R.id.home_xiaoxi);
        spyWib  = findViewById(R.id.spy_wib);
    }

    @Override
    protected void initData() {
        super.initData();
        WebSettings settings = spyWib.getSettings();
        spyWib.getSettings().setJavaScriptEnabled(true);
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        // settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        spyWib.setNestedScrollingEnabled(false);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mPresenter.findformat(id);
        titlesName.setText("资讯详情");
    }

    @Override
    public void findformat(FindinformatBean findinformatBean) {

        result = findinformatBean.getResult();

        sypTitle.setText(result.getTitle());
        spyName.setText(result.getSource());
        String content = result.getContent();
        spyWib.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
    }


}
