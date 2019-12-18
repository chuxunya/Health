package com.wd.aclass.frag;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.wd.aclass.OnViewPagerListener;
import com.wd.aclass.R;
import com.wd.aclass.TikTokController;
import com.wd.aclass.ViewPagerLayoutManager;
import com.wd.aclass.adapter.TikTokAdapter;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;

import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

public class FourFragment extends BaseFragment<JiangtangPresenter> implements JiangtangContract.Iview {
    private int mCurrentPosition;
    private IjkVideoView mIjkVideoView;
    private TikTokController mTikTokController;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private RecyclerView player_four;
    private List<VideoBean.ResultBean> result;



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
        mPresenter.JiangVideo("435","1576651114347435","4","1","5");
        mIjkVideoView = new IjkVideoView(getActivity());
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController(getActivity());
        mIjkVideoView.setVideoController( mTikTokController );

    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {

    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        Log.i("videoBean", "JiangVideo: "+videoBean.getMessage());
        result = videoBean.getResult();
        TikTokAdapter tikTokAdapter = new TikTokAdapter(result, getActivity());
        ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);

        player_four.setLayoutManager( layoutManager );
        player_four.setAdapter( tikTokAdapter );

        layoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onInitComplete() {
                //自动播放第一条
                startPlay(0);
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                if (mCurrentPosition == position) {
                    mIjkVideoView.release();
                }
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                if (mCurrentPosition == position) return;
                startPlay(position);
                mCurrentPosition = position;
            }
        });
    }
    /**
     * 把状态栏设成透明
     */
    private void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = getActivity(). getWindow().getDecorView();

            ViewCompat.requestApplyInsets(decorView);
           getActivity().getWindow().setStatusBarColor( ContextCompat.getColor(getActivity(), android.R.color.transparent));
        }
    }

    private void startPlay(int position) {
        View itemView = player_four.getChildAt(0);
        FrameLayout frameLayout = itemView.findViewById(R.id.container);
        Glide.with(this)
                .load(path)
                .placeholder(android.R.color.black)
                .into(mTikTokController.getThumb());
        ViewParent parent = mIjkVideoView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(mIjkVideoView);
        }
        frameLayout.addView(mIjkVideoView);
        mIjkVideoView.setUrl(result.get ( position ).getOriginalUrl ());
        mIjkVideoView.setScreenScale(IjkVideoView.SCREEN_SCALE_CENTER_CROP);
        mIjkVideoView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mIjkVideoView.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mIjkVideoView.resume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIjkVideoView.release();
    }

    @Override
    public void onFraily(String e) {

    }
}
