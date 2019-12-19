package com.wd.aclass.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

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

public class OneFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {

    private List<VideoBean.ResultBean> result;

    private RecyclerView player_one;
    private CheckBox cb_collecte;

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initData() {
        super.initData();
        cb_collecte = getActivity().findViewById(R.id.cb_collecte);
        player_one = getActivity().findViewById(R.id.player_one);
        mPresenter.JiangVideo("435","1576651114347435","1","1","10");
        mPresenter.AddVideo("435","1576651114347435","1");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        List<VideoBean.ResultBean> result = videoBean.getResult();

        VideoAdapter videoAdapter = new VideoAdapter(result, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        player_one.setLayoutManager(linearLayoutManager);
        player_one.setAdapter(videoAdapter);

    }

    @Override
    public void AddVideo(AddVideoBean addVideoBean) {
        String status1 = addVideoBean.getMessage();

    }

    @Override
    public void onFraily(String e) {

    }
}
