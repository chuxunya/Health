package com.wd.home.view;


import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.lizekai.mylibrary.base.BaseActivity;

import com.wd.home.R;
import com.wd.home.adapter.PageAdapter;

import com.wd.home.api.NoScrollViewPager;
import com.wd.home.fragment.HomeFragment;
import com.wd.home.fragment.PatientcircleFragment;
import com.wd.home.fragment.SmallvideoFragment;
import com.wd.home.presenter.BannerPresenter;


import java.util.ArrayList;

/*
* fragment
* 席贵
* */
@Route(path = "/home/view/HomeActivity")
public class HomeActivity extends BaseActivity {

    @Autowired(name = "age")
    public int age;
    @Autowired(name = "weight")
    public int weight;
    @Autowired(name = "height")
    public int height;
    @Autowired(name = "userId")
    public int userId;
    @Autowired(name = "sex")
    public int sex;
    @Autowired(name = "sessionId")
    public String sessionId;
    @Autowired(name = "userName")
    public String userName;
    @Autowired(name = "jiGuangPwd")
    public String jiGuangPwd;
    @Autowired(name = "nickName")
    public String nickName;
    @Autowired(name = "email")
    public String email;
    @Autowired(name = "headPic")
    public String headPic;

    private ArrayList<Fragment> list;
    private PageAdapter pageAdapter;
    private NoScrollViewPager home_vp;
    private RadioGroup home_rg;


    @Override
    protected BannerPresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home;

    }

    @Override
    protected void initView() {
        super.initView();
        //获取资源ID
        home_vp = findViewById(R.id.home_vp);
        home_rg = findViewById(R.id.home_rg);


        //创建fragment集合
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new PatientcircleFragment());
        list.add(new SmallvideoFragment());

        //viewpager适配器
        pageAdapter = new PageAdapter(getSupportFragmentManager(),list);
        home_vp.setAdapter(pageAdapter);

    }

    @Override
    protected void initData() {
        super.initData();
        home_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        home_rg.check(R.id.home);
                        break;
                    case 1:
                        home_rg.check(R.id.patientcircle);
                        break;
                    case 2:
                        home_rg.check(R.id.smallvideo);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        home_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.home) {
                    home_vp.setCurrentItem(0);
                }else if (checkedId == R.id.patientcircle){
                    home_vp.setCurrentItem(1);
                }
                else if (checkedId == R.id.smallvideo){
                    home_vp.setCurrentItem(2);
                }
            }
        });

    }
}
