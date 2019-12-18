package com.wd.aclass;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.dueeeke.videoplayer.player.PlayerConfig;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.wd.aclass.adapter.TikTokAdapter;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.presenter.JiangtangPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends BaseActivity<JiangtangPresenter> implements JiangtangContract.Iview {
    private int mCurrentPosition;
    private IjkVideoView mIjkVideoView;
    private TikTokController mTikTokController;
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576477228199&di=6f862283c719e0618c114253de6943c1&imgtype=0&src=http%3A%2F%2F1882.img.pp.sohu.com.cn%2Fimages%2Fblog%2F2011%2F6%2F6%2F21%2F13%2Fu228722099_1311fe6dc51g213.jpg";
    private RecyclerView mPlayer;
    private List<VideoBean.ResultBean> result;
    private TabLayout jiang_tab;
    private FloatingActionButton flot_but;

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected JiangtangPresenter providePresenter() {
        return new JiangtangPresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        jiang_tab =findViewById(R.id.jiang_tab);
        mPresenter.jiangtang();
        mPlayer =  findViewById(R.id.player);
        mPresenter.JiangVideo("435","1576483483773435","1","1","5");
        mIjkVideoView = new IjkVideoView (this);
        PlayerConfig config = new PlayerConfig.Builder().setLooping().build();
        mIjkVideoView.setPlayerConfig(config);
        mTikTokController = new TikTokController(this);
        mIjkVideoView.setVideoController( mTikTokController );
        mPlayer =findViewById(R.id.player);



    }

    @Override
    public void jiangtang(JiangtangBean jiangtangBean) {
        List<JiangtangBean.ResultBean> result = jiangtangBean.getResult();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add(result.get(i).getName());
        }

       /* jiang_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                VideoFragment videoFragment = new VideoFragment();
                return videoFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        jiang_tab.setupWithViewPager(jiang_vp);
        jiang_vp.setOffscreenPageLimit(result.size());*/
    }

    @Override
    public void JiangVideo(VideoBean videoBean) {
        Log.i("videoBean", "JiangVideo: "+videoBean.getMessage());
        result = videoBean.getResult();
        TikTokAdapter tikTokAdapter = new TikTokAdapter(result, this);
        ViewPagerLayoutManager layoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL);

        mPlayer.setLayoutManager( layoutManager );
        mPlayer.setAdapter( tikTokAdapter );

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
            View decorView =  getWindow().getDecorView();

            ViewCompat.requestApplyInsets(decorView);
            getWindow().setStatusBarColor( ContextCompat.getColor(this, android.R.color.transparent));
        }
    }

    private void startPlay(int position) {
        View itemView = mPlayer.getChildAt(0);
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
