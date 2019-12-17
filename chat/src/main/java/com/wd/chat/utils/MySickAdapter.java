package com.wd.chat.utils;

import android.os.Bundle;

import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.view.SickFrag;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
/**
 *@describe(描述)：MySickAdapter
 *@data（日期）: 2019/12/16
 *@time（时间）: 8:52
 *@author（作者）: xin
 **/
public class MySickAdapter extends FragmentPagerAdapter {


    ArrayList<String> tab;
    List<FindDepartmentBean.ResultBean> result;
    public MySickAdapter(@NonNull FragmentManager fm,ArrayList<String> tab, List<FindDepartmentBean.ResultBean> result) {
        super(fm);
        this.tab=tab;
        this.result=result;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("departmentId",result.get(position).getId());
        SickFrag sickFrag = new SickFrag();
        sickFrag.setArguments(bundle);
        return sickFrag;
    }


    @Override
    public int getCount() {
        return tab.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }
}
