package com.wd.health.app;

import com.wd.health.bean.ConsultDoctorBean;
import com.wd.health.bean.DoctorBean;
import com.wd.health.bean.DoctorInfoBean;
import com.wd.health.bean.FindDepartmentBean;
import com.wd.health.bean.LikeBean;
import com.wd.health.bean.MyMoneyBean;
import com.wd.health.bean.NoLikeBean;
import com.wd.health.bean.NowIMS;

import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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
    Observable<DoctorBean> getDoctor(@Query("deptId") int deptId, @Query("condition") int condition, @Query("sortBy") int sortBy, @Query("page") int page, @Query("count") int count);
    //http://172.17.8.100/health/user/inquiry/v1/findDoctorInfo查询医生明细信息
    @GET("health/user/inquiry/v1/findDoctorInfo")
    Observable<DoctorInfoBean> getInfo(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);
    //http://172.17.8.100/health/user/inquiry/verify/v1/followDoctor关注医生
    @POST("health/user/inquiry/verify/v1/followDoctor")
    Observable<LikeBean> getfollow(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);
    //http://172.17.8.100/health/user/inquiry/verify/v1/cancelFollow取消关注医生
    @DELETE("health/user/inquiry/verify/v1/cancelFollow")
    Observable<NoLikeBean> getcancel(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("doctorId") int doctorId);
    //http://172.17.8.100/health/user/inquiry/verify/v1/findCurrentInquiryRecord用户查看当前问诊
    @GET("health/user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<NowIMS> getNow(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //http://172.17.8.100/health/user/verify/v1/findUserWallet我的钱包
    @GET("health/user/verify/v1/findUserWallet")
    Observable<MyMoneyBean> getMoney(@Header("userId") int userId, @Header("sessionId") String sessionId);
    @PUT("user/inquiry/verify/v1/consultDoctor")
    Observable<ConsultDoctorBean> getConsultDoctor(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("doctorId") String doctorId);
}
