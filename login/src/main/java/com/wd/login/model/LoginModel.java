package com.wd.login.model;


import android.widget.Toast;

import com.bawei.lizekai.mylibrary.app.BaseApp;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.NetUtil;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.login.app.ApiServer;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;
import com.wd.login.contract.LoginContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者:dongyanjun
 * 时间：2019/12/18
 * 描述:Health
 * 功能：
 **/
public class LoginModel implements LoginContract.Imodel {

    @Override
    public void postLoginModel(String email, String pwd, final IMoldelLoginCallBack iMoldelLoginCallBack) {
        if (NetUtil.hasNetwork(BaseApp.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postLogin(email, pwd)
                    .compose(CommonSchedulers.<LoginBean>io2main())
                    .subscribe(new Observer<LoginBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(LoginBean loginBean) {
                            iMoldelLoginCallBack.onSuccess(loginBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iMoldelLoginCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(BaseApp.getAppContext(), "请检查网络设置", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void putForgetModel(String email, String pwd1, String pwd2, final IMoldelForgetCallBack iMoldelForgetCallBack) {
        if (NetUtil.hasNetwork(BaseApp.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postForgetBean(email, pwd1, pwd2)
                    .compose(CommonSchedulers.<ForgetBean>io2main())
                    .subscribe(new Observer<ForgetBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ForgetBean forgetBean) {
                            iMoldelForgetCallBack.onSuccess(forgetBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iMoldelForgetCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(BaseApp.getAppContext(), "请检查网络设置", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void postCheckCodeModel(String email, String code, final IMoldelCheckCodeCallBack iMoldelCheckCodeCallBack) {
        if (NetUtil.hasNetwork(BaseApp.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .postCheckCode(email, code)
                    .compose(CommonSchedulers.<ForgetBean>io2main())
                    .subscribe(new Observer<ForgetBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ForgetBean forgetBean) {
                            iMoldelCheckCodeCallBack.onSuccess(forgetBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iMoldelCheckCodeCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            Toast.makeText(BaseApp.getAppContext(), "请检查网络设置", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void postRegisterModel(String email, String code, String pwd1, String pwd2, String invitationCode, final IMoldelRegisterCallBack iMoldelRegisterCallBack) {
        if (NetUtil.hasNetwork(BaseApp.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getRegister(email, code, pwd1, pwd2, invitationCode)
                    .compose(CommonSchedulers.<RegisteredBean>io2main())
                    .subscribe(new Observer<RegisteredBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(RegisteredBean registeredBean) {
                            iMoldelRegisterCallBack.onSuccess(registeredBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iMoldelRegisterCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(BaseApp.getAppContext(), "请检查网络设置", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void postSendModel(String email, final IMoldelSendCallBack iMoldelSendCallBack) {
        if (NetUtil.hasNetwork(BaseApp.getAppContext())) {
            RetrofitManager.getInstance().create(ApiServer.class)
                    .getSendEmil(email)
                    .compose(CommonSchedulers.<SendEmilBean>io2main())
                    .subscribe(new Observer<SendEmilBean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SendEmilBean sendEmilBean) {
                            iMoldelSendCallBack.onSuccess(sendEmilBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iMoldelSendCallBack.onError(e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else {
            Toast.makeText(BaseApp.getAppContext(), "请检查网络设置", Toast.LENGTH_SHORT).show();
        }
    }
}
