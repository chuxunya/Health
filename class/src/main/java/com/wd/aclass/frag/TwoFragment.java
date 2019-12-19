package com.wd.aclass.frag;

import android.util.Log;

import com.bawei.lizekai.mylibrary.base.BaseFragment;

import com.wd.aclass.R;


import com.wd.aclass.adapter.VideoAdapter;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;


import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TwoFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {


    private List<VideoBean.ResultBean> result;
    private RecyclerView player_two;

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initData() {
        super.initData();
        player_two = getActivity().findViewById(R.id.player_two);
        mPresenter.JiangVideo("435","1576651114347435","2","1","5");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        Log.i("videoBean", "JiangVideo: " + videoBean.getMessage());
        result = videoBean.getResult();
        VideoAdapter videoAdapter = new VideoAdapter(result, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        player_two.setLayoutManager(linearLayoutManager);
        player_two.setAdapter(videoAdapter);
    }

    @Override
    public void onFraily(String e) {

    }
}
