package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.contract.DiseaseContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/18 14:33
 */
public class DiseaseModel implements DiseaseContract.Imodel {

    //查询科室
    @Override
    public void depart(final IModelICallBack iModelICallBack) {
         RetrofitManager.getInstance().create(MyApp.class)
                 .department()
                 .compose(CommonSchedulers.<DepartmentBean>io2main())
                 .subscribe(new Observer<DepartmentBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(DepartmentBean departmentBean) {
                            iModelICallBack.depart(departmentBean);
                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onComplete() {

                     }
                 });

    }

    //根据科室查询对应病症
    @Override
    public void disease(int departmentId,final IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .disease(departmentId)
                .compose(CommonSchedulers.<DiseaseBean>io2main())
                .subscribe(new Observer<DiseaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiseaseBean diseaseBean) {
                           iModelICallBack.disease(departmentId,diseaseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



}
