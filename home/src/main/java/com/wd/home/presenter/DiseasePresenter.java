package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DoTaskBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.ReleasePatientsBean;
import com.wd.home.bean.UploadPatientBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.DiseaseContract;
import com.wd.home.model.DiseaseModel;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor hp
 * @time 2019/12/18 14:37
 */
public class DiseasePresenter extends BasePresenter<DiseaseContract.Iview> implements DiseaseContract.IPresenter {


    private DiseaseModel diseaseModel;

    @Override
    protected void initModel() {
        diseaseModel = new DiseaseModel();
    }


    //查询科室列表
    @Override
    public void depart() {
         diseaseModel.depart(new DiseaseContract.Imodel.IModelICallBack() {
             @Override
             public void depart(DepartmentBean departmentBean) {
                 getView().depart(departmentBean);
             }

             @Override
             public void disease(int departmentId, DiseaseBean diseaseBean) {

             }

             @Override
             public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean) {

             }

             @Override
             public void publishsick(int userId, String sessionId, Map<String, Object> map, ReleasePatientsBean releasePatientsBean) {

             }

             @Override
             public void dotask(int userId, String sessionId, int taskId, DoTaskBean doTaskBean) {

             }
         });
    }


    // 根据科室查询对应病症
    @Override
    public void disease(int departmentId) {
        diseaseModel.disease(departmentId, new DiseaseContract.Imodel.IModelICallBack() {
            @Override
            public void depart(DepartmentBean departmentBean) {

            }

            @Override
            public void disease(int departmentId, DiseaseBean diseaseBean) {
                     getView().disease(diseaseBean);
            }

            @Override
            public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean) {

            }

            @Override
            public void publishsick(int userId, String sessionId, Map<String, Object> map, ReleasePatientsBean releasePatientsBean) {

            }

            @Override
            public void dotask(int userId, String sessionId, int taskId, DoTaskBean doTaskBean) {

            }
        });
    }

    //发布病友圈照片
    @Override
    public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part) {
         diseaseModel.uploadsick(userId, sessionId, sickCircleId, part, new DiseaseContract.Imodel.IModelICallBack() {
             @Override
             public void depart(DepartmentBean departmentBean) {

             }

             @Override
             public void disease(int departmentId, DiseaseBean diseaseBean) {

             }

             @Override
             public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean) {
                 getView().uploadsick(uploadPatientBean);
             }

             @Override
             public void publishsick(int userId, String sessionId, Map<String, Object> map, ReleasePatientsBean releasePatientsBean) {

             }

             @Override
             public void dotask(int userId, String sessionId, int taskId, DoTaskBean doTaskBean) {

             }
         });
    }

    //发布病友圈
    @Override
    public void publishsick(int userId, String sessionId, Map<String, Object> map) {
           diseaseModel.publishsick(userId, sessionId, map, new DiseaseContract.Imodel.IModelICallBack() {
               @Override
               public void depart(DepartmentBean departmentBean) {

               }

               @Override
               public void disease(int departmentId, DiseaseBean diseaseBean) {

               }

               @Override
               public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean) {

               }

               @Override
               public void publishsick(int userId, String sessionId, Map<String, Object> map, ReleasePatientsBean releasePatientsBean) {
                   getView().publishsick(releasePatientsBean);
               }

               @Override
               public void dotask(int userId, String sessionId, int taskId, DoTaskBean doTaskBean) {

               }
           });
    }

    @Override
    public void dotask(int userId, String sessionId, int taskId) {
        diseaseModel.dotask(userId, sessionId, taskId, new DiseaseContract.Imodel.IModelICallBack() {
            @Override
            public void depart(DepartmentBean departmentBean) {

            }

            @Override
            public void disease(int departmentId, DiseaseBean diseaseBean) {

            }

            @Override
            public void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean) {

            }

            @Override
            public void publishsick(int userId, String sessionId, Map<String, Object> map, ReleasePatientsBean releasePatientsBean) {

            }

            @Override
            public void dotask(int userId, String sessionId, int taskId, DoTaskBean doTaskBean) {
                getView().dotask(doTaskBean);
            }
        });
    }


}
