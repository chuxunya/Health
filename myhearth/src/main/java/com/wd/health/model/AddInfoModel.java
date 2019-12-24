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
import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.contract.AddInfoContract;
import com.wd.health.contract.MyWalletContract;

public class AddInfoModel implements AddInfoContract.Imodel {

    @Override
    public void AddInfoCollect(String userId, String sessionId, String page, String count,IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .addinfocollect(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<AddInfoCollectBean>() {
                    @Override
                    public void onNext(AddInfoCollectBean addInfoCollectBean) {
                        iModelCallBack.addinfocollect(addInfoCollectBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });

    }

    @Override
    public void FindVideo(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findvideo(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<VideoInfoBean>() {
                    @Override
                    public void onNext(VideoInfoBean videoInfoBean) {
                        iModelCallBack.findvideo(videoInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void FindQuan(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .findquan(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindquanBean>() {
                    @Override
                    public void onNext(FindquanBean findquanBean) {
                        iModelCallBack.findquan(findquanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void DeleInfo(String userId, String sessionId, String infoId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .deleteinfo(userId,sessionId,infoId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DeInfoBean>() {
                    @Override
                    public void onNext(DeInfoBean deInfoBean) {
                        iModelCallBack.deleteinfo(deInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }

    @Override
    public void DeleVideo(String userId, String sessionId, String videoId, IModelCallBack iModelCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .delevideo(userId,sessionId,videoId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DeleVideoInfoBean>() {
                    @Override
                    public void onNext(DeleVideoInfoBean deleVideoInfoBean) {
                        iModelCallBack.delevideo(deleVideoInfoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onFraily(e.getMessage());
                    }
                });
    }
}
