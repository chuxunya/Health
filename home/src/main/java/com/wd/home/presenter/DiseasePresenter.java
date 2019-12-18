package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.DiseaseContract;
import com.wd.home.model.DiseaseModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor hp
 * @time 2019/12/18 14:37
 */
public class DiseasePresenter extends BasePresenter<DiseaseContract.Iview> implements DiseaseContract.IPresenter {


    private DiseaseModel diseaseModel;

    @Override
    protected void initModel() {
        diseaseModel = new DiseaseModel();
    }


    //查询科室列表
    @Override
    public void depart() {
         diseaseModel.depart(new DiseaseContract.Imodel.IModelICallBack() {
             @Override
             public void depart(DepartmentBean departmentBean) {
                 getView().depart(departmentBean);
             }

             @Override
             public void disease(int departmentId, DiseaseBean diseaseBean) {

             }
         });
    }


    // 根据科室查询对应病症
    @Override
    public void disease(int departmentId) {
        diseaseModel.disease(departmentId, new DiseaseContract.Imodel.IModelICallBack() {
            @Override
            public void depart(DepartmentBean departmentBean) {

            }

            @Override
            public void disease(int departmentId, DiseaseBean diseaseBean) {
                     getView().disease(diseaseBean);
            }
        });
    }


}
