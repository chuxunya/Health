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
import com.wd.login.R2;
import com.wd.login.bean.ForgetBean;
import com.wd.login.bean.LoginBean;
import com.wd.login.bean.RegisteredBean;
import com.wd.login.bean.SendEmilBean;
import com.wd.login.contract.LoginContract;
import com.wd.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {

    @BindView(R2.id.img_back_forget)
    ImageView imgBackForget;
    @BindView(R2.id.et_forget_email)
    EditText etForgetEmail;
    @BindView(R2.id.bt_code_forget)
    Button btCodeForget;
    @BindView(R2.id.et_forget_pwd)
    EditText etForgetPwd;
    @BindView(R2.id.bt_next_forget)
    Button btNextForget;
    private String email;
    private String code;
    private String message;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onForgetSuccess(ForgetBean data) {

    }

    @Override
    public void onCheckCodeSuccess(ForgetBean data) {
        message = data.getMessage();
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if (message.equals("验证通过")){
            Intent intent = new Intent(ForgetActivity.this, ForgetTwoActivity.class);
            intent.putExtra("email",email);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSendError(String e) {

    }

    @Override
    public void onHomeError(String e) {

    }



    @OnClick({R2.id.img_back_forget, R2.id.bt_code_forget, R2.id.bt_next_forget})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.img_back_forget) {
            Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.bt_code_forget) {
            email = etForgetEmail.getText().toString().trim();
            mPresenter.postSendPresenter(email);
        } else if (id == R.id.bt_next_forget) {
            String trim = etForgetEmail.getText().toString().trim();
            code = etForgetPwd.getText().toString().trim();
            if (TextUtils.isEmpty(trim) || TextUtils.isEmpty(code)) {
                Toast.makeText(this, "邮箱或验证码为空", Toast.LENGTH_SHORT).show();
            } else {
                mPresenter.postCheckCodePresenter(trim, code);
            }
        }
    }
}
