package com.wd.health.app;
/*
 *@auther:李泽楷
 *@Date: 2019/12/20
 *@Time:17:21
 *@Description:${DESCRIPTION}
 **/

import com.bawei.lizekai.mylibrary.app.BaseApp;

import cn.jpush.im.android.api.JMessageClient;

public class App extends BaseApp {
    @Override
    public void onCreate() {
        super.onCreate();
        JMessageClient.init(this,true);
    }
}
