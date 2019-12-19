package com.wd.aclass.frag;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.wd.aclass.R;

import com.wd.aclass.adapter.VideoAdapter;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;


import java.util.List;

public class FiveFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {

    private List<VideoBean.ResultBean> result;

    private RecyclerView player_five;
    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_five;
    }

    @Override
    protected void initData() {
        super.initData();
        player_five = getActivity().findViewById(R.id.player_five);
        mPresenter.JiangVideo("435","1576651114347435","5","1","10");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        List<VideoBean.ResultBean> result = videoBean.getResult();
        VideoAdapter videoAdapter = new VideoAdapter(result, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        player_five.setLayoutManager(linearLayoutManager);
        player_five.setAdapter(videoAdapter);

    }

    @Override
    public void AddVideo(AddVideoBean addVideoBean) {

    }

    @Override
    public void onFraily(String e) {

    }
}
