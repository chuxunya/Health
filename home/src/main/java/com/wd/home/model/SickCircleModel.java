package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.CommentCircleBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.PatientDetailsBean;
import com.wd.home.bean.QueryCommentBean;
import com.wd.home.contract.SickCircleContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/21 10:25
 */
public class SickCircleModel implements SickCircleContract.Imodel {
    //查询病友圈详情
    @Override
    public void sickcircleinfo(int sickCircleId, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .sickcircleinfo(sickCircleId)
                .compose(CommonSchedulers.<PatientDetailsBean>io2main())
                .subscribe(new Observer<PatientDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PatientDetailsBean patientDetailsBean) {
                        iModelICallBack.sickcircleinfo(sickCircleId,patientDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    //病友圈发表评论
    @Override
    public void publishcomment(int userId, String sessionId, int sickCircleId, String content, IModelICallBack iModelICallBack) {
           RetrofitManager.getInstance().create(MyApp.class)
                   .publishcomment(userId,sessionId,sickCircleId,content)
                   .compose(CommonSchedulers.<CommentCircleBean>io2main())
                   .subscribe(new Observer<CommentCircleBean>() {
                       @Override
                       public void onSubscribe(Disposable d) {

                       }

                       @Override
                       public void onNext(CommentCircleBean commentCircleBean) {
                         iModelICallBack.publishcomment(userId,sessionId,sickCircleId,content,commentCircleBean);
                       }

                       @Override
                       public void onError(Throwable e) {

                       }

                       @Override
                       public void onComplete() {

                       }
                   });
    }
    //查询病友圈评论列表
    @Override
    public void querycommentbean(int sickCircleId, int page, int count, IModelICallBack iModelICallBack) {
     RetrofitManager.getInstance().create(MyApp.class)
             .querycommentbean(sickCircleId,page,count)
             .compose(CommonSchedulers.<QueryCommentBean>io2main())
             .subscribe(new Observer<QueryCommentBean>() {
                 @Override
                 public void onSubscribe(Disposable d) {

                 }

                 @Override
                 public void onNext(QueryCommentBean queryCommentBean) {
                     iModelICallBack.querycommentbean(sickCircleId,page,count,queryCommentBean);
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
