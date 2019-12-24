package com.wd.health.frag;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseFragment;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.R;
import com.wd.health.adapter.AdvisoryAdapter;
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
 *@describe(描述)：CircleFragment  健康咨询
 *@data（日期）: 2019/12/24
 *@time（时间）: 10:43
 *@author（作者）: 张安恒
 **/

public class CircleFragment extends BaseFragment <AddInfoPresenter> implements AddInfoContract.Iview {
    private RecyclerView advisory_recy;
    private ImageView quxiao;
    private RelativeLayout zixunkong;
    private List<AddInfoCollectBean.ResultBean> result;
    private int userId;
    private String sessionId;
    private int infoId;
    private AdvisoryAdapter advisoryAdapter;

    @Override
    protected AddInfoPresenter providePresenter() {
        return new AddInfoPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_circle_info;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.AddInfoCollect("1","5");
    }

    @Override
    protected void initView() {
        super.initView();
        advisory_recy = getActivity().findViewById(R.id.advisory_recy);
        quxiao = getActivity().findViewById(R.id.quxiao);
        zixunkong = getActivity().findViewById(R.id.zixunkong);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        advisory_recy.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {
        Log.i("xaddInfoCollectBean", "addinfocollect: "+addInfoCollectBean.getMessage());
         result = addInfoCollectBean.getResult();
        if (addInfoCollectBean.getResult().size()>0){
            advisoryAdapter = new AdvisoryAdapter(result,getActivity());
        advisory_recy.setAdapter(advisoryAdapter);

        advisoryAdapter.onItemClickListener(new AdvisoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "点击了条目", Toast.LENGTH_SHORT).show();
                infoId = result.get(position).getInfoId();
                mPresenter.DeleInfo(infoId+"");
                advisoryAdapter.notifyDataSetChanged();
            }
        });
    }else {
        zixunkong.setVisibility(View.VISIBLE);
    }

}

    @Override
    public void findvideo(VideoInfoBean videoInfoBean) {

    }

    @Override
    public void deleteinfo(DeInfoBean deInfoBean) {
        if (deInfoBean.getStatus().equals("0000")){
            Toast.makeText(getActivity(), deInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
            mPresenter.AddInfoCollect("1","5");

        }else {
            Toast.makeText(getActivity(), deInfoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

    }

    @Override
    public void findquan(FindquanBean findquanBean) {

    }
}
