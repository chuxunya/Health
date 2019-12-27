package com.wd.health.contract;
/*
 *@auther:李泽楷
 *@Date: 2019/12/24
 *@Time:15:08
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.PushMessagedBean;
import com.wd.health.bean.RecordListBean;

public interface IRecordContract {
    interface IRecordView extends IBaseView {
        void onCurrentInquiryRecorSuccess(CurrentInquiryRecordBean bean);
        void onPushMessageSuccess(PushMessagedBean bean);
        void onRecordListSuccess(RecordListBean bean);
        void onFailure(Throwable e);
    }
    interface IRecordModel{

        void getCurrentInquiryRecorData(String userId, String sessionId, ICurrentInquiryRecorModelCallback iCurrentInquiryRecorModelCallback);
        interface ICurrentInquiryRecorModelCallback{
            void onCurrentInquiryRecorSuccess(CurrentInquiryRecordBean bean);
            void onFailure(Throwable e);
        }
        void getPushMessageData(String userId, String sessionId, String inquiryId, String content, String type, String doctorId, IPushMessageModelCallback iPushMessageModelCallback);
        interface IPushMessageModelCallback{
            void onPushMessageSuccess(PushMessagedBean bean);
            void onFailure(Throwable e);
        }
        void getRecordListData(String userId, String sessionId, String inquiryId, String page, String count, IRecordListModelCallback iRecordListModelCallback);
        interface IRecordListModelCallback{
            void onRecordListSuccess(RecordListBean bean);
            void onFailure(Throwable e);
        }
    }
    interface IRecordPresenter{
        void getCurrentInquiryRecorPresenter(String userId, String sessionId);
        void getPushMessagePresenter(String userId, String sessionId, String inquiryId, String content, String type, String doctorId);
        void getRecordListPresenter(String userId, String sessionId, String inquiryId, String page, String count);
    }
}
