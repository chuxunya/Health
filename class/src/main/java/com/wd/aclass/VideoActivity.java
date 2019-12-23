package com.wd.aclass;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.CheckBox;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.DanmuBean;
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


public class VideoActivity extends BaseActivity<JiangtangPresenter> implements JiangtangContract.Iview {


    private List<VideoBean.ResultBean> result;
    private TabLayout jiang_tab;
    private ViewPager video_one;
    private CheckBox drop_down;


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_video;
    }

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        drop_down = findViewById(R.id.drop_down);
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

        drop_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.drop_down:
                        if (drop_down.isChecked()) {
                    float translationY = view.getTranslationY();
                    ObjectAnimator animator = ObjectAnimator.ofFloat(jiang_tab, "translationY", translationY, -120f);
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", translationY, -120f);
                    animator.setDuration(500);
                    animator1.setDuration(500);
                    animator.start();
                    animator1.start();
                } else {
                    float translationY = view.getTranslationY();
                    ObjectAnimator animator = ObjectAnimator.ofFloat(jiang_tab, "translationY", translationY, 0f);
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "translationY", translationY, 0f);
                    animator.setDuration(500);
                    animator1.setDuration(500);
                    animator.start();
                    animator1.start();
               }
                        break;
                }
            }
        });
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
    }

    @Override
    public void AddVideo(AddVideoBean addVideoBean) {

    }

    @Override
    public void BuyVideo(BuyVideoBean buyVideoBean) {

    }

    @Override
    public void Danmu(DanmuBean danmuBean) {

    }

    @Override
    public void onFraily(String e) {

    }

}
