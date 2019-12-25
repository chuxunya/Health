package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:20:47
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.AddSignBean;
import com.wd.health.contract.MyHertContract;
import com.wd.health.model.MyHertModel;

public class MyHertPresenter extends BasePresenter<MyHertContract.Iview> implements MyHertContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";
    private MyHertModel myHertModel;

    @Override
    protected void initModel() {
        myHertModel = new MyHertModel();
    }

    @Override
    public void Addsign() {
         myHertModel.Addsign(userId, sessionId, new MyHertContract.Imodel.IModelCallBack() {
             @Override
             public void addsign(AddSignBean addSignBean) {
                 getView().addsign(addSignBean);
             }

             @Override
             public void onFraily(String e) {

             }
         });
    }
}
