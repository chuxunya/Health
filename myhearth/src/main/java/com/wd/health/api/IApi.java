package com.wd.health.api;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:36
 *@Description:api
 **/





import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.AddSignBean;
import com.wd.health.bean.ConsultationBean;
import com.wd.health.bean.CurrentInquiryRecordBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.EndInquiryBean;
import com.wd.health.bean.EvaluationInquiryBean;
import com.wd.health.bean.FindDoctorBean;
import com.wd.health.bean.FindHistoryBean;
import com.wd.health.bean.FindMyAdoptedCommentListBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.MydeleVideoBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.bean.XiuBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface IApi {
    //查询用户关注医生列表http://172.17.8.100/health/user/verify/v1/findUserDoctorFollowList
    @GET("health/user/verify/v1/findUserDoctorFollowList")
    Observable<FindDoctorBean> finddoctor(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //取消关注医生http://172.17.8.100/health/user/inquiry/verify/v1/cancelFollow
    @DELETE("health/user/inquiry/verify/v1/cancelFollow")
    Observable<ConsultationBean> quxiaoactor(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("doctorId") String doctorId);
    //我的钱包http://172.17.8.100/health/user/verify/v1/findUserWallet
    @GET("health/user/verify/v1/findUserWallet")
    Observable<MyWalletBean> wallet(@Header("userId") String userId, @Header("sessionId") String sessionId);
    //查询用户资讯收藏列表http://172.17.8.100/health/user/verify/v1/findUserInfoCollectionList
    @GET("health/user/verify/v1/findUserInfoCollectionList")
    Observable<AddInfoCollectBean> addinfocollect(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //取消资讯收藏://http://172.17.8.100/health/user/verify/v1/cancelInfoCollection
    @DELETE("health/user/verify/v1/cancelInfoCollection")
    Observable<DeInfoBean> deleteinfo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("infoId") String infoId);
    //用户收藏健康课堂视频列表:http://172.17.8.100/health/user/verify/v1/findVideoCollectionList
    @GET("health/user/verify/v1/findVideoCollectionList")
    Observable<VideoInfoBean> findvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //用户取消视频收藏://http://172.17.8.100/health/user/verify/v1/cancelVideoCollection
    @DELETE("health/user/verify/v1/cancelVideoCollection")
    Observable<DeleVideoInfoBean> delevideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId") String videoId);
    //查询用户收藏病友圈列表:http://172.17.8.100/health/user/verify/v1/findUserSickCollectionList
    @GET("health/user/verify/v1/findUserSickCollectionList")
    Observable<FindquanBean> findquan(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //查询用户购买视频列表:http://172.17.8.100/health/user/verify/v1/findUserVideoBuyList
    @GET("health/user/verify/v1/findUserVideoBuyList")
    Observable<MyBuyVideoBean> mybuyvideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //删除购买健康课堂视频://http://172.17.8.100/health/user/verify/v1/deleteVideoBuy
    @DELETE("health/user/verify/v1/deleteVideoBuy")
    Observable<MydeleVideoBean> mydeletevideo(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("videoId") String videoId);
    //查询用户消费记录:http://172.17.8.100/health/user/verify/v1/findUserConsumptionRecordList
    @GET("health/user/verify/v1/findUserConsumptionRecordList")
    Observable<FindUserCRBean> findusercr(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //用户签到:http://172.17.8.100/health/user/verify/v1/addSign
    @POST("health/user/verify/v1/addSign")
    Observable<AddSignBean> addsign(@Header("userId") String userId, @Header("sessionId") String sessionId);
    //查询我的被采纳的建议:http://172.17.8.100/health/user/verify/v1/findMyAdoptedCommentList
    @GET("health/user/verify/v1/findMyAdoptedCommentList")
    Observable<FindMyAdoptedCommentListBean> findyijian(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

    //我的病友圈
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleList?page=1&count=5
    @GET("health/user/sickCircle/verify/v1/findMySickCircleList")
    Observable<MySickCircleListBean> getMySickCircleList(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);
    //查询我的病友圈帖子的评论列表
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleCommentList?sickCircleId=1796&page=1&count=5
    @GET("health/user/sickCircle/verify/v1/findMySickCircleCommentList")
    Observable<MySickCircleCommentListBean> getMySickCircleCommentList(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId, @Query("page") String page, @Query("count") String count);

    //查看历史问诊http://172.17.8.100/health/user/inquiry/verify/v1/findHistoryInquiryRecord
    @GET("health/user/inquiry/verify/v1/findHistoryInquiryRecord")
    Observable<FindHistoryBean> findhistory(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

    //用户查看当前问诊:http://172.17.8.100/health/user/inquiry/verify/v1/findCurrentInquiryRecord
    @GET("health/user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<CurrentInquiryRecordBean> current(@Header("userId") String userId, @Header("sessionId") String sessionId);

    //结束问诊:http://172.17.8.100/health/user/inquiry/verify/v1/endInquiry
    @PUT("health/user/inquiry/verify/v1/endInquiry")
    Observable<EndInquiryBean> overinquiry(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("recordId") String recordId);


    //用户评论问诊服务http://172.17.8.100/health/user/inquiry/verify/v1/evaluationInquiry
    @PUT("health/user/inquiry/verify/v1/evaluationInquiry")
    Observable<EvaluationInquiryBean> evaluation(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("inquiryRecordId") String inquiryRecordId, @Query("doctorId") String doctorId, @Query("evaluate") String evaluate, @Query("majorDegree") String majorDegree,@Query("satisfactionDegree") String satisfactionDegree);
    //用户查看自己的档案http://172.17.8.100/health/user/verify/v1/findUserArchives
    @GET("health/user/verify/v1/findUserArchives")
    Observable<FindUserArchivesBean> finddang(@Header("userId") String userId, @Header("sessionId") String sessionId);
    //删除用户档案http://172.17.8.100/health/user/verify/v1/deleteUserArchives
    @GET("health/user/verify/v1/health/user/verify/v1/deleteUserArchives")
    Observable<DeleDangBean> deledang(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("archivesId") String archivesId);

    //修改用户档案:http://172.17.8.100/health/user/verify/v1/updateUserArchives
    @PUT("health/user/verify/v1/updateUserArchives")
    Observable<XiuBean> xiuuser(@Header("userId") String userId, @Header("sessionId") String sessionId, @Body HashMap<String,String> map);

}
