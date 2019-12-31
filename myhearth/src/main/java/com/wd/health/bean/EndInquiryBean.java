package com.wd.health.bean;

/**
 *@describe(描述)：EndInquiryBean
 *@data（日期）: 2019/12/30
 *@time（时间）: 15:31
 *@author（作者）: 张安恒
 **/
public class EndInquiryBean {

    /**
     * message : 该问诊已结束,不能重复操作
     * status : 8001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
