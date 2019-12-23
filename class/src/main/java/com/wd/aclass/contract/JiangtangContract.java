package com.wd.aclass.contract;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.DanmuBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;

public interface JiangtangContract {
    interface Iview extends IBaseView {
        void jiangtang(JiangtangBean jiangtangBean);
        void JiangVideo(VideoBean videoBean);
        void  AddVideo(AddVideoBean addVideoBean);
        void  BuyVideo(BuyVideoBean buyVideoBean);
        void  Danmu(DanmuBean danmuBean);
        void onFraily(String e);
    }
    interface  Imodel{
        void  jiangtang(IModelCallBack iModelCallBack);
        void  JiangVideo(String userId, String sessionId, String categoryId, String page, String count, IModelCallBack iModelCallBack);
        void  AddVideo(String userId, String sessionId, String videoId,  IModelCallBack iModelCallBack);
        void  BuyVideo(String userId, String sessionId, String videoId,String price,IModelCallBack iModelCallBack);
        void  Danmu(String userId, String sessionId, String videoId,String content,IModelCallBack iModelCallBack);
        interface IModelCallBack {
            void jiangtang(JiangtangBean jiangtangBean);
            void JiangVideo(VideoBean videoBean);
            void  AddVideo(AddVideoBean addVideoBean);
            void  BuyVideo(BuyVideoBean buyVideoBean);
            void  Danmu(DanmuBean danmuBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  jiangtang();
        void  JiangVideo( String categoryId, String page, String count);
        void  AddVideo( String videoId);
        void  BuyVideo( String videoId,String price);
        void  Danmu( String videoId,String content);
    }
}
