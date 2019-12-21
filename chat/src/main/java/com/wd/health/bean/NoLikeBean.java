package com.wd.health.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/19
 *@Time:10:07
 *@Description:取消关注医生
 **/
public class NoLikeBean {
    /**
     * message : 取消关注成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "NoLikeBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

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
