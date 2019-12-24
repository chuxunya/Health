package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:14:50
 *@Description:
 **/

import java.util.List;

public class FindquanBean {

    /**
     * result : [{"collectionNum":2,"commentNum":7,"createTime":1577170099000,"disease":"神经病吧啦啦啦","id":1151,"sickCircleId":20,"title":"精神科"},{"collectionNum":8,"commentNum":346,"createTime":1577170096000,"disease":"病症描述","id":1150,"sickCircleId":5,"title":"急寻：面神经炎的治疗方法"},{"collectionNum":0,"commentNum":0,"createTime":1577169714000,"id":1149,"sickCircleId":3},{"collectionNum":0,"commentNum":0,"createTime":1577169712000,"id":1148,"sickCircleId":2},{"collectionNum":0,"commentNum":0,"createTime":1577169708000,"id":1147,"sickCircleId":1}]
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
         * collectionNum : 2
         * commentNum : 7
         * createTime : 1577170099000
         * disease : 神经病吧啦啦啦
         * id : 1151
         * sickCircleId : 20
         * title : 精神科
         */

        private int collectionNum;
        private int commentNum;
        private long createTime;
        private String disease;
        private int id;
        private int sickCircleId;
        private String title;

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
