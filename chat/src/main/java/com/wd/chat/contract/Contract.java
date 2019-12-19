package com.wd.chat.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.DoctorInfoBean;
import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.bean.LikeBean;
import com.wd.chat.bean.NoLikeBean;

import retrofit2.http.Query;

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
    }
    interface IModel{
        void DepartmentData(IContractCallBack iContractCallBack);
        void DoctorData(int deptId,int condition,int sortBy,int page,int count,IContractCallBack iContractCallBack);
        void InfoData( int userId,String sessionId,int doctorId,IContractCallBack iContractCallBack);
        void followData( int userId,String sessionId,int doctorId,IContractCallBack iContractCallBack);
        void canceData( int userId,String sessionId,int doctorId,IContractCallBack iContractCallBack);
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
    }
}
