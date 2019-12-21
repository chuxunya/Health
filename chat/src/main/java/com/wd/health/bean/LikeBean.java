package com.wd.health.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/19
 *@Time:10:06
 *@Description:关注医生
 **/
public class LikeBean {
    /**
     * message : 关注成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "LikeBean{" +
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
