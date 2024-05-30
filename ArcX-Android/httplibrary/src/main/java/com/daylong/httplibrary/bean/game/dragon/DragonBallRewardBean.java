package com.daylong.httplibrary.bean.game.dragon;


import com.daylong.httplibrary.bean.AwardBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class DragonBallRewardBean implements Serializable {

    private DragonAwardMsgDTO dgAwd;
    private DragonTrainAwardMsgDTO dgTnTbln;

    public DragonAwardMsgDTO getDragonAwardMsg() {
        return dgAwd;
    }

    public void setDragonAwardMsg(DragonAwardMsgDTO dragonAwardMsg) {
        this.dgAwd = dragonAwardMsg;
    }

    public DragonTrainAwardMsgDTO getDragonTrainAwardMsg() {
        return dgTnTbln;
    }

    public void setDragonTrainAwardMsg(DragonTrainAwardMsgDTO dragonTrainAwardMsg) {
        this.dgTnTbln = dragonTrainAwardMsg;
    }

    public static class DragonAwardMsgDTO implements Serializable {

        private Integer amt;
        private Integer cnbAmt;



        public Integer getNum() {
            return amt;
        }

        public void setNum(Integer num) {
            this.amt = num;
        }

        public Integer getCurrentBallNum() {
            return cnbAmt;
        }

        public void setCurrentBallNum(Integer currentBallNum) {
            this.cnbAmt = currentBallNum;
        }
    }

    public static class DragonTrainAwardMsgDTO implements Serializable {
        private List<String> icTbln;
        private List<IconAwardListDTO> icAwdTbln;
        private ArrayList<AwardBean> awdTbln;



        public List<String> getIconList() {
            return icTbln;
        }

        public void setIconList(List<String> iconList) {
            this.icTbln = iconList;
        }

        public List<IconAwardListDTO> getIconAwardList() {
            return icAwdTbln;
        }

        public void setIconAwardList(List<IconAwardListDTO> iconAwardList) {
            this.icAwdTbln = iconAwardList;
        }

        public ArrayList<AwardBean> getEarnArr() {
            return awdTbln;
        }

        public void setEarnArr(ArrayList<AwardBean> earnArr) {
            this.awdTbln = earnArr;
        }



        public static class IconAwardListDTO implements Serializable {
            private Integer cmdTp;
            private Integer awdInx;

            public Integer getCommodityType() {
                return cmdTp;
            }

            public void setCommodityType(Integer commodityType) {
                this.cmdTp = commodityType;
            }

            public Integer getAwardIndex() {
                return awdInx;
            }

            public void setAwardIndex(Integer awardIndex) {
                this.awdInx = awardIndex;
            }
        }


    }
}
