package com.wd.home.bean;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @anthor hp
 * @time 2019/12/24 14:41
 */
public class UploadPatientBean {

    /**
     * message : 上传成功
     * status : 0000
     */

    private String message;
    private String status;
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
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
