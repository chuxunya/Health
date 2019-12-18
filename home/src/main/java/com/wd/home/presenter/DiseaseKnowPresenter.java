package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.DiseaseknowledgeBean;
import com.wd.home.bean.DrugsknowledgeBean;
import com.wd.home.contract.DiseaseKnowContract;
import com.wd.home.model.DiseaseKnowModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor 查询常见病症详情
 * @time 2019/12/18 19:39
 */
public class DiseaseKnowPresenter extends BasePresenter<DiseaseKnowContract.Iview> implements DiseaseKnowContract.IPresenter {


    private DiseaseKnowModel diseaseKnowModel;

    @Override
    protected void initModel() {
        diseaseKnowModel = new DiseaseKnowModel();
    }

    @Override
    public void diseaseknowledge(String id) {
         diseaseKnowModel.diseaseknowledge(id, new DiseaseKnowContract.Imodel.IModelICallBack() {
             @Override
             public void diseaseknowledge(String id, DiseaseknowledgeBean diseaseknowledgeBean) {
                 getView().diseaseknowledge(diseaseknowledgeBean);
             }

             @Override
             public void drugsknowledge(String id, DrugsknowledgeBean drugsknowledgeBean) {

             }
         });
    }

    @Override
    public void drugsknowledge(String id) {
        diseaseKnowModel.diseaseknowledge(id, new DiseaseKnowContract.Imodel.IModelICallBack() {
            @Override
            public void diseaseknowledge(String id, DiseaseknowledgeBean diseaseknowledgeBean) {

            }

            @Override
            public void drugsknowledge(String id, DrugsknowledgeBean drugsknowledgeBean) {
                  getView().drugsknowledge(drugsknowledgeBean);
            }
        });
    }


}
