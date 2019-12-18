package com.wd.aclass.api;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:36
 *@Description:api
 **/

import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


public interface IApi {
    //查询健康讲堂类目http://172.17.8.100/health/user/video/v1/findVideoCategoryList
    @GET("health/user/video/v1/findVideoCategoryList")
    Observable<JiangtangBean> jiangtang();
    //根据视频类目查询视频列表http://172.17.8.100/health/user/video/v1/findVideoVoList?categoryId=1&page=1&count=5
    @GET("http://172.17.8.100/health/user/video/v1/findVideoVoList")
    Observable<VideoBean> jiangvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("categoryId") String categoryId, @Query("page") String page, @Query("count") String count);

}
