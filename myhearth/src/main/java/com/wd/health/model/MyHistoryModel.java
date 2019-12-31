package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/28
 *@Time:9:13
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.contract.MyHistoryContract;

public class MyHistoryModel implements MyHistoryContract.Imodel {
    @Override
    public void MyHistory(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findhistory(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindHistoryBean>() {
                    @Override
                    public void onNext(FindHistoryBean findHistoryBean) {
                         iModelCallBack.myhistory(findHistoryBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
    //当前问诊
    @Override
    public void Current(String userId, String sessionId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .current(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CurrentInquiryRecordBean>() {
                    @Override
                    public void onNext(CurrentInquiryRecordBean currentInquiryRecordBean) {
                        iModelCallBack.current(currentInquiryRecordBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void OverEndquity(String userId, String sessionId, String recordId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .overinquiry(userId,sessionId,recordId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<EndInquiryBean>() {
                    @Override
                    public void onNext(EndInquiryBean endInquiryBean) {
                        iModelCallBack.overinquiry(endInquiryBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void Evaluation(String userId, String sessionId, String inquiryRecordId, String doctorId, String evaluate, String majorDegree, String satisfactionDegree, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .evaluation(userId,sessionId,inquiryRecordId,doctorId,evaluate,majorDegree,satisfactionDegree)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<EvaluationInquiryBean>() {
                    @Override
                    public void onNext(EvaluationInquiryBean evaluationInquiryBean) {
                        iModelCallBack.evaluation(evaluationInquiryBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
