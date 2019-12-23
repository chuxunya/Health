package com.wd.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;
import com.wd.login.contract.LoginContract;
import com.wd.login.presenter.LoginPresenter;
import com.wd.login.view.ForgetActivity;
import com.wd.login.view.RegisterActivity;
import com.wd.login.view.RsaCoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/login/LoginActivity")
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {

    @BindView(R2.id.login_edit_email)
    EditText loginEditEmail;
    @BindView(R2.id.login_image_false)
    ImageView loginImageFalse;
    @BindView(R2.id.login_image_true)
    ImageView loginImageTrue;
    @BindView(R2.id.login_edit_pwd)
    EditText loginEditPwd;
    @BindView(R2.id.login_button_login)
    Button loginButtonLogin;
    @BindView(R2.id.relate_view)
    RelativeLayout relateView;
    @BindView(R2.id.login_button_updateuserpwd)
    TextView loginButtonUpdateuserpwd;
    @BindView(R2.id.login_button_register)
    LinearLayout loginButtonRegister;
    @BindView(R2.id.login_button_wx)
    ImageView loginButtonWx;
    private String rsaPwd;
    private int count=1;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void onLoginSuccess(LoginBean data) {
        String message = data.getMessage();

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onForgetSuccess(ForgetBean data) {

    }

    @Override
    public void onCheckCodeSuccess(ForgetBean data) {

    }

    @Override
    public void onLoginError(String e) {

    }

    @Override
    public void onRegisterSuccess(RegisteredBean data) {

    }

    @Override
    public void onRegisterError(String e) {

    }

    @Override
    public void onSendSuccess(SendEmilBean data) {

    }

    @Override
    public void onSendError(String e) {

    }

    @Override
    public void onHomeError(String e) {

    }


    @OnClick({R2.id.login_image_false, R2.id.login_image_true, R2.id.login_button_login, R2.id.login_button_updateuserpwd, R2.id.login_button_register, R2.id.login_button_wx})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.login_image_false) {
            count++;
            if (count%2==0) {
                loginImageFalse.setVisibility(View.GONE);
                loginImageTrue.setVisibility(View.VISIBLE);
                loginEditPwd.setInputType(128);
            }
        } else if (i == R.id.login_image_true) {
            count++;
            if (count%2==1) {
                loginImageFalse.setVisibility(View.VISIBLE);
                loginImageTrue.setVisibility(View.GONE);
                loginEditPwd.setInputType(129);
            }
        } else if (i == R.id.login_button_login) {
            String email = loginEditEmail.getText().toString().trim();
            String pwd = loginEditPwd.getText().toString().trim();
            if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pwd)) {
                Toast.makeText(this, "邮箱或者密码为空", Toast.LENGTH_SHORT).show();
            }else {
                try {
                    rsaPwd = RsaCoder.encryptByPublicKey(pwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mPresenter.postLoginPresenter(email,rsaPwd);
            }
        } else if (i == R.id.login_button_updateuserpwd) {
            Intent intent1 = new Intent(LoginActivity.this, ForgetActivity.class);
            startActivity(intent1);
            finish();
        } else if (i == R.id.login_button_register) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        } else if (i == R.id.login_button_wx) {

        }
    }
}
