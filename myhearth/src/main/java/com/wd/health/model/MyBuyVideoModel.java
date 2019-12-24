package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:15:36
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.MydeleVideoBean;
import com.wd.health.contract.MyBuyVideoContract;

public class MyBuyVideoModel implements MyBuyVideoContract.Imodel {
    @Override
    public void MyBuyVideo(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mybuyvideo(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyBuyVideoBean>() {
                    @Override
                    public void onNext(MyBuyVideoBean myBuyVideoBean) {
                        iModelCallBack.mybuyvideo(myBuyVideoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void MyDeleVideo(String userId, String sessionId, String videoId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .mydeletevideo(userId,sessionId,videoId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MydeleVideoBean>() {
                    @Override
                    public void onNext(MydeleVideoBean mydeleVideoBean) {
                        iModelCallBack.mydeletevideo(mydeleVideoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
