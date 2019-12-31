package com.wd.health.bean;
/*
 *@auther:张安恒
 *@Date: 2019/12/30
 *@Time:10:10
 *@Description:
 **/

public class FindUserArchivesBean {

    /**
     * result : {"diseaseBefore":"无","diseaseMain":"骨科","diseaseNow":"有","id":2611,"treatmentEndTime":1529942400000,"treatmentHospitalRecent":"北京市人民医院","treatmentProcess":"痊愈","treatmentStartTime":1521993600000,"userId":435}
     * message : 用户档案查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        /**
         * diseaseBefore : 无
         * diseaseMain : 骨科
         * diseaseNow : 有
         * id : 2611
         * treatmentEndTime : 1529942400000
         * treatmentHospitalRecent : 北京市人民医院
         * treatmentProcess : 痊愈
         * treatmentStartTime : 1521993600000
         * userId : 435
         */

        private String diseaseBefore;
        private String diseaseMain;
        private String diseaseNow;
        private int id;
        private long treatmentEndTime;
        private String treatmentHospitalRecent;
        private String treatmentProcess;
        private long treatmentStartTime;
        private int userId;

        public String getDiseaseBefore() {
            return diseaseBefore;
        }

        public void setDiseaseBefore(String diseaseBefore) {
            this.diseaseBefore = diseaseBefore;
        }

        public String getDiseaseMain() {
            return diseaseMain;
        }

        public void setDiseaseMain(String diseaseMain) {
            this.diseaseMain = diseaseMain;
        }

        public String getDiseaseNow() {
            return diseaseNow;
        }

        public void setDiseaseNow(String diseaseNow) {
            this.diseaseNow = diseaseNow;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospitalRecent() {
            return treatmentHospitalRecent;
        }

        public void setTreatmentHospitalRecent(String treatmentHospitalRecent) {
            this.treatmentHospitalRecent = treatmentHospitalRecent;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
