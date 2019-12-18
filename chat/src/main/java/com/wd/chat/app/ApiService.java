package com.wd.chat.app;

import com.wd.chat.bean.DoctorBean;
import com.wd.chat.bean.DoctorInfoBean;
import com.wd.chat.bean.FindDepartmentBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/*
 *@auther:王可欣
 *@Date: 2019/12/14
 *@Time:9:10
 *@Description:api
 **/
public interface ApiService {
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDepartment查询科室
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<FindDepartmentBean> getDepartment();
    //http://172.17.8.100/health/user/inquiry/v1/findDoctorList查询问诊医生列表
    @GET("health/user/inquiry/v1/findDoctorList")
    Observable<DoctorBean> getDoctor(@Query("deptId")int deptId,@Query("condition")int condition,@Query("sortBy")int sortBy,@Query("page")int page,@Query("count")int count);
    //http://172.17.8.100/health/user/inquiry/v1/findDoctorInfo查询医生明细信息
    @GET("health/user/inquiry/v1/findDoctorInfo")
    Observable<DoctorInfoBean> getInfo(@Header("userId") int userId, @Header("sessionId")String sessionId, @Query("doctorId")int doctorId);
}
