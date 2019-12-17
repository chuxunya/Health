package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.model.BannerModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor banner
 * @time 2019/12/13 19:06
 */
public class BannerPresenter extends BasePresenter<BannerContract.Iview> implements BannerContract.IPresenter {


    private BannerModel bannerModel;

    @Override
    protected void initModel() {
        bannerModel = new BannerModel();
    }

    //轮播图
    @Override
    public void banner() {
        bannerModel.department(new BannerContract.Imodel.IModelICallBack() {
            @Override
            public void banner(BannerBean bannerBean) {
                getView().banner(bannerBean);
            }

            @Override
            public void department(DepartmentBean departmentBean) {

            }

            @Override
            public void information(InformationBean informationBean) {

            }

            @Override
            public void informationlist(int plateId, int page, int count, InformationListBean informationListBean) {

            }
        }) ;
    }

    // //问诊咨询
    @Override
    public void department() {
       bannerModel.department(new BannerContract.Imodel.IModelICallBack() {
           @Override
           public void banner(BannerBean bannerBean) {

           }

           @Override
           public void department(DepartmentBean departmentBean) {
               getView().department(departmentBean);
           }

           @Override
           public void information(InformationBean informationBean) {

           }

           @Override
           public void informationlist(int plateId, int page, int count, InformationListBean informationListBean) {

           }
       });
    }
    //查询健康资讯板块
    @Override
    public void information() {
        bannerModel.information(new BannerContract.Imodel.IModelICallBack() {
            @Override
            public void banner(BannerBean bannerBean) {

            }

            @Override
            public void department(DepartmentBean departmentBean) {

            }

            @Override
            public void information(InformationBean informationBean) {
                     getView().information(informationBean);
            }

            @Override
            public void informationlist(int plateId, int page, int count, InformationListBean informationListBean) {

            }
        });
    }

    //根据资讯板块查询资讯列表
    @Override
    public void informationlist(int plateId, int page, int count) {
        bannerModel.informationlist(plateId, page, count, new BannerContract.Imodel.IModelICallBack() {
            @Override
            public void banner(BannerBean bannerBean) {

            }

            @Override
            public void department(DepartmentBean departmentBean) {

            }

            @Override
            public void information(InformationBean informationBean) {

            }

            @Override
            public void informationlist(int plateId, int page, int count, InformationListBean informationListBean) {
                getView().informationlist(informationListBean);
            }
        });
    }




}
