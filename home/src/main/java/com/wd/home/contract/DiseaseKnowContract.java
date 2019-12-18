package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.DiseaseknowledgeBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.bean.DrugsknowledgeBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor  查询常见病症详情
 * @time 2019/12/18 19:34
 */
public interface DiseaseKnowContract {

    interface Iview extends IBaseView {
        //查询常见病症详情
        void diseaseknowledge(DiseaseknowledgeBean diseaseknowledgeBean);
        //查询常见药品详情
        void drugsknowledge(DrugsknowledgeBean drugsknowledgeBean);

    }

    interface Imodel {
        //查询常见病症详情
        void diseaseknowledge(String  id,IModelICallBack iModelICallBack);
        //查询常见药品详情
        void drugsknowledge(String id, IModelICallBack iModelICallBack);

        interface IModelICallBack {
            //查询常见病症详情
            void diseaseknowledge(String id,DiseaseknowledgeBean diseaseknowledgeBean);
            //查询常见药品详情
            void drugsknowledge(String id, DrugsknowledgeBean drugsknowledgeBean);

        }
    }

    interface IPresenter {

        void diseaseknowledge(String id);
        void drugsknowledge(String id);

    }
}
