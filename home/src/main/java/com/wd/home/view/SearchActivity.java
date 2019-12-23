package com.wd.home.view;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.R;
import com.wd.home.adapter.KeywordSearchAdapter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.KeywordSearchBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.presenter.BannerPresenter;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor hp
 * @time 2019/12/21 8:44
 */
public class SearchActivity extends BaseActivity<BannerPresenter> implements BannerContract.Iview {

    private ImageView search_back;
    private EditText search_keyword;
    private TextView search_text;
    private RecyclerView search_recyclerView;
    private RelativeLayout patient_relative_serach;
    private KeywordSearchAdapter keywordSearchAdapter;
    private List<KeywordSearchBean.ResultBean> result;

    @Override
    protected BannerPresenter providePresenter() {
        return new BannerPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        super.initView();
        search_back = findViewById(R.id.search_back);
        search_keyword = findViewById(R.id.search_keyword);
        search_text = findViewById(R.id.search_text);
        search_recyclerView=findViewById(R.id.search_recyclerView);
    }

    @Override
    protected void initData() {
        super.initData();
        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = search_keyword.getText().toString().trim();
                mPresenter.keywordsearchbean(trim);
            }
        });
    }

    //搜索框
    @Override
    public void keywordsearchbean(KeywordSearchBean keywordSearchBean) {
        result = keywordSearchBean.getResult();
        if (result!=null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            search_recyclerView.setLayoutManager(linearLayoutManager);
            keywordSearchAdapter = new KeywordSearchAdapter(this);
            keywordSearchAdapter.addData(result);
            search_recyclerView.setAdapter(keywordSearchAdapter);
            keywordSearchAdapter.onItemClickListener(new KeywordSearchAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position,int id) {
                    Intent intent = new Intent(SearchActivity.this, PatientDetailsActivity.class);
                    intent.putExtra("sickCircleId", id);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void banner(BannerBean bannerBean) {

    }

    @Override
    public void department(DepartmentBean departmentBean) {

    }

    @Override
    public void information(InformationBean informationBean) {

    }

    @Override
    public void informationlist(InformationListBean informationListBean) {

    }

}
