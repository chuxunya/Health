package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.DrugsKnowBean;
import com.wd.home.contract.DiseaseContract;
import com.wd.home.contract.DrugsContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/18 14:33
 */
public class DrugsModel implements DrugsContract.Imodel {


    @Override
    public void drugscate(IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .drugscate()
                .compose(CommonSchedulers.<DrugsBean>io2main())
                .subscribe(new Observer<DrugsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrugsBean drugsBean) {
                         iModelICallBack.drugscate(drugsBean);
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
    public void drugscateknow(int drugsCategoryId, int page, int count, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .drugscateknow(drugsCategoryId,page,count)
                .compose(CommonSchedulers.<DrugsKnowBean>io2main())
                .subscribe(new Observer<DrugsKnowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DrugsKnowBean drugsKnowBean) {
                     iModelICallBack.drugscateknow(drugsCategoryId,page,count,drugsKnowBean);
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
