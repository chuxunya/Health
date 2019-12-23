package com.wd.home.contract;

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.CommentCircleBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.KeywordSearchBean;
import com.wd.home.bean.PatientDetailsBean;
import com.wd.home.bean.QueryCommentBean;

/**
 * @name Health
 * @class name：com.wd.home.contract
 * @anthor 查询病友圈详情 病友圈发表评论 查询病友圈评论列表
 * @time 2019/12/21 10:09
 */
public interface SickCircleContract {

    interface Iview extends IBaseView {
        //查询病友圈详情
        void sickcircleinfo(PatientDetailsBean patientDetailsBean);
        //病友圈发表评论
        void publishcomment(CommentCircleBean commentCircleBean);
        //查询病友圈评论列表
        void querycommentbean(QueryCommentBean queryCommentBean);


    }

    interface Imodel {
        //查询病友圈详情
        void sickcircleinfo(int sickCircleId,IModelICallBack iModelICallBack);
        //病友圈发表评论
        void publishcomment(int userId, String sessionId, int sickCircleId,String content,
                              IModelICallBack iModelICallBack);
        //查询病友圈评论列表
        void querycommentbean(int sickCircleId,int page,int count, IModelICallBack iModelICallBack);


        interface IModelICallBack {

            //查询病友圈详情
            void sickcircleinfo(int sickCircleId,PatientDetailsBean patientDetailsBean);
            //病友圈发表评论
            void publishcomment(int userId, String sessionId, int sickCircleId,String content,
                                CommentCircleBean commentCircleBean);
            //查询病友圈评论列表
            void querycommentbean(int sickCircleId,int page,int count,QueryCommentBean queryCommentBean);

        }
    }

    interface IPresenter {

        void sickcircleinfo(int sickCircleId);
        void publishcomment(int userId, String sessionId, int sickCircleId,String content);
        void querycommentbean(int sickCircleId,int page,int count);

    }
}
