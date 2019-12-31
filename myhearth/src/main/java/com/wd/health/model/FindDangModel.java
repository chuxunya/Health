package com.wd.health.model;
/*
 *@auther:张安恒
 *@Date: 2019/12/30
 *@Time:10:22
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.utils.CommonObserver;
import com.bawei.lizekai.mylibrary.utils.CommonSchedulers;
import com.bawei.lizekai.mylibrary.utils.RetrofitManager;
import com.wd.health.api.IApi;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.XiuBean;
import com.wd.health.contract.FindDangContract;

import java.util.HashMap;

public class FindDangModel implements FindDangContract.Imodel {
    @Override
    public void FindDang(String userId, String sessionId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .finddang(userId,sessionId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindUserArchivesBean>() {
                    @Override
                    public void onNext(FindUserArchivesBean findUserArchivesBean) {
                        iModelCallBack.finddang(findUserArchivesBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void DeleDang(String userId, String sessionId, String archivesId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .deledang(userId,sessionId,archivesId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DeleDangBean>() {
                    @Override
                    public void onNext(DeleDangBean deleDangBean) {
                        iModelCallBack.deledang(deleDangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void XiuDang(String userId, String sessionId, HashMap<String, String> map, IModelCallBack iModelCallBack) {
            RetrofitManager.getInstance().create(IApi.class)
                    .xiuuser(userId,sessionId,map)
                    .compose(CommonSchedulers.io2main())
                     .subscribe(new CommonObserver<XiuBean>() {
                         @Override
                         public void onNext(XiuBean xiuBean) {
                             iModelCallBack.xiudang(xiuBean);
                         }

                         @Override
                         public void onError(Throwable e) {
                             iModelCallBack.onFraily(e.getMessage());
                         }
                     });
    }
}
