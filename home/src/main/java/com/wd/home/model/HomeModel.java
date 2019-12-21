package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.FindinformatBean;
import com.wd.home.contract.DrugsContract;
import com.wd.home.contract.HomeContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/18 14:09
 */
public class HomeModel implements HomeContract.Imodel{


    @Override
    public void findformat(String infoId, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .findinformation(infoId)
                .compose(CommonSchedulers.<FindinformatBean>io2main())
                .subscribe(new Observer<FindinformatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FindinformatBean findinformatBean) {
                        iModelICallBack.findformat(infoId,findinformatBean);
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
