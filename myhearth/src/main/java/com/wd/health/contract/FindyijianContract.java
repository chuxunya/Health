package com.wd.health.contract;
/*
 *@auther:张安恒   签到
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.AddSignBean;
import com.wd.health.bean.FindMyAdoptedCommentListBean;

public interface FindyijianContract {
    interface Iview extends IBaseView {
        void findyijian(FindMyAdoptedCommentListBean findMyAdoptedCommentListBean);
    }
    interface  Imodel{
        void  Findyijian(String userId, String sessionId,String page, String count, IModelCallBack iModelCallBack);
           interface IModelCallBack {
               void findyijian(FindMyAdoptedCommentListBean findMyAdoptedCommentListBean);
               void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  Findyijian(String page, String count);
       }
}
