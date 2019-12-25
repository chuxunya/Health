package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:9:32
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.contract.MyWalletContract;

public class MyWalletModel implements MyWalletContract.Imodel {

    @Override
    public void MyWallet(String userId, String sessionId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .wallet(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MyWalletBean>() {
                    @Override
                    public void onNext(MyWalletBean myWalletBean) {
                        iModelCallBack.mywallet(myWalletBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });

    }

    @Override
    public void FindUserRC(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findusercr(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindUserCRBean>() {
                    @Override
                    public void onNext(FindUserCRBean findUserCRBean) {
                        iModelCallBack.findusercr(findUserCRBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
