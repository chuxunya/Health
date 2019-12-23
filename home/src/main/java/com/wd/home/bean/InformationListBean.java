package com.wd.home.bean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @anthor 根据资讯板块查询资讯列表
 * @time 2019/12/15 18:57
 */
public class InformationListBean {


    /**
     * result : [{"id":1,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1slZcBvEg1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1YYVOBvYT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1mRDSB7xT1RCvBVdK","title":"春季预防三高，预防心脑血管疾病，不得不提到的三个\u201c笋\u201d子！"},{"id":2,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1wFLSBCLT1RCvBVdK","title":"黄芪泡水喝，能给我们的身体带来什么变化？医生用临床经验说话"},{"id":3,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1hYEOB__T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1ezYSBCDT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1JzASBXdT1RCvBVdK","title":"这4个错误的姿势，最容易引起脊柱侧弯！多数人都中枪了"},{"id":4,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1MRESBK_T1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1WFVSByKT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1KWLOB4xT1RCvBVdK","title":"不是妈妈也有妈妈手，改善对策有这些！"},{"id":5,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1NdxOByJ_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1stESBmVT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1DRZSB5ZT1RCvBVdK","title":"让宝宝跟着月龄吃，宝宝辅食喂养及辅食制作"}]
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
         * id : 1
         * plateId : 1
         * releaseTime : 1569464574000
         * source : @weidu
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1slZcBvEg1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1YYVOBvYT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1mRDSB7xT1RCvBVdK
         * title : 春季预防三高，预防心脑血管疾病，不得不提到的三个“笋”子！
         */

        private String id;
        private String plateId;
        private long releaseTime;
        private String source;
        private String thumbnail;
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlateId() {
            return plateId;
        }

        public void setPlateId(String plateId) {
            this.plateId = plateId;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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
