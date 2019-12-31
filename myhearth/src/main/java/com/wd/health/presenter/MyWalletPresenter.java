package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:9:35
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.contract.MyWalletContract;
import com.wd.health.model.MyWalletModel;

public class MyWalletPresenter extends BasePresenter<MyWalletContract.Iview> implements MyWalletContract.IPresenter {

    private MyWalletModel myWalletModel;
    private String userId="435";
    private String sessionId="1577693387272435";

    @Override
    protected void initModel() {
        myWalletModel = new MyWalletModel();
    }

    @Override
    public void MyWallet() {
        myWalletModel.MyWallet(userId, sessionId, new MyWalletContract.Imodel.IModelCallBack() {
            @Override
            public void mywallet(MyWalletBean myWalletBean) {
                getView().mywallet(myWalletBean);
            }

            @Override
            public void findusercr(FindUserCRBean findUserCRBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void FindUserRC(String page, String count) {
        myWalletModel.FindUserRC(userId, sessionId, page, count, new MyWalletContract.Imodel.IModelCallBack() {
            @Override
            public void mywallet(MyWalletBean myWalletBean) {

            }

            @Override
            public void findusercr(FindUserCRBean findUserCRBean) {
                getView().findusercr(findUserCRBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
