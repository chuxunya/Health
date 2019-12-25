package com.wd.health.contract;
/*
 *@auther:张安恒  我的钱包
 *@Date: 2019/12/13
 *@Time:15:38
 *@Description:contract
 **/

import com.bawei.lizekai.mylibrary.base.IBaseView;
import com.wd.health.bean.FindUserCRBean;
import com.wd.health.bean.MyWalletBean;

public interface MyWalletContract {
    interface Iview extends IBaseView {
        void mywallet(MyWalletBean myWalletBean);
        void findusercr(FindUserCRBean findUserCRBean);
    }
    interface  Imodel{
        void  MyWallet(String userId, String sessionId, IModelCallBack iModelCallBack);
        void  FindUserRC(String userId, String sessionId,String page,String count, IModelCallBack iModelCallBack);
          interface IModelCallBack {
              void mywallet(MyWalletBean myWalletBean);
              void findusercr(FindUserCRBean findUserCRBean);
            void onFraily(String e);
        }
    }
    interface  IPresenter{
        void  MyWallet();
        void  FindUserRC(String page,String count);
    }
}
