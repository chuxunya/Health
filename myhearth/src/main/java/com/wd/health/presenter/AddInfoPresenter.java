package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:10:14
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.VideoInfoBean;
import com.wd.health.contract.AddInfoContract;
import com.wd.health.model.AddInfoModel;

public class AddInfoPresenter extends BasePresenter<AddInfoContract.Iview> implements AddInfoContract.IPresenter {
    private String userId="435";
    private String sessionId="1577693387272435";

    private AddInfoModel addInfoModel;

    @Override
    protected void initModel() {
        addInfoModel = new AddInfoModel();
    }

    @Override
    public void AddInfoCollect(String page, String count) {
        addInfoModel.AddInfoCollect(userId, sessionId, page, count, new AddInfoContract.Imodel.IModelCallBack() {
            @Override
            public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {
                getView().addinfocollect(addInfoCollectBean);
            }

            @Override
            public void findvideo(VideoInfoBean videoInfoBean) {

            }

            @Override
            public void deleteinfo(DeInfoBean deInfoBean) {

            }

            @Override
            public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

            }

            @Override
            public void findquan(FindquanBean findquanBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void FindVideo(String page, String count) {
        addInfoModel.FindVideo(userId, sessionId, page, count, new AddInfoContract.Imodel.IModelCallBack() {
            @Override
            public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

            }

            @Override
            public void findvideo(VideoInfoBean videoInfoBean) {
            getView().findvideo(videoInfoBean);
            }

            @Override
            public void deleteinfo(DeInfoBean deInfoBean) {

            }

            @Override
            public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

            }

            @Override
            public void findquan(FindquanBean findquanBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void FindQuan(String page, String count) {
        addInfoModel.FindQuan(userId, sessionId, page, count, new AddInfoContract.Imodel.IModelCallBack() {
            @Override
            public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

            }

            @Override
            public void findvideo(VideoInfoBean videoInfoBean) {

            }

            @Override
            public void deleteinfo(DeInfoBean deInfoBean) {

            }

            @Override
            public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

            }

            @Override
            public void findquan(FindquanBean findquanBean) {
                getView().findquan(findquanBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void DeleInfo(String infoId) {
        addInfoModel.DeleInfo(userId, sessionId, infoId, new AddInfoContract.Imodel.IModelCallBack() {
            @Override
            public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

            }

            @Override
            public void findvideo(VideoInfoBean videoInfoBean) {

            }

            @Override
            public void deleteinfo(DeInfoBean deInfoBean) {
            getView().deleteinfo(deInfoBean);
            }

            @Override
            public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {

            }

            @Override
            public void findquan(FindquanBean findquanBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void DeleVideo(String videoId) {
        addInfoModel.DeleVideo(userId, sessionId, videoId, new AddInfoContract.Imodel.IModelCallBack() {
            @Override
            public void addinfocollect(AddInfoCollectBean addInfoCollectBean) {

            }

            @Override
            public void findvideo(VideoInfoBean videoInfoBean) {

            }

            @Override
            public void deleteinfo(DeInfoBean deInfoBean) {

            }

            @Override
            public void delevideo(DeleVideoInfoBean deleVideoInfoBean) {
                    getView().delevideo(deleVideoInfoBean);
            }

            @Override
            public void findquan(FindquanBean findquanBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }


}
