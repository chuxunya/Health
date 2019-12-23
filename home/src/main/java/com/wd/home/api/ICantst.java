package com.wd.home.api;

/**
 * @name Health
 * @class name：com.wd.home.api
 * @anthor hp
 * @time 2019/12/13 18:59
 */
public class ICantst {

    //轮播图
    public static final String BANNER="health/share/v1/bannersShow";
    //查询科室列表
    public static final String DEPARTMENT="health/share/knowledgeBase/v1/findDepartment";
    //查询健康资讯板块
    public static final String INFORMATION="health/share/information/v1/findInformationPlateList";
    //根据资讯板块查询资讯列表
    public static final String INFORMATIONLIST="health/share/information/v1/findInformationList";
    //首页搜索
    public static final String HOMEPAGESEARCH="health/share/v1/homePageSearch";
    //热门搜索
    public static final String POPULARSEARCH="health/share/v1/popularSearch";
    //根据科室查询对应病症
    public static final String DISEASE="health/share/knowledgeBase/v1/findDiseaseCategory";
    //药品科目分类列表查询
    public static final String DRUGS="health/share/knowledgeBase/v1/findDrugsCategoryList";
    //根据药品类目查询常见药品
    public static final String DRUGSKNOW="health/share/knowledgeBase/v1/findDrugsKnowledgeList";
    //查询常见病症详情
    public static final String DISEASEKNOW="health/share/knowledgeBase/v1/findDiseaseKnowledge";
    //查询常见药品详情
    public static final String DRUGSKNOWLEDGE="health/share/knowledgeBase/v1/findDrugsKnowledge";
    //资讯详情
    public static final String INFOR="health/share/information/v1/findInformation";
    //病友圈列表展示
    public static final String SICKCIRCLE ="health/user/sickCircle/v1/findSickCircleList";
    //根据根据关键词查询病友圈
    public static final String SEARCHSICK= "health/user/sickCircle/v1/searchSickCircle";
    //查询病友圈详情
    public static final String SICKCIRCLEINFO= "health/user/sickCircle/v1/findSickCircleInfo";
    //病友圈发表评论
    public static final String PUBLISH= "health/user/sickCircle/verify/v1/publishComment";
    //查询病友圈评论列表
    public static final String FINDSICK= "health/user/sickCircle/v1/findSickCircleCommentList";
}
