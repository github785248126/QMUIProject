package com.qmui.project.bean;

import com.google.gson.annotations.SerializedName;
/**
 * 创建日期：2019/10/8
 * 创建人：崔斌浩
 * QQ:785248126
 * 说明：
 */
public class DayBean {
    /**
     * reason : Success
     * result : {"data":{"avoid":"入殓.安葬.开市.交易.","animalsYear":"猪","weekday":"星期二","suit":"祭祀.诸事不宜.","lunarYear":"己亥年","lunar":"九月初三","year-month":"2019-10","date":"2019-10-1","desc":"10月1日至10月7日放假，9月29日（星期日）、10月12日（星期六）上班。","holiday":"国庆节"}}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * data : {"avoid":"入殓.安葬.开市.交易.","animalsYear":"猪","weekday":"星期二","suit":"祭祀.诸事不宜.","lunarYear":"己亥年","lunar":"九月初三","year-month":"2019-10","date":"2019-10-1","desc":"10月1日至10月7日放假，9月29日（星期日）、10月12日（星期六）上班。","holiday":"国庆节"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * avoid : 入殓.安葬.开市.交易.
             * animalsYear : 猪
             * weekday : 星期二
             * suit : 祭祀.诸事不宜.
             * lunarYear : 己亥年
             * lunar : 九月初三
             * year-month : 2019-10
             * date : 2019-10-1
             * desc : 10月1日至10月7日放假，9月29日（星期日）、10月12日（星期六）上班。
             * holiday : 国庆节
             */
            private String avoid;
            private String animalsYear;
            private String weekday;
            private String suit;
            private String lunarYear;
            private String lunar;
            @SerializedName("year-month")
            private String yearmonth;
            private String date;
            private String desc;
            private String holiday;

            public String getAvoid() {
                return avoid;
            }

            public void setAvoid(String avoid) {
                this.avoid = avoid;
            }

            public String getAnimalsYear() {
                return animalsYear;
            }

            public void setAnimalsYear(String animalsYear) {
                this.animalsYear = animalsYear;
            }

            public String getWeekday() {
                return weekday;
            }

            public void setWeekday(String weekday) {
                this.weekday = weekday;
            }

            public String getSuit() {
                return suit;
            }

            public void setSuit(String suit) {
                this.suit = suit;
            }

            public String getLunarYear() {
                return lunarYear;
            }

            public void setLunarYear(String lunarYear) {
                this.lunarYear = lunarYear;
            }

            public String getLunar() {
                return lunar;
            }

            public void setLunar(String lunar) {
                this.lunar = lunar;
            }

            public String getYearmonth() {
                return yearmonth;
            }

            public void setYearmonth(String yearmonth) {
                this.yearmonth = yearmonth;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getHoliday() {
                return holiday;
            }

            public void setHoliday(String holiday) {
                this.holiday = holiday;
            }
        }
    }
}
