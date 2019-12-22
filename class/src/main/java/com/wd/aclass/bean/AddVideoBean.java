package com.wd.aclass.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/19
 *@Time:9:11
 *@Description:addvideo
 **/

public class AddVideoBean {

    /**
     * message : 已收藏，不可重复收藏
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
