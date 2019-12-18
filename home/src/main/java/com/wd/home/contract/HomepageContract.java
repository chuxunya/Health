package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.PopularSearchBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor 首页搜索
 * @time 2019/12/16 16:23
 */
public interface HomepageContract {

    interface Iview extends IBaseView {
        //首页搜索
        void homepage(HomePageSearchBean homePageSearchBean);
       //热门搜索
       void popularSear(PopularSearchBean popularSearchBean);
    }

    interface Imodel {

        //首页搜索
        void homepage(String keyWord,IModelICallBack iModelICallBack);
        //热门搜索
        void popularSear(IModelICallBack iModelICallBack);

        interface IModelICallBack {
            //首页搜索
            void homepage(String keyWord,HomePageSearchBean homePageSearchBean);
            //热门搜索
            void popularSear(PopularSearchBean popularSearchBean);
        }
    }

    interface IPresenter {
        void homepage(String keyWord);
        void popularsear();
    }
}
