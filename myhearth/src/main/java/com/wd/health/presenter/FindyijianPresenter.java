package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/25
 *@Time:10:19
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.FindMyAdoptedCommentListBean;
import com.wd.health.contract.FindyijianContract;
import com.wd.health.model.FindyijianModel;

public class FindyijianPresenter extends BasePresenter<FindyijianContract.Iview> implements FindyijianContract.IPresenter {
    private String userId="435";
    private String sessionId="1577085403344435";

    private FindyijianModel findyijianModel;

    @Override
    protected void initModel() {
        findyijianModel = new FindyijianModel();
    }

    @Override
    public void Findyijian(String page, String count) {
        findyijianModel.Findyijian(userId, sessionId, page, count, new FindyijianContract.Imodel.IModelCallBack() {
            @Override
            public void findyijian(FindMyAdoptedCommentListBean findMyAdoptedCommentListBean) {
                getView().findyijian(findMyAdoptedCommentListBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
