package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor banner
 * @time 2019/12/13 19:05
 */
public interface BannerContract {


    interface Iview extends IBaseView {
        //轮播图
        void banner(BannerBean bannerBean);
        //问诊咨询
        void department(DepartmentBean departmentBean);
        //查询健康资讯板块
        void information(InformationBean informationBean);
        //根据资讯板块查询资讯列表
        void informationlist(InformationListBean informationListBean);
    }

    interface Imodel {

        //轮播图
        void banner(IModelICallBack iModelICallBack);
        //问诊咨询
        void department(IModelICallBack iModelICallBack);
        //查询健康资讯板块
        void information(IModelICallBack iModelICallBack);
        //根据资讯板块查询资讯列表
        void informationlist(int plateId,int page,int count,IModelICallBack iModelICallBack);

        interface IModelICallBack {
            //轮播图
            void banner(BannerBean bannerBean);
            //问诊咨询
            void department(DepartmentBean departmentBean);
            //查询健康资讯板块
            void information(InformationBean informationBean);
            //根据资讯板块查询资讯列表
            void informationlist(int plateId,int page,int count,InformationListBean informationListBean);
        }
    }

    interface IPresenter {
        void banner();
        void department();
        void information();
        void informationlist(int plateId,int page,int count);
    }
}
