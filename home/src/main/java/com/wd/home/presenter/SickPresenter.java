package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.SickContract;
import com.wd.home.model.SickModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor hp
 * @time 2019/12/20 19:31
 */
public class SickPresenter extends BasePresenter<SickContract.Iview> implements SickContract.IPresenter {

    private SickModel sickModel;

    @Override
    protected void initModel() {
        sickModel = new SickModel();
    }

    @Override
    public void sick(int departmentId, int page, int count) {
        sickModel.sick(departmentId, page, count, new SickContract.Imodel.IModelICallBack() {
            @Override
            public void sick(int departmentId, int page, int count, SickCircleListBean sickCircleListBean) {
                getView().sick(sickCircleListBean);
            }
        });
    }
}
