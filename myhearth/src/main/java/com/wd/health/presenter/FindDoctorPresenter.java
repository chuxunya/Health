package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/23
 *@Time:15:35
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.ConsultationBean;
import com.wd.health.bean.FindDoctorBean;
import com.wd.health.contract.FindDoctorContract;
import com.wd.health.model.FindDoctorModel;

public class FindDoctorPresenter extends BasePresenter<FindDoctorContract.Iview> implements FindDoctorContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";

    private FindDoctorModel findDoctorModel;

    @Override
    protected void initModel() {
        findDoctorModel = new FindDoctorModel();
    }

    @Override
    public void FindDoctor(String page, String count) {
        findDoctorModel.FindDoctor(userId, sessionId, page, count, new FindDoctorContract.Imodel.IModelCallBack() {
            @Override
            public void finddoctor(FindDoctorBean findDoctorBean) {
                getView().finddoctor(findDoctorBean);
            }

            @Override
            public void quxiaodoctor(ConsultationBean consultationBean) {

            }

            @Override
            public void onFraily(String e) {
            getView().onFraily(e);
            }
        });
    }

    @Override
    public void QuxiaoDoctor(String doctorId) {
        findDoctorModel.QuxiaoDoctor(userId, sessionId, doctorId, new FindDoctorContract.Imodel.IModelCallBack() {
            @Override
            public void finddoctor(FindDoctorBean findDoctorBean) {

            }

            @Override
            public void quxiaodoctor(ConsultationBean consultationBean) {
                    getView().quxiaodoctor(consultationBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
