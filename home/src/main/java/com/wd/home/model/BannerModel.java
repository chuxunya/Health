package com.wd.home.model;

import android.util.Log;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.KeywordSearchBean;
import com.wd.home.bean.SickCircleListBean;
import com.wd.home.contract.BannerContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor banner
 * @time 2019/12/13 19:06
 */
public class BannerModel implements BannerContract.Imodel {


    //轮播图
    @Override
    public void banner(final  IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .banner()
                .compose(CommonSchedulers.<BannerBean>io2main())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                         iModelICallBack.banner(bannerBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //查询科室列表
    @Override
    public void department(final IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .department()
                .compose(CommonSchedulers.<DepartmentBean>io2main())
                .subscribe(new Observer<DepartmentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DepartmentBean departmentBean) {
                        iModelICallBack.department(departmentBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //查询健康资讯板块
    @Override
    public void information(final IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .information()
                .compose(CommonSchedulers.<InformationBean>io2main())
                .subscribe(new Observer<InformationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InformationBean informationBean) {
                        iModelICallBack.information(informationBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //根据资讯板块查询资讯列表
    @Override
    public void informationlist(int plateId, int page, int count,final IModelICallBack iModelICallBack) {
      RetrofitManager.getInstance().create(MyApp.class)
              .informationlist(plateId,page,count)
              .compose(CommonSchedulers.<InformationListBean>io2main())
              .subscribe(new Observer<InformationListBean>() {
                  @Override
                  public void onSubscribe(Disposable d) {

                  }

                  @Override
                  public void onNext(InformationListBean informationListBean) {
                   iModelICallBack.informationlist(plateId,page,count,informationListBean);
                  }

                  @Override
                  public void onError(Throwable e) {

                  }

                  @Override
                  public void onComplete() {

                  }
              });

    }

    //根据关键词查询病友圈
    @Override
    public void keywordsearchbean(String keyWord, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .keywordsearchbean(keyWord)
                .compose(CommonSchedulers.<KeywordSearchBean>io2main())
                .subscribe(new Observer<KeywordSearchBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(KeywordSearchBean keywordSearchBean) {
                        iModelICallBack.keywordsearchbean(keyWord,keywordSearchBean);
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
