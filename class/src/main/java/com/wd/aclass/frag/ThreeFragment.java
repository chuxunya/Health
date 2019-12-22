package com.wd.aclass.frag;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.wd.aclass.PagerLayoutManager;
import com.wd.aclass.R;

import com.wd.aclass.adapter.VideoAdapter;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;


import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ThreeFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {

    private CheckBox cb_collecte;
    private VideoAdapter videoAdapter;
    private IjkVideoView mVideoView;
    private List<VideoBean.ResultBean> result;
    private RecyclerView player_three;

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    protected void initData() {
        super.initData();
        player_three = getActivity().findViewById(R.id.player_three);
        mPresenter.JiangVideo( "3","1","5");
    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        List<VideoBean.ResultBean> result = videoBean.getResult();
        PagerLayoutManager mLayoutManager = new PagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
        player_three.setLayoutManager(mLayoutManager);
        videoAdapter = new VideoAdapter(result, getActivity());
        player_three.setAdapter(videoAdapter);
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
