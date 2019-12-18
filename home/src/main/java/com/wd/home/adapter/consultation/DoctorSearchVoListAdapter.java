package com.wd.home.adapter.consultation;



import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.home.R;
import com.wd.home.bean.HomePageSearchBean;

import java.util.List;



public class DoctorSearchVoListAdapter extends BaseQuickAdapter<HomePageSearchBean.ResultBean.DoctorSearchVoListBean, BaseViewHolder> {


    public DoctorSearchVoListAdapter(int layoutResId,  List<HomePageSearchBean.ResultBean.DoctorSearchVoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomePageSearchBean.ResultBean.DoctorSearchVoListBean item) {
        helper.setText(R.id.tv_home_search_name, item.getDoctorName());
    }
}
