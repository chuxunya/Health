package com.wd.health.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.ConsultBean;
import com.wd.health.bean.ConsultDoctorBean;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.EndBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;

/*
 *@auther:王可欣
 *@Date: 2019/12/14
 *@Time:9:14
 *@Description:contract
 **/
public interface Contract {
    interface IView extends IBaseView{
        void onDepartmentSuccess(FindDepartmentBean findDepartmentBean);
        void onDepartmentFailure(Throwable e);

        void onDoctorSuccess(DoctorBean doctorBean);
        void onDoctorFailure(Throwable e);

        void onInfoSuccess(DoctorInfoBean doctorInfoBean);
        void onInfoFailure(Throwable e);

        void onfollowSuccess(LikeBean likeBean);
        void onfollowFailure(Throwable e);

        void oncancelSuccess(NoLikeBean noLikeBean);
        void oncancelFailure(Throwable e);

        void onNowSuccess(NowIMS nowIMS);
        void onNowFailure(Throwable e);

        void onMoneySuccess(MyMoneyBean myMoneyBean);
        void onMoneyFailure(Throwable e);

        void onConsultDoctorSuccess(ConsultBean bean);
        void onConsultDoctorFailure(Throwable e);

        void onEndDoctorSuccess(EndBean bean);
        void onEndDoctorFailure(Throwable e);
    }
    interface IModel{
        void DepartmentData(IContractCallBack iContractCallBack);
        void DoctorData(int deptId, int condition, int sortBy, int page, int count, IContractCallBack iContractCallBack);
        void InfoData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack);
        void followData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack);
        void canceData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack);
        void NowData(int userId, String sessionId, IContractCallBack iContractCallBack);
        void MoneyData(int userId, String sessionId, IContractCallBack iContractCallBack);
        void ConsultDoctorData(String userId, String sessionId, int doctorId, IContractCallBack iContractCallBack);
        void EndDoctorData(String userId, String sessionId, int recordId, IContractCallBack iContractCallBack);
        interface IContractCallBack{
            void onSuccess(Object o);
            void onFailure(Throwable e);
        }
    }
    interface IPresenter{
        void DepartmentP();
        void DoctorP(int deptId, int condition, int sortBy, int page, int count);
        void InfoP(int userId, String sessionId, int doctorId);
        void followP(int userId, String sessionId, int doctorId);
        void canceP(int userId, String sessionId, int doctorId);
        void NowP(int userId, String sessionId);
        void MoneyP(int userId, String sessionId);
        void ConsultDoctorP(String userId, String sessionId, int doctorId);
        void EndDoctorData(String userId, String sessionId, int recordId);
    }
}
