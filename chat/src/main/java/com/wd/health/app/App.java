package com.wd.health.app;
/*
 *@auther:李泽楷
 *@Date: 2019/12/20
 *@Time:17:21
 *@Description:${DESCRIPTION}
 **/

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.lizekai.mylibrary.app.BaseApp;
import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.im.android.api.JMessageClient;

public class App extends BaseApp {


    //全局上下文
    private static BaseApp sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        Fresco.initialize(this);
        JMessageClient.init(this,true);
    }

    public static BaseApp getAppContext() {
        return sContext;
    }
}
