package com.wd.aclass;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.frag.FiveFragment;
import com.wd.aclass.frag.FourFragment;
import com.wd.aclass.frag.OneFragment;
import com.wd.aclass.frag.SexFragment;
import com.wd.aclass.frag.ThreeFragment;
import com.wd.aclass.frag.TwoFragment;
import com.wd.aclass.presenter.JiangtangPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends BaseActivity<JiangtangPresenter> implements JiangtangContract.Iview {


    private List<VideoBean.ResultBean> result;
    private TabLayout jiang_tab;
    private ViewPager video_one;



    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        video_one = findViewById(R.id.video_vp);
        jiang_tab = findViewById(R.id.jiang_tab);
        List<Fragment> fraglist=new ArrayList<>();
        fraglist.add(new OneFragment());
        fraglist.add(new TwoFragment());
        fraglist.add(new ThreeFragment());
        fraglist.add(new FourFragment());
        fraglist.add(new FiveFragment());
        fraglist.add(new SexFragment());

        List<String> list=new ArrayList<>();
        list.add("儿科");
        list.add("常识");
        list.add("健身");
        list.add("美容");
        list.add("心理");
        list.add("养生");

        video_one.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fraglist.get(position);
            }

            @Override
            public int getCount() {
                return fraglist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        jiang_tab.setupWithViewPager(video_one);

    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
    }

    @Override
    public void onFraily(String e) {

    }

}
