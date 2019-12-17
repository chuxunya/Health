package com.wd.home.api;

import com.bawei.lizekai.mylibrary.app.BaseApp;
import com.wd.home.bean.BannerBean;
import com.wd.home.bean.DepartmentBean;
import com.wd.home.bean.DiseaseBean;
import com.wd.home.bean.HomePageSearchBean;
import com.wd.home.bean.InformationBean;
import com.wd.home.bean.InformationListBean;
import com.wd.home.bean.PopularSearchBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @name Health
 * @class name：com.wd.home.api
 * @anthor hp
 * @time 2019/12/13 18:58
 */
public interface MyApp  {

    //轮播图
    @GET("health/share/v1/bannersShow")
    Observable<BannerBean> banner();

    //查询科室列表
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<DepartmentBean> department();

    //查询健康资讯板块
    @GET("health/share/information/v1/findInformationPlateList")
    Observable<InformationBean> information();

    //根据资讯板块查询资讯列表
    @GET("health/share/information/v1/findInformationList")
    Observable<InformationListBean> informationlist(@Query("plateId") int plateId, @Query("page") int page, @Query("count") int count);

    //首页搜索
    @GET("health/share/v1/homePageSearch")
    Observable<HomePageSearchBean> homepagesearch(@Query("keyWord") String keyWord);

    //热门搜索
    @GET("health/share/v1/popularSearch")
    Observable<PopularSearchBean> popularSearch();

    //根据科室查询对应病症
    @GET("health/share/knowledgeBase/v1/findDiseaseCategory")
    Observable<DiseaseBean> disease(@Query("departmentId") int departmentId);

}
