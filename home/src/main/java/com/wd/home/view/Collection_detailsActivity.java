package com.wd.home.view;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;
import com.wd.home.R;
import com.wd.home.adapter.PageAdapter;
import com.wd.home.fragment.Drug_Fragment;
import com.wd.home.fragment.Illness_Fragment;

import java.util.ArrayList;

/**
 * @name Health
 * @class name：com.wd.home.view
 * @anthor hp
 * @time 2019/12/18 13:52
 *
 */
public class Collection_detailsActivity extends BaseActivity {

    private TabLayout details_tab;
    private ViewPager details_vp;
    private ArrayList<Fragment> list;
    private RadioButton details_btn1;
    private RadioButton details_btn2;
    private RadioGroup details_rg;
    private ImageView collection_activity_iv_headPic;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_collection_details;
    }

    @Override
    protected void initView() {
        super.initView();

        details_vp = findViewById(R.id.details_vp);
        details_btn1 =  findViewById(R.id.details_btn1);
        details_btn2 =  findViewById(R.id.details_btn2);
        details_rg =  findViewById(R.id.details_rg);
        collection_activity_iv_headPic =  findViewById(R.id.collection_activity_iv_headPic);

        list = new ArrayList<>();
        list.add(new Drug_Fragment());
        list.add(new Illness_Fragment());
        details_btn1.setTextColor(Color.BLUE);
        details_btn2.setTextColor(Color.GRAY);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), list);
        details_vp.setAdapter(pageAdapter);
        details_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        details_rg.check(R.id.details_btn1);
                        details_btn1.setTextColor(Color.BLUE);
                        details_btn2.setTextColor(Color.GRAY);
                        break;
                    case 1:
                        details_rg.check(R.id.details_btn2);
                        details_btn1.setTextColor(Color.GRAY);
                        details_btn2.setTextColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        details_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.details_btn1) {
                    details_vp.setCurrentItem(0);
                }else if (checkedId == R.id.details_btn2){
                    details_vp.setCurrentItem(1);
                }
            }
        });

    }
}
