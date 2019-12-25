package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/25
 *@Time:10:18
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.FindMyAdoptedCommentListBean;
import com.wd.health.contract.FindyijianContract;

public class FindyijianModel implements FindyijianContract.Imodel {
    @Override
    public void Findyijian(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findyijian(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindMyAdoptedCommentListBean>() {
                    @Override
                    public void onNext(FindMyAdoptedCommentListBean findMyAdoptedCommentListBean) {
                        iModelCallBack.findyijian(findMyAdoptedCommentListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
