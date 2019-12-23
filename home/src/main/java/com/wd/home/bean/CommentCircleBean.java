package com.wd.home.bean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @anthor 病友圈发表评论
 * @time 2019/12/21 10:01
 */
public class CommentCircleBean {

    /**
     * message : 评论成功
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
