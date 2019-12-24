package com.wd.health.frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.R;
import com.wd.health.adapter.FindUserSickCollectionListAdapter;
import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.contract.AddInfoContract;
import com.wd.health.presenter.AddInfoPresenter;

import java.util.List;

/**
 *@describe(描述)：FindInfoFragment  病友圈
 *@data（日期）: 2019/12/24
 *@time（时间）: 14:57
 *@author（作者）: 张安恒
 **/

public class FindInfoFragment extends BaseFragment<AddInfoPresenter> implements AddInfoContract.Iview {

    private RelativeLayout bingyoukong;
    private RecyclerView circle_recy;
    private ImageView quxiao;
    private List<FindquanBean.ResultBean> result;
    private int userId;
    private String sessionId;
    private int sickCircleId;

    @Override
    protected AddInfoPresenter providePresenter() {
        return new AddInfoPresenter();
    }

    protected int provideLayoutId() {
        return R.layout.fragment_find_info;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.FindQuan("1","5");
    }

    @Override
    protected void initView() {
        super.initView();
        bingyoukong = getActivity().findViewById(R.id.bingyoukong);
        circle_recy = getActivity().findViewById(R.id.circle_recy);
        quxiao = getActivity().findViewById(R.id.quxiao);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        circle_recy.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

    }

    @Override
    public void findvideo(VideoInfoBean videoInfoBean) {

    }

    @Override
    public void deleteinfo(DeInfoBean deInfoBean) {

    }

    @Override
    public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

    }

    //病友圈
    @Override
    public void findquan(FindquanBean findquanBean) {
        if (findquanBean.getResult().size() > 0) {
            List<FindquanBean.ResultBean> result = findquanBean.getResult();
            FindUserSickCollectionListAdapter findUserSickCollectionListAdapter = new FindUserSickCollectionListAdapter(result, getContext());
            circle_recy.setAdapter(findUserSickCollectionListAdapter);

        } else {
            bingyoukong.setVisibility(View.VISIBLE);
        }
    }
}
