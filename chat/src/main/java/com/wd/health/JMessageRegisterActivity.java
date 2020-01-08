package com.wd.health;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;
/**
 *@describe(描述)：JMessageRegisterActivity
 *@data（日期）: 2019/12/31
 *@time（时间）: 14:08
 *@author（作者）: xin
 **/
public class JMessageRegisterActivity extends AppCompatActivity {

    @BindView(R2.id.editText)
    EditText editText;
    @BindView(R2.id.editText2)
    EditText editText2;
    @BindView(R2.id.button)
    Button button;
    @BindView(R2.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jmessage_register);
        ButterKnife.bind(this);
    }


    @OnClick({R2.id.button, R2.id.button2})
    public void onClick(View view) {
        String userName = editText.getText().toString();
        String pwd = editText2.getText().toString();
        int id = view.getId();
        if (id == R.id.button) {
            JMessageClient.register(userName, pwd, new BasicCallback() {
                @Override
                public void gotResult(int i, String s) {
                    Log.i("register1", i + "");
                    Log.i("register1", s);
                }
            });
        } else if (id == R.id.button2) {
            JMessageClient.login(userName, pwd, new BasicCallback() {
                @Override
                public void gotResult(int i, String s) {
                    Log.i("login1", i + "");
                    Log.i("login1", s);
                    if (i == 0) {
                        startActivity(new Intent(JMessageRegisterActivity.this, JgActivity.class));
                    } else {
                        Toast.makeText(JMessageRegisterActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
