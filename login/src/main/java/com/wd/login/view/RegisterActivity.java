package com.wd.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.wd.login.LoginActivity;
import com.wd.login.R;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;
import com.wd.login.contract.LoginContract;
import com.wd.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {

    @BindView(R.id.registered_icon_logo)
    ImageView registeredIconLogo;
    @BindView(R.id.iv_mail_n)
    ImageView ivMailN;
    @BindView(R.id.registered_et_youxiang)
    EditText registeredEtYouxiang;
    @BindView(R.id.registered_cb_code)
    Button registeredCbCode;
    @BindView(R.id.icon_verification)
    ImageView iconVerification;
    @BindView(R.id.registered_et_code)
    EditText registeredEtCode;
    @BindView(R.id.icon_lock_one)
    ImageView iconLockOne;
    @BindView(R.id.registered_et_pwd)
    EditText registeredEtPwd;
    @BindView(R.id.registered_icon_yan_false)
    ImageView registeredIconYanFalse;
    @BindView(R.id.registered_icon_yan_true)
    ImageView registeredIconYanTrue;
    @BindView(R.id.icon_lock_two)
    ImageView iconLockTwo;
    @BindView(R.id.registered_et_pwdtwo)
    EditText registeredEtPwdtwo;
    @BindView(R.id.registered_icon_yan_false_two)
    ImageView registeredIconYanFalseTwo;
    @BindView(R.id.registered_icon_yan_true_two)
    ImageView registeredIconYanTrueTwo;
    @BindView(R.id.icon_invitatiion)
    ImageView iconInvitatiion;
    @BindView(R.id.registered_et_yaoqing)
    EditText registeredEtYaoqing;
    @BindView(R.id.registered_bt_zhuce)
    Button registeredBtZhuce;
    private int count=1;
    private String pwdRsa;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void onLoginSuccess(LoginBean data) {

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
        String message = data.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        if (message.equals("注册成功")) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onRegisterError(String e) {

    }

    @Override
    public void onSendSuccess(SendEmilBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSendError(String e) {

    }

    @Override
    public void onHomeError(String e) {

    }


    @OnClick({R.id.registered_cb_code, R.id.icon_verification, R.id.icon_lock_one, R.id.registered_icon_yan_false, R.id.registered_icon_yan_true, R.id.icon_lock_two, R.id.registered_icon_yan_false_two, R.id.registered_icon_yan_true_two, R.id.icon_invitatiion, R.id.registered_bt_zhuce})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.registered_cb_code:
                String email = registeredEtYouxiang.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(this, "邮箱为空", Toast.LENGTH_SHORT).show();
                }else {
                    mPresenter.postSendPresenter(email);
                }
                break;
            case R.id.icon_verification:
                break;
            case R.id.icon_lock_one:
                break;
            case R.id.registered_icon_yan_false:
                count++;
                if (count%2==0) {
                    //隐藏闭眼
                    registeredIconYanFalse.setVisibility(View.GONE);
                    //显示睁眼
                    registeredIconYanTrue.setVisibility(View.VISIBLE);
                    //显示密码
                    registeredEtPwd.setInputType(128);
                }
                break;
            case R.id.registered_icon_yan_true:
                count++;
                if (count%2==1) {
                    //隐藏闭眼
                    registeredIconYanFalse.setVisibility(View.VISIBLE);
                    //显示睁眼
                    registeredIconYanTrue.setVisibility(View.GONE);
                    //显示密码
                    registeredEtPwd.setInputType(129);
                }
                break;
            case R.id.icon_lock_two:
                break;
            case R.id.registered_icon_yan_false_two:
                count++;
                if (count%2==0) {
                    //隐藏闭眼
                    registeredIconYanFalseTwo.setVisibility(View.GONE);
                    //显示睁眼
                    registeredIconYanTrueTwo.setVisibility(View.VISIBLE);
                    //显示密码
                    registeredEtPwdtwo.setInputType(128);
                }
                break;
            case R.id.registered_icon_yan_true_two:
                count++;
                if (count%2==1) {
                    //隐藏闭眼
                    registeredIconYanFalseTwo.setVisibility(View.VISIBLE);
                    //显示睁眼
                    registeredIconYanTrueTwo.setVisibility(View.GONE);
                    //显示密码
                    registeredEtPwdtwo.setInputType(129);
                }
                break;
            case R.id.icon_invitatiion:
                break;
            case R.id.registered_bt_zhuce:
                String email1 = registeredEtYouxiang.getText().toString().trim();
                String code = registeredEtCode.getText().toString().trim();
                String pwd = registeredEtPwd.getText().toString().trim();
                String pwdTwo = registeredEtPwdtwo.getText().toString().trim();
                if (TextUtils.isEmpty(email1)||TextUtils.isEmpty(code)||TextUtils.isEmpty(pwd)||TextUtils.isEmpty(pwdTwo)) {
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                }else if (!pwd.equals(pwdTwo)){
                    Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        pwdRsa = RsaCoder.encryptByPublicKey(pwd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    mPresenter.postRegisterPresenter(email1,code,pwdRsa,pwdRsa,"");
                }
                break;
        }
    }
}
