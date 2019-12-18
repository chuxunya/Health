package com.wd.chat.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.lizekai.mylibrary.base.BaseActivity;
import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.chat.R;
/**
 *@describe(描述)：评论列表
 *@data（日期）: 2019/12/18
 *@time（时间）: 19:04
 *@author（作者）: xin
 **/
public class CommentActivity extends BaseActivity {

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_comment;
    }
}
