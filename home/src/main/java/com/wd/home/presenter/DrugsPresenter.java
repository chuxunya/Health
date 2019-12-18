package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.DrugsContract;
import com.wd.home.model.BannerModel;
import com.wd.home.model.DrugsModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor banner
 * @time 2019/12/13 19:06
 */
public class DrugsPresenter extends BasePresenter<DrugsContract.Iview> implements DrugsContract.IPresenter {


    private DrugsModel drugsModel;

    @Override
    protected void initModel() {
        drugsModel = new DrugsModel();
    }

    @Override
    public void drugscate() {
        drugsModel.drugscate(new DrugsContract.Imodel.IModelICallBack() {
            @Override
            public void drugscate(DrugsBean drugsBean) {
                getView().drugscate(drugsBean);
            }

            @Override
            public void drugscateknow(int drugsCategoryId, int page, int count, DrugsKnowBean drugsKnowBean) {

            }
        });
    }

    @Override
    public void drugscateknow(int drugsCategoryId, int page, int count) {
        drugsModel.drugscateknow(drugsCategoryId, page, count, new DrugsContract.Imodel.IModelICallBack() {
            @Override
            public void drugscate(DrugsBean drugsBean) {

            }

            @Override
            public void drugscateknow(int drugsCategoryId, int page, int count, DrugsKnowBean drugsKnowBean) {
                 getView().drugscateknow(drugsKnowBean);
            }
        });
    }
}
