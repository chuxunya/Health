package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/23
 *@Time:15:34
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.app.IApi;
import com.wd.health.bean.FindDoctorBean;
import com.wd.health.contract.FindDoctorContract;

public class FindDoctorModel implements FindDoctorContract.Imodel {
    @Override
    public void FindDoctor(String userId, String sessionId, String page, String count, final IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .finddoctor(userId,sessionId,page,count)
                .compose(CommonSchedulers.<FindDoctorBean>io2main())
                .subscribe(new CommonObserver<FindDoctorBean>() {
                    @Override
                    public void onNext(FindDoctorBean findDoctorBean) {
                        iModelCallBack.finddoctor(findDoctorBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
