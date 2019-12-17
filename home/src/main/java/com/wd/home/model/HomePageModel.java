package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.PopularSearchBean;
import com.wd.home.contract.HomepageContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor 首页搜索
 * @time 2019/12/16 16:31
 */
public class HomePageModel implements HomepageContract.Imodel {

    //首页搜索
    @Override
    public void homepage(String keyWord, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
        .homepagesearch(keyWord)
        .compose(CommonSchedulers.<HomePageSearchBean>io2main())
        .subscribe(new Observer<HomePageSearchBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomePageSearchBean homePageSearchBean) {
                 iModelICallBack.homepage(keyWord,homePageSearchBean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    //热门搜索
    @Override
    public void popularSear(IModelICallBack iModelICallBack) {
         RetrofitManager.getInstance().create(MyApp.class)
                 .popularSearch()
                 .compose(CommonSchedulers.<PopularSearchBean>io2main())
                 .subscribe(new Observer<PopularSearchBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(PopularSearchBean popularSearchBean) {
                            iModelICallBack.popularSear(popularSearchBean);
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
