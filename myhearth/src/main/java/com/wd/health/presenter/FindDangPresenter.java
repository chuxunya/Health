package com.wd.health.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/30
 *@Time:10:26
 *@Description:
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.health.bean.DeleDangBean;
import com.wd.health.bean.FindUserArchivesBean;
import com.wd.health.bean.XiuBean;
import com.wd.health.contract.FindDangContract;
import com.wd.health.model.FindDangModel;

import java.util.HashMap;

public class FindDangPresenter extends BasePresenter<FindDangContract.Iview> implements FindDangContract.IPresenter {
    private String userId="435";
    private String sessionId="1577693387272435";
    private FindDangModel findDangModel;

    @Override
    protected void initModel() {
        findDangModel = new FindDangModel();
    }


    public void FindDang() {
        findDangModel.FindDang(userId, sessionId, new FindDangContract.Imodel.IModelCallBack() {
            @Override
            public void finddang(FindUserArchivesBean findUserArchivesBean) {
                getView().finddang(findUserArchivesBean);
            }

            @Override
            public void deledang(DeleDangBean deleDangBean) {

            }

            @Override
            public void xiudang(XiuBean xiuBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void XiuDang(HashMap<String, String> map) {
        findDangModel.XiuDang(userId, sessionId, map, new FindDangContract.Imodel.IModelCallBack() {
            @Override
            public void finddang(FindUserArchivesBean findUserArchivesBean) {

            }

            @Override
            public void deledang(DeleDangBean deleDangBean) {

            }

            @Override
            public void xiudang(XiuBean xiuBean) {
                    getView().xiudang(xiuBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void DeleDang(String archivesId) {
        findDangModel.DeleDang(userId, sessionId, archivesId, new FindDangContract.Imodel.IModelCallBack() {
            @Override
            public void finddang(FindUserArchivesBean findUserArchivesBean) {

            }

            @Override
            public void deledang(DeleDangBean deleDangBean) {
                getView().deledang(deleDangBean);
            }

            @Override
            public void xiudang(XiuBean xiuBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
