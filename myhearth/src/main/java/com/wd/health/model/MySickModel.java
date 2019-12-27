package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/27
 *@Time:10:24
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.contract.MySickContract;

public class MySickModel implements MySickContract.Imodel {
    @Override
    public void MySick(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .getMySickCircleList(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MySickCircleListBean>() {
                    @Override
                    public void onNext(MySickCircleListBean mySickCircleListBean) {
                        iModelCallBack.mysick(mySickCircleListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void MySickCircleCommentList(String userId, String sessionId, String sickCircleId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .getMySickCircleCommentList(userId,sessionId,sickCircleId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<MySickCircleCommentListBean>() {
                    @Override
                    public void onNext(MySickCircleCommentListBean mySickCircleCommentListBean) {
                        iModelCallBack.mySickCircleCommentList(mySickCircleCommentListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
