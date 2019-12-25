package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.DoTaskBean;
import com.wd.home.bean.DrugsBean;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.PopularSearchBean;
import com.wd.home.bean.ReleasePatientsBean;
import com.wd.home.bean.UploadPatientBean;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor 科室查询病症
 * @time 2019/12/18 14:28
 */
public interface DiseaseContract {

    interface Iview extends IBaseView {
        //查询科室列表
        void depart(DepartmentBean departmentBean);
        //根据科室查询对应病症
        void disease(DiseaseBean diseaseBean);
        //上传用户病友圈相关图片
        void uploadsick(UploadPatientBean uploadPatientBean);
        //发布病友圈
        void publishsick(ReleasePatientsBean releasePatientsBean);
        //做任务
        void dotask(DoTaskBean doTaskBean);
    }

    interface Imodel {
        //查询科室列表
        void depart(IModelICallBack iModelICallBack);
        //根据科室查询对应病症
        void disease(int departmentId,IModelICallBack iModelICallBack);
        //上传用户病友圈相关图片
        void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, IModelICallBack iModelICallBack);
        //发布病友圈
        void publishsick(int userId, String sessionId, Map<String, Object> map,IModelICallBack iModelICallBack);
        //做任务
        void dotask(int userId,String sessionId, int taskId,IModelICallBack iModelICallBack);


        interface IModelICallBack {
            //查询科室列表
            void depart(DepartmentBean departmentBean);
            //根据科室查询对应病症
            void disease(int departmentId,DiseaseBean diseaseBean);
            //上传用户病友圈相关图片
            void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part, UploadPatientBean uploadPatientBean);
            //发布病友圈
            void publishsick(int userId, String sessionId, Map<String, Object> map,ReleasePatientsBean releasePatientsBean);
            //做任务
            void dotask(int userId,String sessionId, int taskId,DoTaskBean doTaskBean);

        }
    }

    interface IPresenter {
        void depart();
        void disease(int departmentId);
        void uploadsick(int userId, String sessionId, int sickCircleId, MultipartBody.Part part);
        void publishsick(int userId, String sessionId, Map<String, Object> map);
        void dotask(int userId,String sessionId, int taskId);

    }
}
