package com.wd.login.app;

import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


/**
 * 作者:dongyanjun
 * 时间：2019/12/18
 * 描述:Health
 * 功能：
 **/
public interface ApiServer {
    //登录
    @FormUrlEncoded
    @POST("health/user/v1/login")
    Observable<LoginBean> postLogin(@Field("email") String email, @Field("pwd") String pwd);

    //注册
    //http://172.17.8.100/health/user/v1/register
    @FormUrlEncoded
    @POST("health/user/v1/register")
    Observable<RegisteredBean> getRegister(@Field("email")String email,
                                           @Field("code")String code,
                                           @Field("pwd1")String pwd1,
                                           @Field("pwd2")String pwd2,
                                           @Field("invitationCode")String invitationCode);
    //发送邮箱验证码
    //http://172.17.8.100/health/user/v1/sendOutEmailCode
    @POST("health/user/v1/sendOutEmailCode")
    Observable<SendEmilBean> getSendEmil(@Query("email")String email);
    //忘记密码
    @PUT("health/user/v1/resetUserPwd")
    Observable<ForgetBean> postForgetBean(@Query("email")String email, @Query("pwd1")String pwd1, @Query("pwd2")String pwd2);
    //校验验证码
    @POST("health/user/v1/checkCode")
    Observable<ForgetBean> postCheckCode(@Query("email")String email,@Query("code")String code);
}
