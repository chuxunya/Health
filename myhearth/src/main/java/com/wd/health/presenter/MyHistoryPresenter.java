package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/28
 *@Time:9:14
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.contract.MyHistoryContract;
import com.wd.health.model.MyHistoryModel;

public class MyHistoryPresenter extends BasePresenter<MyHistoryContract.Iview> implements MyHistoryContract.IPresenter {
    private String userId="475";
    private String sessionId="1577687759495475";
    private MyHistoryModel myHistoryModel;

    @Override
    protected void initModel() {
        myHistoryModel = new MyHistoryModel();
    }

    @Override
    public void MyHistory(String page, String count) {
        myHistoryModel.MyHistory(userId, sessionId, page, count, new MyHistoryContract.Imodel.IModelCallBack() {
            @Override
            public void myhistory(FindHistoryBean findHistoryBean) {
                getView().myhistory(findHistoryBean);
            }

            @Override
            public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {

            }

            @Override
            public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {

            }

            @Override
            public void overinquiry(EndInquiryBean endInquiryBean) {

            }

            @Override
            public void onFraily(String e) {
            }
        });
    }

    @Override
    public void Current() {
        myHistoryModel.Current(userId, sessionId, new MyHistoryContract.Imodel.IModelCallBack() {
            @Override
            public void myhistory(FindHistoryBean findHistoryBean) {

            }

            @Override
            public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {
                    getView().current(currentInquiryRecordBean);
            }

            @Override
            public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {

            }

            @Override
            public void overinquiry(EndInquiryBean endInquiryBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void OverEndquity(String recordId) {
                myHistoryModel.OverEndquity(userId, sessionId, recordId, new MyHistoryContract.Imodel.IModelCallBack() {
                    @Override
                    public void myhistory(FindHistoryBean findHistoryBean) {

                    }

                    @Override
                    public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {

                    }

                    @Override
                    public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {

                    }

                    @Override
                    public void overinquiry(EndInquiryBean endInquiryBean) {
                            getView().overinquiry(endInquiryBean);
                    }

                    @Override
                    public void onFraily(String e) {

                    }
                });
    }

    @Override
    public void Evaluation(String inquiryRecordId, String doctorId, String evaluate, String majorDegree, String satisfactionDegree) {
        myHistoryModel.Evaluation(userId, sessionId, inquiryRecordId, doctorId, evaluate, majorDegree, satisfactionDegree, new MyHistoryContract.Imodel.IModelCallBack() {
            @Override
            public void myhistory(FindHistoryBean findHistoryBean) {

            }

            @Override
            public void current(CurrentInquiryRecordBean currentInquiryRecordBean) {

            }

            @Override
            public void evaluation(EvaluationInquiryBean evaluationInquiryBean) {
                getView().evaluation(evaluationInquiryBean);
            }

            @Override
            public void overinquiry(EndInquiryBean endInquiryBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
