package com.wd.health.presenter;
/*
 *@auther:李泽楷
 *@Date: 2019/12/24
 *@Time:15:47
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.PushMessagedBean;
import com.wd.health.bean.RecordListBean;
import com.wd.health.contract.IRecordContract;
import com.wd.health.model.IRecordContractModel;

public class IRecordContractPresenter extends BasePresenter<IRecordContract.IRecordView> implements IRecordContract.IRecordPresenter {

    private IRecordContractModel model;

    @Override
    protected void initModel() {
        model = new IRecordContractModel();
    }

    @Override
    public void getCurrentInquiryRecorPresenter(String userId, String sessionId) {
        model.getCurrentInquiryRecorData(userId, sessionId, new IRecordContract.IRecordModel.ICurrentInquiryRecorModelCallback() {
            @Override
            public void onCurrentInquiryRecorSuccess(CurrentInquiryRecordBean bean) {
                getView().onCurrentInquiryRecorSuccess(bean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onFailure(e);
            }
        });
    }

    @Override
    public void getPushMessagePresenter(String userId, String sessionId, String inquiryId, String content, String type, String doctorId) {
            model.getPushMessageData(userId, sessionId, inquiryId, content, type, doctorId, new IRecordContract.IRecordModel.IPushMessageModelCallback() {
                @Override
                public void onPushMessageSuccess(PushMessagedBean bean) {
                    getView().onPushMessageSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }

    @Override
    public void getRecordListPresenter(String userId, String sessionId, String inquiryId, String page, String count) {
            model.getRecordListData(userId, sessionId, inquiryId, page, count, new IRecordContract.IRecordModel.IRecordListModelCallback() {
                @Override
                public void onRecordListSuccess(RecordListBean bean) {
                    getView().onRecordListSuccess(bean);
                }

                @Override
                public void onFailure(Throwable e) {
                    getView().onFailure(e);
                }
            });
    }
}
