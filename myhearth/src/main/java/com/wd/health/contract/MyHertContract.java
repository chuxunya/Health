package com.wd.health.contract;
/*
 *@auther:张安恒   签到
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.AddSignBean;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.MyWalletBean;

public interface MyHertContract {
    interface Iview extends IBaseView {
        void addsign(AddSignBean addSignBean);
    }
    interface  Imodel{
        void  Addsign(String userId, String sessionId, IModelCallBack iModelCallBack);
           interface IModelCallBack {
              void addsign(AddSignBean addSignBean);
              void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  Addsign();
       }
}
