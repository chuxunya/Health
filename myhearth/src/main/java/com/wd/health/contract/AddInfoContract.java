package com.wd.health.contract;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.AddInfoCollectBean;
import com.wd.health.bean.DeInfoBean;
import com.wd.health.bean.DeleVideoInfoBean;
import com.wd.health.bean.FindquanBean;
import com.wd.health.bean.MyWalletBean;
import com.wd.health.bean.VideoInfoBean;

public interface AddInfoContract {
    interface Iview extends IBaseView {
        void addinfocollect(AddInfoCollectBean addInfoCollectBean);
        void findvideo(VideoInfoBean videoInfoBean);
        void deleteinfo(DeInfoBean deInfoBean);
        void delevideo(DeleVideoInfoBean deleVideoInfoBean);
        void findquan(FindquanBean findquanBean);
    }
    interface  Imodel{
        void  AddInfoCollect(String userId, String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  FindVideo(String userId, String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  FindQuan(String userId, String sessionId,String page,String count, IModelCallBack iModelCallBack);
        void  DeleInfo(String userId, String sessionId,String infoId, IModelCallBack iModelCallBack);
        void  DeleVideo(String userId, String sessionId,String videoId, IModelCallBack iModelCallBack);
          interface IModelCallBack {
              void addinfocollect(AddInfoCollectBean addInfoCollectBean);
              void findvideo(VideoInfoBean videoInfoBean);
              void deleteinfo(DeInfoBean deInfoBean);
              void delevideo(DeleVideoInfoBean deleVideoInfoBean);
              void findquan(FindquanBean findquanBean);
              void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  AddInfoCollect(String page,String count);
        void  FindVideo(String page,String count);
        void  FindQuan(String page,String count);
        void  DeleInfo(String infoId);
        void  DeleVideo(String videoId);
    }
}
