package com.wd.home.model;

import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.home.api.MyApp;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DoTaskBean;
import com.wd.home.bean.ReleasePatientsBean;
import com.wd.home.bean.UploadPatientBean;
import com.wd.home.contract.DiseaseContract;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.MultipartBody;

/**
 * @name Health
 * @class name：com.wd.home.model
 * @anthor hp
 * @time 2019/12/18 14:33
 */
public class DiseaseModel implements DiseaseContract.Imodel {

    //查询科室
    @Override
    public void depart(final IModelICallBack iModelICallBack) {
         RetrofitManager.getInstance().create(MyApp.class)
                 .department()
                 .compose(CommonSchedulers.<DepartmentBean>io2main())
                 .subscribe(new Observer<DepartmentBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {

                     }

                     @Override
                     public void onNext(DepartmentBean departmentBean) {
                            iModelICallBack.depart(departmentBean);
                     }

                     @Override
                     public void onError(Throwable e) {

                     }

                     @Override
                     public void onComplete() {

                     }
                 });

    }

    //根据科室查询对应病症
    @Override
    public void disease(int departmentId,final IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .disease(departmentId)
                .compose(CommonSchedulers.<DiseaseBean>io2main())
                .subscribe(new Observer<DiseaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiseaseBean diseaseBean) {
                           iModelICallBack.disease(departmentId,diseaseBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    //发布照片
    @Override
    public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .uploadsick(userId, sessionId, sickCircleId, part)
                .compose(CommonSchedulers.<UploadPatientBean>io2main())
                .subscribe(new Observer<UploadPatientBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UploadPatientBean uploadPatientBean) {
                        iModelICallBack.uploadsick(userId,sessionId,sickCircleId,part,uploadPatientBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    //发布病友圈
    @Override
    public void publishsick(int userId, String sessionId, Map<String, Object> map, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .publishsick(userId, sessionId, map)
                .compose(CommonSchedulers.<ReleasePatientsBean>io2main())
                .subscribe(new Observer<ReleasePatientsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReleasePatientsBean releasePatientsBean) {
                     iModelICallBack.publishsick(userId,sessionId,map,releasePatientsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //做任务
    @Override
    public void dotask(int userId, String sessionId, int taskId, IModelICallBack iModelICallBack) {
        RetrofitManager.getInstance().create(MyApp.class)
                .dotask(userId, sessionId, taskId)
                .compose(CommonSchedulers.<DoTaskBean>io2main())
                .subscribe(new Observer<DoTaskBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DoTaskBean doTaskBean) {
                        iModelICallBack.dotask(userId,sessionId,taskId,doTaskBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
