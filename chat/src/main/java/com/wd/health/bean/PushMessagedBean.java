package com.wd.health.bean;
/*
 *@auther:李泽楷
 *@Date: 2019/12/24
 *@Time:14:53
 *@Description:${DESCRIPTION}
 **/

public class PushMessagedBean {

    /**
     * message : 推送成功
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
