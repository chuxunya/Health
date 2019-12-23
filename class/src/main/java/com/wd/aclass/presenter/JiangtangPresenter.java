package com.wd.aclass.presenter;
/*
 *@auther:张安恒
 *@Date: 2019/12/13
 *@Time:17:00
 *@Description:presenter
 **/

import com.bawei.lizekai.mylibrary.base.BasePresenter;
import com.wd.aclass.bean.AddVideoBean;
import com.wd.aclass.bean.BuyVideoBean;
import com.wd.aclass.bean.DanmuBean;
import com.wd.aclass.bean.JiangtangBean;
import com.wd.aclass.bean.VideoBean;
import com.wd.aclass.contract.JiangtangContract;
import com.wd.aclass.model.JiangtangModel;

public class JiangtangPresenter extends BasePresenter<JiangtangContract.Iview> implements JiangtangContract.IPresenter {

    private JiangtangModel jiangtangModel;
    private String userId="435";
    private String sessionId="1576814271003435";
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
            public void AddVideo(AddVideoBean addVideoBean) {

            }

            @Override
            public void BuyVideo(BuyVideoBean buyVideoBean) {

            }

            @Override
            public void Danmu(DanmuBean danmuBean) {

            }

            @Override
            public void onFraily(String e) {
                getView().onFraily(e);
            }
        });
    }

    @Override
    public void JiangVideo(  String categoryId, String page, String count) {
        jiangtangModel.JiangVideo(userId, sessionId, categoryId, page, count, new JiangtangContract.Imodel.IModelCallBack() {
            @Override
            public void jiangtang(JiangtangBean jiangtangBean) {

            }

            @Override
            public void JiangVideo(VideoBean videoBean) {
                getView().JiangVideo(videoBean);
            }

            @Override
            public void AddVideo(AddVideoBean addVideoBean) {

            }

            @Override
            public void BuyVideo(BuyVideoBean buyVideoBean) {

            }

            @Override
            public void Danmu(DanmuBean danmuBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void AddVideo(  String videoId) {
        jiangtangModel.AddVideo(userId, sessionId, videoId, new JiangtangContract.Imodel.IModelCallBack() {
            @Override
            public void jiangtang(JiangtangBean jiangtangBean) {

            }

            @Override
            public void JiangVideo(VideoBean videoBean) {

            }

            @Override
            public void AddVideo(AddVideoBean addVideoBean) {
                getView().AddVideo(addVideoBean);
            }

            @Override
            public void BuyVideo(BuyVideoBean buyVideoBean) {

            }

            @Override
            public void Danmu(DanmuBean danmuBean) {

            }

            @Override
            public void onFraily(String e) {

            }
        });
    }

    @Override
    public void BuyVideo(  String videoId, String price) {
            jiangtangModel.BuyVideo(userId, sessionId, videoId, price, new JiangtangContract.Imodel.IModelCallBack() {
                @Override
                public void jiangtang(JiangtangBean jiangtangBean) {

                }

                @Override
                public void JiangVideo(VideoBean videoBean) {

                }

                @Override
                public void AddVideo(AddVideoBean addVideoBean) {

                }

                @Override
                public void BuyVideo(BuyVideoBean buyVideoBean) {
                    getView().BuyVideo(buyVideoBean);
                }

                @Override
                public void Danmu(DanmuBean danmuBean) {

                }

                @Override
                public void onFraily(String e) {

                }
            });
    }

    @Override
    public void Danmu(String videoId, String content) {
        jiangtangModel.Danmu(userId, sessionId, videoId, content, new JiangtangContract.Imodel.IModelCallBack() {
            @Override
            public void jiangtang(JiangtangBean jiangtangBean) {

            }

            @Override
            public void JiangVideo(VideoBean videoBean) {

            }

            @Override
            public void AddVideo(AddVideoBean addVideoBean) {

            }

            @Override
            public void BuyVideo(BuyVideoBean buyVideoBean) {

            }

            @Override
            public void Danmu(DanmuBean danmuBean) {
                getView().Danmu(danmuBean);
            }

            @Override
            public void onFraily(String e) {

            }
        });
    }
}
