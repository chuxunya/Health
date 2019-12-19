package com.wd.chat.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.DoctorInfoBean;
import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.bean.LikeBean;
import com.wd.chat.bean.NoLikeBean;
import com.wd.chat.contract.Contract;
import com.wd.chat.model.InquiryModel;

/*
 *@auther:王可欣
 *@Date: 2019/12/14
 *@Time:9:31
 *@Description:presenter
 **/
public class InquiryPresenter extends BasePresenter<Contract.IView> implements Contract.IPresenter {

    private InquiryModel inquiryModel;

    @Override
    protected void initModel() {
        inquiryModel = new InquiryModel();
    }

    @Override
    public void DepartmentP() {
        inquiryModel.DepartmentData(new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                FindDepartmentBean findDepartmentBean = (FindDepartmentBean)o;
                getView().onDepartmentSuccess(findDepartmentBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onDepartmentFailure(e);
            }
        });
    }

    @Override
    public void DoctorP(int deptId, int condition, int sortBy, int page, int count) {
        inquiryModel.DoctorData(deptId, condition, sortBy, page, count, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                DoctorBean doctorBean = (DoctorBean)o;
                getView().onDoctorSuccess(doctorBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onDoctorFailure(e);
            }
        });
    }

    @Override
    public void InfoP(int userId, String sessionId, int doctorId) {
        inquiryModel.InfoData(userId, sessionId, doctorId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                DoctorInfoBean doctorInfoBean = (DoctorInfoBean)o;
                getView().onInfoSuccess(doctorInfoBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onInfoFailure(e);
            }
        });
    }

    @Override
    public void followP(int userId, String sessionId, int doctorId, Contract.IModel.IContractCallBack iContractCallBack) {
        inquiryModel.followData(userId, sessionId, doctorId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                LikeBean likeBean = (LikeBean)o;
                getView().onfollowSuccess(likeBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onfollowFailure(e);
            }
        });
    }

    @Override
    public void canceP(int userId, String sessionId, int doctorId, Contract.IModel.IContractCallBack iContractCallBack) {
        inquiryModel.canceData(userId, sessionId, doctorId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                NoLikeBean noLikeBean = (NoLikeBean)o;
                getView().oncancelSuccess(noLikeBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().oncancelFailure(e);
            }
        });
    }

}
