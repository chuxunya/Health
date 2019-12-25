package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/24
 *@Time:19:53
 *@Description:  消费记录
 **/

import java.util.List;

public class FindUserCRBean {

    /**
     * result : [{"changeNum":-100,"createTime":1577172658000,"direction":2,"remark":"购买健康课堂视频","type":17},{"changeNum":-100,"createTime":1577172649000,"direction":2,"remark":"购买健康课堂视频","type":17},{"changeNum":-100,"createTime":1577172647000,"direction":2,"remark":"购买健康课堂视频","type":17},{"changeNum":-100,"createTime":1577172500000,"direction":2,"remark":"购买健康课堂视频","type":17},{"changeNum":-100,"createTime":1577172489000,"direction":2,"remark":"购买健康课堂视频","type":17}]
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
         * changeNum : -100
         * createTime : 1577172658000
         * direction : 2
         * remark : 购买健康课堂视频
         * type : 17
         */

        private int changeNum;
        private long createTime;
        private int direction;
        private String remark;
        private int type;

        public int getChangeNum() {
            return changeNum;
        }

        public void setChangeNum(int changeNum) {
            this.changeNum = changeNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
