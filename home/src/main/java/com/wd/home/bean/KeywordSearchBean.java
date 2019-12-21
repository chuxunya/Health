package com.wd.home.bean;

import java.util.List;

/**
 * @name Health
 * @class name：com.wd.home.bean
 * @anthor hp
 * @time 2019/12/21 8:52
 */
public class KeywordSearchBean {


    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":2,"detail":"难受死了真不舒服要加油哦","releaseTime":1569168000000,"sickCircleId":1307,"title":"头晕"},{"amount":0,"collectionNum":2,"commentNum":366,"detail":"可怜人真可怜","releaseTime":1569168000000,"sickCircleId":1306,"title":"张梦龙头疼"},{"amount":0,"collectionNum":2,"commentNum":6,"detail":"想不到就到家","releaseTime":1568908800000,"sickCircleId":1304,"title":"头疼"},{"amount":0,"collectionNum":1,"commentNum":11,"detail":"哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈","releaseTime":1568908800000,"sickCircleId":1303,"title":"李根头疼"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"脖子粗  脑袋大    不听话\n吃什么没够  干什么不行\n小女子，你看，哪凉快试客联盟，接口没空看那你们， 接口吗你没空看看了看门不喝酒粉笔灰赫卡里姆， 谁看见山东省考卷从中年世界里拉开了你身边 冰红茶","releaseTime":1566921600000,"sickCircleId":1184,"title":"腮腺炎怎么治   脸肿的跟个猪头似的"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"非凡哥回家看看吧不好看好尬复习","releaseTime":1564675200000,"sickCircleId":924,"title":"头疼头晕"},{"amount":0,"collectionNum":0,"commentNum":1,"detail":"根据呢谢谢咯哦哦哦哦哦哦","releaseTime":1564588800000,"sickCircleId":885,"title":"头痛不愧是"},{"amount":30,"collectionNum":0,"commentNum":3,"detail":"无忧咯","releaseTime":1564416000000,"sickCircleId":835,"title":"弯头"},{"amount":20,"collectionNum":0,"commentNum":0,"detail":"完了","releaseTime":1564416000000,"sickCircleId":832,"title":"掉头"},{"amount":10,"collectionNum":0,"commentNum":3,"detail":"头有些难受","releaseTime":1564416000000,"sickCircleId":803,"title":"头难受"},{"amount":0,"collectionNum":0,"commentNum":0,"detail":"咯夸咯哦毒素哦哦哦咯喉咙去哪君麻吕么啦去努力(＊ﾟ◇ﾟ)聚聚哦哦苦丁肯于天龙","releaseTime":1564416000000,"sickCircleId":794,"title":"骷髅头流量"},{"amount":10,"collectionNum":0,"commentNum":553,"detail":"疼起来像针扎一样","releaseTime":1564070400000,"sickCircleId":594,"title":"头疼的厉害"},{"amount":0,"collectionNum":1,"commentNum":1,"detail":"敲代码","releaseTime":1564070400000,"sickCircleId":583,"title":"头疼"},{"amount":0,"collectionNum":1,"commentNum":0,"detail":"充电电池","releaseTime":1563897600000,"sickCircleId":551,"title":"回头撒狗粮"}]
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
         * amount : 0
         * collectionNum : 0
         * commentNum : 2
         * detail : 难受死了真不舒服要加油哦
         * releaseTime : 1569168000000
         * sickCircleId : 1307
         * title : 头晕
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

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

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
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
