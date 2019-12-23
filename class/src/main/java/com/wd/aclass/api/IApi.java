package com.wd.aclass.api;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:36
 *@Description:api
 **/



import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.DanmuBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface IApi {
    //查询健康讲堂类目http://172.17.8.100/health/user/video/v1/findVideoCategoryList
    @GET("health/user/video/v1/findVideoCategoryList")
    Observable<JiangtangBean> jiangtang();
    //根据视频类目查询视频列表http://172.17.8.100/health/user/video/v1/findVideoVoList?categoryId=1&page=1&count=5
    @GET("http://172.17.8.100/health/user/video/v1/findVideoVoList")
    Observable<VideoBean> jiangvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("categoryId") String categoryId, @Query("page") String page, @Query("count") String count);
    //收藏http://172.17.8.100/health/user/video/verify/v1/addUserVideoCollection
    @POST("health/user/video/verify/v1/addUserVideoCollection")
    Observable<AddVideoBean> addvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId") String videoId);
    //健康课堂视频购买http://172.17.8.100/health/user/video/verify/v1/videoBuy
    @POST("health/user/video/verify/v1/videoBuy")
    Observable<BuyVideoBean> buyvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId") String videoId, @Query("price") String price);
    //弹幕http://172.17.8.100/health/user/video/verify/v1/addVideoComment
    @POST("health/user/video/verify/v1/addVideoComment")
    Observable<DanmuBean> danmu(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId") String videoId, @Query("content") String content);
}
