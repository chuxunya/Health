package com.wd.health.contract;


import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.AddSignBean;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindHistoryBean;
/**
 *@describe(描述)：MyHistoryContract
 *@data（日期）: 2019/12/30
 *@time（时间）: 14:49
 *@author（作者）: 张安恒 历史记录 当前问诊  接收问诊
 **/
public interface MyHistoryContract {
    interface Iview extends IBaseView {
        void myhistory(FindHistoryBean findHistoryBean);
        void evaluation(EvaluationInquiryBean evaluationInquiryBean);
        void current(CurrentInquiryRecordBean currentInquiryRecordBean);
        void overinquiry(EndInquiryBean endInquiryBean);

    }
    interface  Imodel{
        void  MyHistory(String userId, String sessionId,String page, String count, IModelCallBack iModelCallBack);
        void  Current(String userId, String sessionId, IModelCallBack iModelCallBack);
        void  OverEndquity(String userId, String sessionId, String recordId,IModelCallBack iModelCallBack);
        void  Evaluation(String userId, String sessionId,String inquiryRecordId, String doctorId, String evaluate, String majorDegree, String satisfactionDegree,IModelCallBack iModelCallBack);
           interface IModelCallBack {
               void myhistory(FindHistoryBean findHistoryBean);
               void current(CurrentInquiryRecordBean currentInquiryRecordBean);
               void evaluation(EvaluationInquiryBean evaluationInquiryBean);
               void overinquiry(EndInquiryBean endInquiryBean);
              void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  MyHistory(String page, String count);
        void  Current();
        void  OverEndquity(String recordId);
        void  Evaluation(String inquiryRecordId, String doctorId, String evaluate, String majorDegree, String satisfactionDegree);
       }
}
