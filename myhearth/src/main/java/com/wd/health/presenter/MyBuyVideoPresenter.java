package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:15:38
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.MydeleVideoBean;
import com.wd.health.contract.MyBuyVideoContract;
import com.wd.health.model.MyBuyVideoModel;

public class MyBuyVideoPresenter extends BasePresenter<MyBuyVideoContract.Iview> implements MyBuyVideoContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";

    private MyBuyVideoModel myBuyVideoModel;

    @Override
    protected void initModel() {
        myBuyVideoModel = new MyBuyVideoModel();
    }

    @Override
    public void MyBuyVideo(String page, String count) {
        myBuyVideoModel.MyBuyVideo(userId, sessionId, page, count, new MyBuyVideoContract.Imodel.IModelCallBack() {
            @Override
            public void mybuyvideo(MyBuyVideoBean myBuyVideoBean) {
                getView().mybuyvideo(myBuyVideoBean);
            }

            @Override
            public void mydeletevideo(MydeleVideoBean mydeleVideoBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void MyDeleVideo(String videoId) {
        myBuyVideoModel.MyDeleVideo(userId, sessionId, videoId, new MyBuyVideoContract.Imodel.IModelCallBack() {
            @Override
            public void mybuyvideo(MyBuyVideoBean myBuyVideoBean) {

            }

            @Override
            public void mydeletevideo(MydeleVideoBean mydeleVideoBean) {
                getView().mydeletevideo(mydeleVideoBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
