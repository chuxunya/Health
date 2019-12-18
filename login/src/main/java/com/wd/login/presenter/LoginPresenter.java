package com.wd.login.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;
import com.wd.login.contract.LoginContract;
import com.wd.login.model.LoginModel;

/**
 * 作者:dongyanjun
 * 时间：2019/12/18
 * 描述:Health
 * 功能：
 **/
public class LoginPresenter extends BasePresenter<LoginContract.Iview> implements LoginContract.Ipresenter {

    private LoginModel loginModel;

    /**
     * 初始化model
     */
    @Override
    protected void initModel() {
        loginModel = new LoginModel();
    }

    @Override
    public void postLoginPresenter(String email, String pwd) {
        loginModel.postLoginModel(email, pwd, new LoginContract.Imodel.IMoldelLoginCallBack() {
            @Override
            public void onSuccess(LoginBean data) {
                getView().onLoginSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onLoginError(e);
            }
        });
    }

    @Override
    public void putForgetPresenter(String email, String pwd1, String pwd2) {
        loginModel.putForgetModel(email, pwd1, pwd2, new LoginContract.Imodel.IMoldelForgetCallBack() {
            @Override
            public void onSuccess(ForgetBean data) {
                getView().onForgetSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postCheckCodePresenter(String email, String code) {
        loginModel.postCheckCodeModel(email, code, new LoginContract.Imodel.IMoldelCheckCodeCallBack() {
            @Override
            public void onSuccess(ForgetBean data) {
                getView().onCheckCodeSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onHomeError(e);
            }
        });
    }

    @Override
    public void postRegisterPresenter(String email, String code, String pwd1, String pwd2, String invitationCode) {
        loginModel.postRegisterModel(email, code, pwd1, pwd2, invitationCode, new LoginContract.Imodel.IMoldelRegisterCallBack() {
            @Override
            public void onSuccess(RegisteredBean data) {
                getView().onRegisterSuccess(data);
            }

            @Override
            public void onError(String e) {
                getView().onRegisterError(e);
            }
        });
    }

    @Override
    public void postSendPresenter(String email) {
            loginModel.postSendModel(email, new LoginContract.Imodel.IMoldelSendCallBack() {
                @Override
                public void onSuccess(SendEmilBean data) {
                    getView().onSendSuccess(data);
                }

                @Override
                public void onError(String e) {
                    getView().onSendError(e);
                }
            });
    }
}
