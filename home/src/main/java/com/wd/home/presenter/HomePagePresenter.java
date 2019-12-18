package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.PopularSearchBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.HomepageContract;
import com.wd.home.model.HomePageModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor hp
 * @time 2019/12/16 16:34
 */
public class HomePagePresenter extends BasePresenter<HomepageContract.Iview> implements HomepageContract.IPresenter {


    private HomePageModel homePageModel;

    @Override
    protected void initModel() {
        homePageModel = new HomePageModel();
    }

    @Override
    public void homepage(String keyWord) {
         homePageModel.homepage(keyWord, new HomepageContract.Imodel.IModelICallBack() {
             @Override
             public void homepage(String keyWord, HomePageSearchBean homePageSearchBean) {
                 getView().homepage(homePageSearchBean);
             }

             @Override
             public void popularSear(PopularSearchBean popularSearchBean) {

             }
         });
    }

    //热门搜索
    @Override
    public void popularsear() {
        homePageModel.popularSear(new HomepageContract.Imodel.IModelICallBack() {
            @Override
            public void homepage(String keyWord, HomePageSearchBean homePageSearchBean) {

            }

            @Override
            public void popularSear(PopularSearchBean popularSearchBean) {
                  getView().popularSear(popularSearchBean);
            }
        });
    }
}
