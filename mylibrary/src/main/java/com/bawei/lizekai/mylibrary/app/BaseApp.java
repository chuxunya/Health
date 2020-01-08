package com.bawei.lizekai.mylibrary.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

import cn.jpush.im.android.api.JMessageClient;

public class BaseApp extends Application {
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
