package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:14:16
 *@Description:  删除关注视频
 **/

public class DeleVideoInfoBean {

    /**
     * message : 取消成功
     * status : 0000
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
