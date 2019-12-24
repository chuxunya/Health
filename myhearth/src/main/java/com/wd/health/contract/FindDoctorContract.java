package com.wd.health.contract;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.ConsultationBean;
import com.wd.health.bean.FindDoctorBean;

public interface FindDoctorContract {
    interface Iview extends IBaseView {
        void finddoctor(FindDoctorBean findDoctorBean);
        void quxiaodoctor(ConsultationBean consultationBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  FindDoctor(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack);
        void  QuxiaoDoctor(String userId, String sessionId, String doctorId , IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void finddoctor(FindDoctorBean findDoctorBean);
            void quxiaodoctor(ConsultationBean consultationBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  FindDoctor(String page, String count);
        void  QuxiaoDoctor(String doctorId );
    }
}
