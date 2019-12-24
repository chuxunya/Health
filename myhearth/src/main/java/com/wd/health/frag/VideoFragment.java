package com.wd.health.frag;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.R;
import com.wd.health.adapter.VideoVoListAdapter;
import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.contract.AddInfoContract;
import com.wd.health.presenter.AddInfoPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/**
 *@describe(描述)：VideoFragment  健康视频
 *@data（日期）: 2019/12/24
 *@time（时间）: 13:36
 *@author（作者）: 张安恒
 **/

public class VideoFragment extends BaseFragment<AddInfoPresenter> implements AddInfoContract.Iview {

    private int userId;
    private String sessionId;
    private RelativeLayout videokong;
    private RecyclerView video_recy;
    private List<VideoInfoBean.ResultBean> result;

    @Override
    protected AddInfoPresenter providePresenter() {
        return new AddInfoPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_video_info;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.FindVideo("1","5");
    }

    @Override
    protected void initView() {
        super.initView();
        videokong = getActivity().findViewById(R.id.videokong);
        video_recy = getActivity().findViewById(R.id.video_recy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        video_recy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

    }

    @Override
    public void findvideo(VideoInfoBean videoInfoBean) {
        Log.i("xvideoInfoBean", "findvideo: "+videoInfoBean.getMessage());
        List<VideoInfoBean.ResultBean> result = videoInfoBean.getResult();
        if (videoInfoBean.getResult().size()>0){
            VideoVoListAdapter videoVoListAdapter=new VideoVoListAdapter(result,getContext());
            video_recy.setAdapter(videoVoListAdapter);

            videoVoListAdapter.onItemClickListener(new VideoVoListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    int videoId = result.get(position).getVideoId();
                    mPresenter.DeleVideo(videoId+"");
                }
            });
        }else {
            videokong.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void deleteinfo(DeInfoBean deInfoBean) {

    }

    //删除视频
    @Override
    public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {
        if (deleVideoInfoBean.getStatus().equals("0000")){
            Toast.makeText(getContext(), deleVideoInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
            mPresenter.FindVideo("1","5");
        }else {
            Toast.makeText(getContext(), deleVideoInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
        }

    @Override
    public void findquan(FindquanBean findquanBean) {

    }
}
