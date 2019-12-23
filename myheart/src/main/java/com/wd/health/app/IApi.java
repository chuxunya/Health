package com.wd.health.app;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:36
 *@Description:api
 **/





import com.wd.health.bean.FindDoctorBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface IApi {
    //查询用户关注医生列表http://172.17.8.100/health/user/verify/v1/findUserDoctorFollowList
    @GET("health/user/verify/v1/findUserDoctorFollowList")
    Observable<FindDoctorBean> finddoctor(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

}
