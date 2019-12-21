package com.wd.health.model;

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;
import com.wd.health.utils.RetrofitManager;
import com.wd.health.contract.Contract;

/*
 *@auther:王可欣
 *@Date: 2019/12/14
 *@Time:9:19
 *@Description:问诊model
 **/
public class InquiryModel implements Contract.IModel {

    @Override
    public void DepartmentData(IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getDepartment()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindDepartmentBean>() {
                    @Override
                    public void onNext(FindDepartmentBean findDepartmentBean) {
                        iContractCallBack.onSuccess(findDepartmentBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void DoctorData(int deptId, int condition, int sortBy, int page, int count, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getDoctor(deptId,condition,sortBy,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DoctorBean>() {
                    @Override
                    public void onNext(DoctorBean doctorBean) {
                        iContractCallBack.onSuccess(doctorBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void InfoData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getInfo(userId,sessionId,doctorId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DoctorInfoBean>() {
                    @Override
                    public void onNext(DoctorInfoBean doctorInfoBean) {
                        iContractCallBack.onSuccess(doctorInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void followData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getfollow(userId,sessionId,doctorId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LikeBean>() {
                    @Override
                    public void onNext(LikeBean likeBean) {
                        iContractCallBack.onSuccess(likeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void canceData(int userId, String sessionId, int doctorId, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getcancel(userId,sessionId,doctorId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<NoLikeBean>() {
                    @Override
                    public void onNext(NoLikeBean noLikeBean) {
                        iContractCallBack.onSuccess(noLikeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void NowData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getNow(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<NowIMS>() {
                    @Override
                    public void onNext(NowIMS nowIMS) {
                        iContractCallBack.onSuccess(nowIMS);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }

    @Override
    public void MoneyData(int userId, String sessionId, IContractCallBack iContractCallBack) {
        RetrofitManager.getInstance().create()
                .getMoney(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyMoneyBean>() {
                    @Override
                    public void onNext(MyMoneyBean myMoneyBean) {
                        iContractCallBack.onSuccess(myMoneyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iContractCallBack.onFailure(e);
                    }
                });
    }
}
