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
import com.wd.aclass.bean.BuyVideoBean;
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
        mPresenter.JiangVideo("435","1576748581521435","1","1","10");
        mPresenter.AddVideo("435","1576748581521435","1");
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
        //点击购买
        videoAdapter.setSetOnClickListent(new VideoAdapter.SetOnClickListent() {
            @Override
            public void onCallBank(int id) {
                Log.i("wodeship", "onCallBank: "+id);
                mPresenter.BuyVideo("435","1576748581521435",id+"","100");
            }
        });
    }

    //收藏
    @Override
    public void AddVideo(AddVideoBean addVideoBean) {

    }

    //购买
    @Override
    public void BuyVideo(BuyVideoBean buyVideoBean) {
        String message = buyVideoBean.getMessage();
        Log.i("message", "BuyVideo: "+message);


    }

    @Override
    public void onFraily(String e) {

    }
}
