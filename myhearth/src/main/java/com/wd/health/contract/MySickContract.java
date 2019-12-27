package com.wd.health.contract;
/*
 *@auther:张安恒    我的病友圈
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.AddSignBean;
import com.wd.health.bean.MySickCircleCommentListBean;
import com.wd.health.bean.MySickCircleListBean;

public interface MySickContract {
    interface Iview extends IBaseView {
        void mysick(MySickCircleListBean mySickCircleListBean);
        void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean);

    }
    interface  Imodel{
        void  MySick(String userId, String sessionId, String page, String count,IModelCallBack iModelCallBack);
        void  MySickCircleCommentList(String userId, String sessionId,String sickCircleId, String page, String count,IModelCallBack iModelCallBack);
           interface IModelCallBack {
               void mysick(MySickCircleListBean mySickCircleListBean);
               void mySickCircleCommentList(MySickCircleCommentListBean mySickCircleCommentListBean);
               void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  MySick( String page, String count);
        void  MySickCircleCommentList(String sickCircleId, String page, String count);
       }
}
