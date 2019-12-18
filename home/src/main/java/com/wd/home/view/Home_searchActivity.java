package com.wd.home.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.google.android.material.internal.FlowLayout;
import com.wd.home.R;

import com.wd.home.adapter.consultation.DiseaseSearchVoListAdapter;
import com.wd.home.adapter.consultation.DoctorSearchVoListAdapter;
import com.wd.home.adapter.consultation.DrugsSearchVoListAdapter;
import com.wd.home.adapter.consultation.RecordSQLiteOpenHelper;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.PopularSearchBean;
import com.wd.home.contract.HomepageContract;
import com.wd.home.presenter.HomePagePresenter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor 首页搜索
 * @time 2019/12/15 19:51
 */
public class Home_searchActivity extends BaseActivity<HomePagePresenter> implements HomepageContract.Iview {

    TagFlowLayout flTopSearch;
    private RecordSQLiteOpenHelper helper;
    private FlowView flSearchHistory;
    private SQLiteDatabase db;
    private boolean hasData;
    private boolean whetherTheQuery = false;
    private ImageView ivHomeSearchBack;
    private EditText etHomeSearchTitle;
    private TextView ivHomeSearch;
    private LinearLayout llRelevantSearchData;
    private ImageView ivNoSearchPic;
    private TextView tvNoSearchName;
    private RelativeLayout rlHomeNoSearch;
    private RecyclerView rvDoctor;
    private RecyclerView rvDrug;
    private RecyclerView rvSymptoms;
    private LinearLayout llSearchData;
    @Override
    protected HomePagePresenter providePresenter() {
        return new HomePagePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home_search;
    }

    @Override
    protected void initView() {
        super.initView();
        //获取资源ID
        ivHomeSearchBack =  findViewById(R.id.iv_home_search_back);
        etHomeSearchTitle =  findViewById(R.id.et_home_search_title);
        ivHomeSearch = findViewById(R.id.iv_home_search);
        flSearchHistory = findViewById(R.id.fl_searchHistory);
        llRelevantSearchData =  findViewById(R.id.ll_relevantSearchData);
        ivNoSearchPic =  findViewById(R.id.iv_noSearch_pic);
        tvNoSearchName =  findViewById(R.id.tv_noSearch_name);
        rlHomeNoSearch =  findViewById(R.id.rl_home_noSearch);
        rvDoctor = findViewById(R.id.rv_doctor);
        rvDrug =  findViewById(R.id.rv_drug);
        rvSymptoms =  findViewById(R.id.rv_symptoms);
        llSearchData =  findViewById(R.id.ll_searchData);
        flTopSearch =  findViewById(R.id.fl_topSearch);
        ivHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etHomeSearchTitle.getText().toString();
                search(keyword);
            }
        });
        ivHomeSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.homepage("哈哈");
        mPresenter.popularsear();
        //记录到sqlite中
        helper = new RecordSQLiteOpenHelper(this);
        String tempName = etHomeSearchTitle.getText().toString();
        queryData(tempName);
    }

    //首页搜索
    @Override
    public void homepage(HomePageSearchBean homePageSearchBean) {

        HomePageSearchBean.ResultBean result = homePageSearchBean.getResult();

        //病症
        List<HomePageSearchBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList = result.getDiseaseSearchVoList();
        //医生
        List<HomePageSearchBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList = result.getDoctorSearchVoList();
        //药品
        List<HomePageSearchBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList = result.getDrugsSearchVoList();
        if (diseaseSearchVoList != null && diseaseSearchVoList.size() > 0 || doctorSearchVoList != null && doctorSearchVoList.size() > 0 || drugsSearchVoList != null && drugsSearchVoList.size() > 0) {
            rlHomeNoSearch.setVisibility(View.GONE);
            llSearchData.setVisibility(View.VISIBLE);
            llRelevantSearchData.setVisibility(View.GONE);

            //创建适配器
           DiseaseSearchVoListAdapter diseaseSearchVoListAdapter = new DiseaseSearchVoListAdapter(R.layout.layout_home_search_item, diseaseSearchVoList);
            //设置每个item的排列方式
            rvSymptoms.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //设置上适配器
          rvSymptoms.setAdapter(diseaseSearchVoListAdapter);

            //创建适配器
            DoctorSearchVoListAdapter doctorSearchVoListAdapter = new DoctorSearchVoListAdapter(R.layout.layout_home_search_item, doctorSearchVoList);
            //设置每个item的排列方式
            rvDoctor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //设置上适配器
            rvDoctor.setAdapter(doctorSearchVoListAdapter);

            //创建适配器
            DrugsSearchVoListAdapter drugsSearchVoListAdapter = new DrugsSearchVoListAdapter(R.layout.layout_home_search_item, drugsSearchVoList);
            //设置每个item的排列方式
            rvDrug.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            //设置上适配器
            rvDrug.setAdapter(drugsSearchVoListAdapter);
        } else {
            rlHomeNoSearch.setVisibility(View.VISIBLE);
            llSearchData.setVisibility(View.GONE);
            llRelevantSearchData.setVisibility(View.GONE);
            tvNoSearchName.setText(etHomeSearchTitle.getText().toString());
            //llRelevantSearchData,llSearchData,rlHomeNoSearch
        }
    }

    //热门搜索
    @Override
    public void popularSear(PopularSearchBean popularSearchBean) {
        final List<PopularSearchBean.ResultBean> result = popularSearchBean.getResult();


        final List<String> datas = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String name = result.get(i).getName();
            datas.add(name);
        }


    }
    private void search(String keyword) {
        try {
            //添加到流式布局中
            TextView tv = new TextView(this);
            tv.setText(keyword);
            flSearchHistory.addView(tv);
            // 转编码格式
            String UTF8 = URLDecoder.decode(keyword, "UTF-8");
            //请求搜索数据
           mPresenter.homepage(UTF8);
            //添加到历史记录中
            AddHistory();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    private boolean hasData(String trim) {
        // 从数据库中Record表里找到name=tempName的id
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{trim});
        //  判断是否有下一个

        return cursor.moveToNext();
    }
    private void AddHistory() {
        hasData = hasData(etHomeSearchTitle.getText().toString().trim());
        // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
        if (!hasData) {
            insertData(etHomeSearchTitle.getText().toString().trim()); // ->>关注4
            queryData("");
        }

    }
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }
    private void queryData(String tempName) {
        if (!whetherTheQuery) {
            // 1. 模糊搜索
            Cursor cursor = helper.getReadableDatabase().rawQuery(
                    "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                // 2. 创建adapter适配器对象 & 装入模糊搜索的结果
                TextView tv = new TextView(this);
                tv.setPadding(0, 10, 0, 10);
                tv.setText(name);
                flSearchHistory.addView(tv);
                whetherTheQuery = true;
            }

        }
    }

}
