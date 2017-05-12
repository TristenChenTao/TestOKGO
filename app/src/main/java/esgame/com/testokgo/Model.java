package esgame.com.testokgo;

import java.util.List;

/**
 * Created by TristenChenTao on 08/05/2017.
 */

public class Model {

    /**
     * Money : 0
     * Gold : 703
     * DetailList : [{"Num":15,"Unit":0,"Dt":"2017-04-26 14:22:41","Remark":"每日签到"},{"Num":688,"Unit":0,"Dt":"2017-04-23 18:27:05","Remark":"注册"}]
     */

    private int Money;
    private int Gold;
    private List<DetailListBean> DetailList;

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int Gold) {
        this.Gold = Gold;
    }

    public List<DetailListBean> getDetailList() {
        return DetailList;
    }

    public void setDetailList(List<DetailListBean> DetailList) {
        this.DetailList = DetailList;
    }

    public static class DetailListBean {
        /**
         * Num : 15
         * Unit : 0
         * Dt : 2017-04-26 14:22:41
         * Remark : 每日签到
         */

        private int Num;
        private int Unit;
        private String Dt;
        private String Remark;

        public int getNum() {
            return Num;
        }

        public void setNum(int Num) {
            this.Num = Num;
        }

        public int getUnit() {
            return Unit;
        }

        public void setUnit(int Unit) {
            this.Unit = Unit;
        }

        public String getDt() {
            return Dt;
        }

        public void setDt(String Dt) {
            this.Dt = Dt;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }
    }
}
