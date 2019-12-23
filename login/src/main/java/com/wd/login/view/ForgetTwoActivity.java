package com.wd.login.view;

import android.content.Intent;
import android.os.Bundle;
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

public class ForgetTwoActivity extends BaseActivity<LoginPresenter> implements LoginContract.Iview {


    @BindView(R2.id.img_back_forget_finish)
    ImageView imgBackForgetFinish;
    @BindView(R2.id.et_forget_pwd_finish)
    EditText etForgetPwdFinish;
    @BindView(R2.id.img_forget_bi)
    ImageView imgForgetBi;
    @BindView(R2.id.img_forget_kai)
    ImageView imgForgetKai;
    @BindView(R2.id.et_forget_pwd1_finish)
    EditText etForgetPwd1Finish;
    @BindView(R2.id.img_forget_bi1)
    ImageView imgForgetBi1;
    @BindView(R2.id.img_forget_kai1)
    ImageView imgForgetKai1;
    @BindView(R2.id.bt_finish_forget)
    Button btFinishForget;
    private int count=1;
    private String pwdOne;
    private String email;

    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_forget_two;
    }

    @Override
    public void onLoginSuccess(LoginBean data) {

    }

    @Override
    public void onForgetSuccess(ForgetBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
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

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
    }

    @OnClick({R2.id.img_back_forget_finish, R2.id.img_forget_bi, R2.id.img_forget_kai, R2.id.img_forget_bi1, R2.id.img_forget_kai1, R2.id.bt_finish_forget})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.img_back_forget_finish) {
            Intent intent = new Intent(ForgetTwoActivity.this, ForgetActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.img_forget_bi) {
            count++;
            if (count % 2 == 0) {
                imgForgetBi.setVisibility(View.GONE);
                imgForgetKai.setVisibility(View.VISIBLE);
                etForgetPwdFinish.setInputType(128);
            }
        } else if (id == R.id.img_forget_kai) {
            count++;
            if (count % 2 == 1) {
                imgForgetBi.setVisibility(View.VISIBLE);
                imgForgetKai.setVisibility(View.GONE);
                etForgetPwdFinish.setInputType(129);
            }
        } else if (id == R.id.img_forget_bi1) {
            count++;
            if (count % 2 == 0) {
                imgForgetBi1.setVisibility(View.GONE);
                imgForgetKai1.setVisibility(View.VISIBLE);
                etForgetPwd1Finish.setInputType(128);
            }
        } else if (id == R.id.img_forget_kai1) {
            count++;
            if (count % 2 == 1) {
                imgForgetBi1.setVisibility(View.VISIBLE);
                imgForgetKai1.setVisibility(View.GONE);
                etForgetPwd1Finish.setInputType(129);
            }
        } else if (id == R.id.bt_finish_forget) {
            String pwd1 = etForgetPwdFinish.getText().toString().trim();
            String pwd2 = etForgetPwd1Finish.getText().toString().trim();
            if (pwd1.equals(pwd2)) {
                try {
                    pwdOne = RsaCoder.encryptByPublicKey(pwd1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mPresenter.putForgetPresenter(email, pwdOne, pwdOne);
                Intent intent1 = new Intent(ForgetTwoActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();

            } else {
                Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
