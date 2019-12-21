package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.SickCircleListBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor hp
 * @time 2019/12/20 19:26
 */
public interface SickContract {


    interface Iview extends IBaseView {

        //病友圈列表展示
        void sick(SickCircleListBean sickCircleListBean);

    }

    interface Imodel {


        //病友圈列表展示
        void sick(int departmentId,int page,int count,IModelICallBack iModelICallBack);


        interface IModelICallBack {

            //病友圈列表展示
            void sick(int departmentId, int page, int count, SickCircleListBean sickCircleListBean);

        }
    }

    interface IPresenter {

        void sick(int departmentId,int page,int count);

    }
}
