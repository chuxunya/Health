package com.wd.aclass.frag;

import android.util.Log;

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

public class FourFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {

    private List<VideoBean.ResultBean> result;

    private RecyclerView player_four;
    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_four;
    }

    @Override
    protected void initData() {
        super.initData();
        player_four = getActivity().findViewById(R.id.player_four);
        mPresenter.JiangVideo( "4","1","10");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        List<VideoBean.ResultBean> result = videoBean.getResult();
        VideoAdapter videoAdapter = new VideoAdapter(result, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        player_four.setLayoutManager(linearLayoutManager);
        player_four.setAdapter(videoAdapter);
        //点击购买
        videoAdapter.setSetOnClickListent(new VideoAdapter.SetOnClickListent() {
            @Override
            public void onCallBank(int id) {
                Log.i("wodeship", "onCallBank: "+id);
                mPresenter.BuyVideo( id+"","100");
            }
        });
        //回调收藏
        videoAdapter.setSetAddListen(new VideoAdapter.SetAddListen() {
            @Override
            public void onAddCallBack(int id) {
                mPresenter.AddVideo( id+"");
            }
        });
    }

    @Override
    public void AddVideo(AddVideoBean addVideoBean) {

    }

    @Override
    public void BuyVideo(BuyVideoBean buyVideoBean) {

    }

    @Override
    public void onFraily(String e) {

    }
}
