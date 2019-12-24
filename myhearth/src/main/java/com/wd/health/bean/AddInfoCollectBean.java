package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:10:05
 *@Description:
 **/

import java.util.List;

public class AddInfoCollectBean {

    /**
     * result : [{"createTime":1577153032000,"id":1054,"infoId":2,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1wFLSBCLT1RCvBVdK","title":"黄芪泡水喝，能给我们的身体带来什么变化？医生用临床经验说话"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * createTime : 1577153032000
         * id : 1054
         * infoId : 2
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1wFLSBCLT1RCvBVdK
         * title : 黄芪泡水喝，能给我们的身体带来什么变化？医生用临床经验说话
         */

        private long createTime;
        private int id;
        private int infoId;
        private String thumbnail;
        private String title;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getInfoId() {
            return infoId;
        }

        public void setInfoId(int infoId) {
            this.infoId = infoId;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
