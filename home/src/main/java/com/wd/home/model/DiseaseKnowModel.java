package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseknowledgeBean;
import com.wd.home.bean.DrugsknowledgeBean;
import com.wd.home.contract.DiseaseKnowContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor 查询常见病症详情
 * @time 2019/12/18 19:37
 */
public class DiseaseKnowModel implements DiseaseKnowContract.Imodel {


    @Override
    public void diseaseknowledge(String id, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .diseaseknowledge(id)
                .compose(CommonSchedulers.<DiseaseknowledgeBean>io2main())
                .subscribe(new Observer<DiseaseknowledgeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiseaseknowledgeBean diseaseknowledgeBean) {
                       iModelICallBack.diseaseknowledge(id,diseaseknowledgeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void drugsknowledge(String id, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .drugsknowledge(id)
                .compose(CommonSchedulers.<DrugsknowledgeBean>io2main())
                .subscribe(new Observer<DrugsknowledgeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrugsknowledgeBean drugsknowledgeBean) {
                        iModelICallBack.drugsknowledge(id,drugsknowledgeBean);
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
