package com.wd.aclass.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.bawei.lizekai.mylibrary.base.BaseFragment;

import com.dueeeke.videoplayer.player.IjkVideoView;

import com.wd.aclass.PagerLayoutManager;
import com.wd.aclass.R;
import com.wd.aclass.adapter.VideoAdapter;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.DanmuBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;


import java.util.List;

public class OneFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {

    private List<VideoBean.ResultBean> result;

    private RecyclerView player_one;
    private CheckBox cb_collecte;
    private VideoAdapter videoAdapter;
    private IjkVideoView mVideoView;

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
        mPresenter.JiangVideo( "1","1","10");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        Log.i("videoBean", "JiangVideo: "+videoBean.getMessage());
        List<VideoBean.ResultBean> result = videoBean.getResult();
        PagerLayoutManager mLayoutManager = new PagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
        player_one.setLayoutManager(mLayoutManager);
        videoAdapter = new VideoAdapter(result, getActivity());
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

        mLayoutManager.setOnViewPagerListener(new PagerLayoutManager.OnViewPagerListener() {
            @Override
            public void onInitComplete(View view) {
                playVideo(0, view);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom, View view) {
                playVideo(position, view);
            }

            @Override
            public void onPageRelease(boolean isNext, int position, View view) {
                int index = 0;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(view);
            }
        });
    }

    /**
     * 播放视频
     */
    private void playVideo(int position, View view) {
        if (view != null) {
            mVideoView = view.findViewById(R.id.video_view);
            mVideoView.start();
        }
    }

    /**
     * 停止播放
     */
    private void releaseVideo(View view) {
        if (view != null) {
            IjkVideoView videoView = view.findViewById(R.id.video_view);
            videoView.stopPlayback();
        }
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
    public void Danmu(DanmuBean danmuBean) {

    }

    @Override
    public void onFraily(String e) {

    }
}
