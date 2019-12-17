package com.wd.chat.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;
import com.wd.chat.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import butterknife.BindView;

/**
 * @describe(描述)：SickFrag
 * @data（日期）: 2019/12/16
 * @time（时间）: 8:52
 * @author（作者）: xin
 **/
public class SickFrag extends BaseFragment {

    @BindView(R.id.tablayout)
    TabLayout tab;
    @BindView(R.id.pager)
    NoScrollViewPager pager;

    private ArrayList<String> list;
    private ArrayList<Fragment> list1;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.sick_frag;
    }

    @Override
    protected void initView() {
        super.initView();
        list = new ArrayList<>();
        list.add("综合");
        list.add("好评");
        list.add("咨询数");
        list.add("价格");
        list1 = new ArrayList<>();
        list1.add(new SynthesisFrag());
        list1.add(new GoodFrag());
        list1.add(new ConsultationNumberFrag());
        list1.add(new PriceFrag());

        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list1.get(position);
            }

            @Override
            public int getCount() {
                return list1.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tab.setupWithViewPager(pager);

    }

    @Override
    protected void initData() {
        super.initData();
        Bundle arguments = getArguments();
        int departmentId = arguments.getInt("departmentId");
        SharedPreferences sp = getActivity().getSharedPreferences("departmentId", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("id",departmentId).commit();
    }
}
