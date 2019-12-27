package com.wd.health.bean;

/*
 *@auther:王可欣
 *@Date: 2019/12/27
 *@Time:9:49
 *@Description:结束问诊
 **/
public class EndBean {
    /**
     * message : 结束问诊成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "EndBean{" +
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
