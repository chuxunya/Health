package com.wd.health.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.ConsultBean;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.EndBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;
import com.wd.health.contract.Contract;
import com.wd.health.model.InquiryModel;

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
    public void followP(int userId, String sessionId, int doctorId) {
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
    public void canceP(int userId, String sessionId, int doctorId) {
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

    @Override
    public void NowP(int userId, String sessionId) {
        inquiryModel.NowData(userId, sessionId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                NowIMS nowIMS = (NowIMS)o;
                getView().onNowSuccess(nowIMS);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onNowFailure(e);
            }
        });
    }

    @Override
    public void MoneyP(int userId, String sessionId) {
        inquiryModel.MoneyData(userId, sessionId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                MyMoneyBean myMoneyBean = (MyMoneyBean)o;
                getView().onMoneySuccess(myMoneyBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onMoneyFailure(e);
            }
        });
    }

    @Override
    public void ConsultDoctorP(String userId, String sessionId, int doctorId) {
        inquiryModel.ConsultDoctorData(userId, sessionId, doctorId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                ConsultBean consultBean = (ConsultBean)o;
                getView().onConsultDoctorSuccess(consultBean);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onConsultDoctorFailure(e);
            }
        });
    }

    @Override
    public void EndDoctorData(String userId, String sessionId, int recordId) {
        inquiryModel.EndDoctorData(userId, sessionId, recordId, new Contract.IModel.IContractCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onEndDoctorSuccess((EndBean) o);
            }

            @Override
            public void onFailure(Throwable e) {
                getView().onEndDoctorFailure(e);
            }
        });
    }
}
