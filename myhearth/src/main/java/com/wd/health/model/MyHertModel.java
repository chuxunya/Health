package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:20:46
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.AddSignBean;
import com.wd.health.contract.MyHertContract;

public class MyHertModel implements MyHertContract.Imodel {
    @Override
    public void Addsign(String userId, String sessionId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .addsign(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<AddSignBean>() {
                    @Override
                    public void onNext(AddSignBean addSignBean) {
                        iModelCallBack.addsign(addSignBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
