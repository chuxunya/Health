package com.wd.health.contract;
/*
 *@auther:张安恒  修改用户档案  用户查看自己的档案  删除档案
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.FindMyAdoptedCommentListBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.XiuBean;

import java.util.HashMap;

public interface FindDangContract {
    interface Iview extends IBaseView {
        void finddang(FindUserArchivesBean findUserArchivesBean);
        void deledang(DeleDangBean deleDangBean);
        void xiudang(XiuBean xiuBean);
    }
    interface  Imodel{
        void  FindDang(String userId, String sessionId, IModelCallBack iModelCallBack);
        void  DeleDang(String userId, String sessionId, String archivesId, IModelCallBack iModelCallBack);
        void  XiuDang(String userId, String sessionId, HashMap<String,String> map, IModelCallBack iModelCallBack);
           interface IModelCallBack {
               void finddang(FindUserArchivesBean findUserArchivesBean);
               void deledang(DeleDangBean deleDangBean);
               void xiudang(XiuBean xiuBean);
               void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  DeleDang( String archivesId );
        void  FindDang( );
        void  XiuDang(HashMap<String,String> map);
       }
}
