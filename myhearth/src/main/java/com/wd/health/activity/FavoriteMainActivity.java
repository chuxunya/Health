package com.wd.health.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.wd.health.R;
import com.wd.health.adapter.PageAdapter;
import com.wd.health.frag.CircleFragment;
import com.wd.health.frag.FindInfoFragment;
import com.wd.health.frag.VideoFragment;

import java.util.ArrayList;

/**
 *@describe(描述)：FavoriteMainActivity  我的收藏
 *@data（日期）: 2019/12/24
 *@time（时间）: 9:44
 *@author（作者）: 张安恒
 **/
public class FavoriteMainActivity extends AppCompatActivity {
    private TabLayout favorite_tab;
    private ViewPager favorite_vp;
    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_main);
        favorite_tab = (TabLayout) findViewById(R.id.favorite_tab);
        favorite_vp = (ViewPager) findViewById(R.id.favorite_vp);


        list = new ArrayList<>();
        list.add(new FindInfoFragment());
        list.add(new VideoFragment());
        list.add(new CircleFragment());

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), list);
        favorite_vp.setAdapter(pageAdapter);

        favorite_tab.setupWithViewPager(favorite_vp);
        favorite_tab.getTabAt(0).setText("病友圈");
        favorite_tab.getTabAt(1).setText("健康视频");
        favorite_tab.getTabAt(2).setText("健康咨询");
    }
}
