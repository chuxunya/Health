package com.wd.aclass.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
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
    private  int one=1;
    private VideoAdapter videoAdapter;

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
        mPresenter.JiangVideo( "1","1","5");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        List<VideoBean.ResultBean> result = videoBean.getResult();
        videoAdapter = new VideoAdapter(result, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        player_one.setLayoutManager(linearLayoutManager);
        player_one.setAdapter(videoAdapter);
        //点击购买
        videoAdapter.setSetOnClickListent(new VideoAdapter.SetOnClickListent() {
            @Override
            public void onCallBank(int id) {
                Log.i("goumai", "onCallBank: "+id);
                mPresenter.BuyVideo(   id+"","100");
            }
        });
        //回调收藏
        videoAdapter.setSetAddListen(new VideoAdapter.SetAddListen() {
            @Override
            public void onAddCallBack(int id) {
                Log.i("tAddListen", "onAddCallBack: "+id);
                mPresenter.AddVideo( id+"");
            }
        });
    }

    //收藏
    @Override
    public void AddVideo(AddVideoBean addVideoBean) {
        Log.i("xxx", "AddVideo: "+addVideoBean.getMessage());
        if (addVideoBean.getStatus().equals("0000")){
            cb_collecte.setBackgroundResource(R.drawable.video_common_button_collection_small_s);
        }
    }

    //购买
    @Override
    public void BuyVideo(BuyVideoBean buyVideoBean) {
        Log.i("buyVideoBean", "BuyVideo: "+buyVideoBean.getMessage());
    }

    @Override
    public void onFraily(String e) {

    }
}
