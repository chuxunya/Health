package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor hp
 * @time 2019/12/18 15:40
 */
public interface DrugsContract {

    interface Iview extends IBaseView {
        //药品科目分类列表查询
        void drugscate(DrugsBean drugsBean);
        //根据药品类目查询常见药品
        void drugscateknow(DrugsKnowBean drugsKnowBean);
    }

    interface Imodel {
        //药品科目分类列表查询
        void drugscate(IModelICallBack iModelICallBack);
        //根据药品类目查询常见药品
        void drugscateknow(int drugsCategoryId,int page,int count,IModelICallBack iModelICallBack);

        interface IModelICallBack {
            //药品科目分类列表查询
            void drugscate(DrugsBean drugsBean);
            //根据药品类目查询常见药品
            void drugscateknow(int drugsCategoryId,int page,int count,DrugsKnowBean drugsKnowBean);

        }
    }

    interface IPresenter {
        void drugscate();
        void drugscateknow(int drugsCategoryId,int page,int count);

    }
}
