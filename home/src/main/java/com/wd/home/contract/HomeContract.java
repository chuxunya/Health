package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.bean.FindinformatBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor 资讯详情
 * @time 2019/12/18 15:40
 */
public interface HomeContract {

    interface Iview extends IBaseView {
        //资讯详情
        void findformat(FindinformatBean findinformatBean);

    }

    interface Imodel {
        //资讯详情
        void findformat(String infoId, IModelICallBack iModelICallBack);

        interface IModelICallBack {
            //资讯详情
            void findformat(String infoId, FindinformatBean findinformatBean);


        }
    }

    interface IPresenter {

        void findformat(String infoId);

    }
}
