package com.wd.home.presenter;

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.home.bean.CommentCircleBean;
import com.wd.home.bean.PatientDetailsBean;
import com.wd.home.bean.QueryCommentBean;
import com.wd.home.contract.BannerContract;
import com.wd.home.contract.SickCircleContract;
import com.wd.home.model.SickCircleModel;

/**
 * @name Health
 * @class name：com.wd.home.presenter
 * @anthor hp
 * @time 2019/12/21 10:30
 */
public class SickCirclePresenter extends BasePresenter<SickCircleContract.Iview> implements SickCircleContract.IPresenter {


    private SickCircleModel sickCircleModel;

    @Override
    protected void initModel() {
        sickCircleModel = new SickCircleModel();
    }

    @Override
    public void sickcircleinfo(int sickCircleId) {
        sickCircleModel.sickcircleinfo(sickCircleId, new SickCircleContract.Imodel.IModelICallBack() {
            @Override
            public void sickcircleinfo(int sickCircleId, PatientDetailsBean patientDetailsBean) {
                getView().sickcircleinfo(patientDetailsBean);
            }

            @Override
            public void publishcomment(int userId, String sessionId, int sickCircleId, String content, CommentCircleBean commentCircleBean) {

            }

            @Override
            public void querycommentbean(int sickCircleId, int page, int count, QueryCommentBean queryCommentBean) {

            }
        });
    }

    @Override
    public void publishcomment(int userId, String sessionId, int sickCircleId, String content) {
         sickCircleModel.publishcomment(userId, sessionId, sickCircleId, content, new SickCircleContract.Imodel.IModelICallBack() {
             @Override
             public void sickcircleinfo(int sickCircleId, PatientDetailsBean patientDetailsBean) {

             }

             @Override
             public void publishcomment(int userId, String sessionId, int sickCircleId, String content, CommentCircleBean commentCircleBean) {
                           getView().publishcomment(commentCircleBean);
             }

             @Override
             public void querycommentbean(int sickCircleId, int page, int count, QueryCommentBean queryCommentBean) {

             }
         });
    }

    @Override
    public void querycommentbean(int sickCircleId, int page, int count) {
        sickCircleModel.querycommentbean(sickCircleId, page, count, new SickCircleContract.Imodel.IModelICallBack() {
            @Override
            public void sickcircleinfo(int sickCircleId, PatientDetailsBean patientDetailsBean) {

            }

            @Override
            public void publishcomment(int userId, String sessionId, int sickCircleId, String content, CommentCircleBean commentCircleBean) {

            }

            @Override
            public void querycommentbean(int sickCircleId, int page, int count, QueryCommentBean queryCommentBean) {
                 getView().querycommentbean(queryCommentBean);
            }
        });
    }
}
