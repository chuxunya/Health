package com.wd.aclass.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:17:00
 *@Description:presenter
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.model.JiangtangModel;

public class JiangtangPresenter extends BasePresenter<JiangtangContract.Iview> implements JiangtangContract.IPresenter {

    private JiangtangModel jiangtangModel;

    @Override
    protected void initModel() {
        jiangtangModel = new JiangtangModel();
    }

    @Override
    public void jiangtang() {
        jiangtangModel.jiangtang(new JiangtangContract.Imodel.IModelCallBack() {
            @Override
            public void jiangtang(JiangtangBean jiangtangBean) {
                getView().jiangtang(jiangtangBean);
            }

            @Override
            public void JiangVideo(VideoBean videoBean) {

            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

    @Override
    public void JiangVideo(String userId, String sessionId, String categoryId, String page, String count) {
        jiangtangModel.JiangVideo(userId, sessionId, categoryId, page, count, new JiangtangContract.Imodel.IModelCallBack() {
            @Override
            public void jiangtang(JiangtangBean jiangtangBean) {

            }

            @Override
            public void JiangVideo(VideoBean videoBean) {
                getView().JiangVideo(videoBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
