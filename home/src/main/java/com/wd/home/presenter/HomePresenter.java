package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.bean.FindinformatBean;
import com.wd.home.contract.DrugsContract;
import com.wd.home.contract.HomeContract;
import com.wd.home.model.DrugsModel;
import com.wd.home.model.HomeModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor 资讯详情
 * @time 2019/12/18 19:06
 */
public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.IPresenter {


    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }


    @Override
    public void findformat(String infoId) {
        homeModel.findformat(infoId, new HomeContract.Imodel.IModelICallBack() {
            @Override
            public void findformat(String infoId, FindinformatBean findinformatBean) {
                getView().findformat(findinformatBean);
            }
        });
    }
}
