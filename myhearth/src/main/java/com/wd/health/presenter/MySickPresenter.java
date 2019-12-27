package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/27
 *@Time:10:26
 *@Description:  病友圈
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;
import com.wd.health.contract.MySickContract;
import com.wd.health.model.MySickModel;

public class MySickPresenter extends BasePresenter<MySickContract.Iview> implements MySickContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";
    private MySickModel mySickModel;

    @Override
    protected void initModel() {
        mySickModel = new MySickModel();
    }

    @Override
    public void MySick(String page, String count) {
        mySickModel.MySick(userId, sessionId, page, count, new MySickContract.Imodel.IModelCallBack() {
            @Override
            public void mysick(MySickCircleListBean mySickCircleListBean) {
                getView().mysick(mySickCircleListBean);
            }

            @Override
            public void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void MySickCircleCommentList(String sickCircleId, String page, String count) {
        mySickModel.MySickCircleCommentList(userId, sessionId, sickCircleId, page, count, new MySickContract.Imodel.IModelCallBack() {
            @Override
            public void mysick(MySickCircleListBean mySickCircleListBean) {

            }

            @Override
            public void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean) {
                getView().mySickCircleCommentList(mySickCircleCommentListBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
