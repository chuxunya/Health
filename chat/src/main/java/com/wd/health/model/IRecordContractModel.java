package com.wd.health.model;
/*
 *@auther:李泽楷
 *@Date: 2019/12/24
 *@Time:15:42
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.PushMessagedBean;
import com.wd.health.bean.RecordListBean;
import com.wd.health.contract.IRecordContract;
import com.wd.health.utils.RetrofitManager;

public class IRecordContractModel implements IRecordContract.IRecordModel {
    @Override
    public void getCurrentInquiryRecorData(String userId, String sessionId, ICurrentInquiryRecorModelCallback iCurrentInquiryRecorModelCallback) {
        RetrofitManager.getInstance().create().getCurrentInquiryRecord(userId, sessionId).compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CurrentInquiryRecordBean>() {
                    @Override
                    public void onNext(CurrentInquiryRecordBean bean) {
                        iCurrentInquiryRecorModelCallback.onCurrentInquiryRecorSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iCurrentInquiryRecorModelCallback.onFailure(e);
                    }
                });
    }

    @Override
    public void getPushMessageData(String userId, String sessionId, String inquiryId, String content, String type, String doctorId, IPushMessageModelCallback iPushMessageModelCallback) {
                RetrofitManager.getInstance().create().getPushMessage(userId, sessionId, inquiryId, content, type, doctorId)
                        .compose(CommonSchedulers.io2main())
                        .subscribe(new CommonObserver<PushMessagedBean>() {
                            @Override
                            public void onNext(PushMessagedBean pushMessagedBean) {
                                iPushMessageModelCallback.onPushMessageSuccess(pushMessagedBean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                iPushMessageModelCallback.onFailure(e);
                            }
                        });
    }


    @Override
    public void getRecordListData(String userId, String sessionId, String inquiryId, String page, String count, IRecordListModelCallback iRecordListModelCallback) {
                    RetrofitManager.getInstance().create().getRecordList(userId, sessionId, inquiryId, page, count)
                            .compose(CommonSchedulers.io2main())
                            .subscribe(new CommonObserver<RecordListBean>() {
                                @Override
                                public void onNext(RecordListBean recordListBean) {
                                    iRecordListModelCallback.onRecordListSuccess(recordListBean);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    iRecordListModelCallback.onFailure(e);
                                }
                            });
    }
}
