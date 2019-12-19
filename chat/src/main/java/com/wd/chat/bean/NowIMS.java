package com.wd.chat.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/19
 *@Time:14:04
 *@Description:当前咨询
 **/
public class NowIMS {
    /**
     * message : 当前无问诊
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "NowIMS{" +
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
