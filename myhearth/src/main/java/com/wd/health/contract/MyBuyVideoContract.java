package com.wd.health.contract;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.MyBuyVideoBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.MydeleVideoBean;

public interface MyBuyVideoContract {
    interface Iview extends IBaseView {
        void mybuyvideo(MyBuyVideoBean myBuyVideoBean);
        void mydeletevideo(MydeleVideoBean mydeleVideoBean);
    }
    interface  Imodel{
        void  MyBuyVideo(String userId, String sessionId, String page, String count, IModelCallBack iModelCallBack);
        void  MyDeleVideo(String userId, String sessionId, String videoId, IModelCallBack iModelCallBack);
          interface IModelCallBack {
              void mybuyvideo(MyBuyVideoBean myBuyVideoBean);
              void mydeletevideo(MydeleVideoBean mydeleVideoBean);
              void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  MyBuyVideo( String page, String count);
        void  MyDeleVideo( String videoId);
    }
}
