package com.wd.login.bean;

/**
 *@describe(描述)：SendEmilBean
 *@data（日期）: 2019/12/18
 *@time（时间）: 14:37
 *@author（作者）:dongyanjun
 **/
public class SendEmilBean {

    /**
     * message : 发送成功
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
