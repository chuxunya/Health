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

public class JMessageRegisterActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jmessage_register);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.button2})
    public void onClick(View view) {
        String userName = editText.getText().toString();
        String pwd = editText2.getText().toString();
        switch (view.getId()) {

            case R.id.button:

                JMessageClient.register(userName, pwd, new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {
                        Log.i("register1",i+"");
                        Log.i("register1",s);
                    }
                });
                break;
            case R.id.button2:
                JMessageClient.login(userName, pwd, new BasicCallback() {
                    @Override
                    public void gotResult(int i, String s) {
                        Log.i("login1",i+"");
                        Log.i("login1",s);
                        if (i==0){
                        startActivity(new Intent(JMessageRegisterActivity.this,JgActivity.class));
                        }else {
                            Toast.makeText(JMessageRegisterActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }
}
