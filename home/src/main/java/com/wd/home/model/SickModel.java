package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.contract.SickContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/20 19:29
 */
public class SickModel implements SickContract.Imodel {
    @Override
    public void sick(int departmentId, int page, int count, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .sickCircleList(departmentId,page,count)
                .compose(CommonSchedulers.<SickCircleListBean>io2main())
                .subscribe(new Observer<SickCircleListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SickCircleListBean sickCircleListBean) {
                        iModelICallBack.sick(departmentId,page,count,sickCircleListBean);
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
