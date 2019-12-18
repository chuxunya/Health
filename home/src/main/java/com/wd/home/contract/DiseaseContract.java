package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.PopularSearchBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor 科室查询病症
 * @time 2019/12/18 14:28
 */
public interface DiseaseContract {

    interface Iview extends IBaseView {
        //查询科室列表
        void depart(DepartmentBean departmentBean);
        //根据科室查询对应病症
        void disease(DiseaseBean diseaseBean);
    }

    interface Imodel {
        //查询科室列表
        void depart(IModelICallBack iModelICallBack);
        //根据科室查询对应病症
        void disease(int departmentId,IModelICallBack iModelICallBack);


        interface IModelICallBack {
            //查询科室列表
            void depart(DepartmentBean departmentBean);
            //根据科室查询对应病症
            void disease(int departmentId,DiseaseBean diseaseBean);

        }
    }

    interface IPresenter {
        void depart();
        void disease(int departmentId);

    }
}
