package com.wd.chat.model;

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.FindDepartmentBean;
import com.wd.chat.utils.RetrofitManager;
import com.wd.chat.contract.Contract;

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
}
