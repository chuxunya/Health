package com.wd.login.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;

/**
 * 作者:dongyanjun
 * 时间：2019/12/18
 * 描述:Health
 * 功能：
 **/
public interface LoginContract {
   interface Iview extends IBaseView {
       void onLoginSuccess(LoginBean data);
       void onForgetSuccess(ForgetBean data);
       void onCheckCodeSuccess(ForgetBean data);
       void onLoginError(String e);
       void onRegisterSuccess(RegisteredBean data);
       void onRegisterError(String e);
       void onSendSuccess(SendEmilBean data);
       void onSendError(String e);
       void onHomeError(String e);
   }
   interface Imodel{
       void postLoginModel(String email,String pwd,IMoldelLoginCallBack iMoldelLoginCallBack);
       void putForgetModel(String email,String pwd1,String pwd2,IMoldelForgetCallBack iMoldelForgetCallBack);
       void postCheckCodeModel(String email,String code,IMoldelCheckCodeCallBack iMoldelCheckCodeCallBack);
       void postRegisterModel(String email,
                           String code,
                           String pwd1,
                           String pwd2,
                           String invitationCode,
                           IMoldelRegisterCallBack iMoldelRegisterCallBack);
       void postSendModel(String email,IMoldelSendCallBack iMoldelSendCallBack);

       interface IMoldelLoginCallBack {
           void onSuccess(LoginBean data);
           void onError(String e);
       }

       interface IMoldelRegisterCallBack {
           void onSuccess(RegisteredBean data);
           void onError(String e);
       }

       interface IMoldelSendCallBack {
           void onSuccess(SendEmilBean data);
           void onError(String e);
       }

       interface IMoldelForgetCallBack {
           void onSuccess(ForgetBean data);
           void onError(String e);
       }

       interface IMoldelCheckCodeCallBack {
           void onSuccess(ForgetBean data);
           void onError(String e);
       }
   }
   interface Ipresenter{
       void postLoginPresenter(String email,String pwd);
       void putForgetPresenter(String email,String pwd1,String pwd2);
       void postCheckCodePresenter(String email,String code);
       void postRegisterPresenter(String email,
                               String code,
                               String pwd1,
                               String pwd2,
                               String invitationCode);
       void postSendPresenter(String email);
   }
}
