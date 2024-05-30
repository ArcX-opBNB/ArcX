package com.daylong.httplibrary.bean.response.user;

import com.daylong.httplibrary.bean.AwardBean;

import java.io.Serializable;
import java.util.List;

public class CheckInInfoResponse implements Serializable {


    private Integer signFlag;
    private List<SignListDTO> signList;

    public boolean isCheck() {
        return signFlag == 1;
    }


    public  String getCheckBtnStr(){



    }
    public Integer getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    public List<SignListDTO> getSignList() {
        return signList;
    }

    public void setSignList(List<SignListDTO> signList) {
        this.signList = signList;
    }

    public static class SignListDTO implements Serializable{
        private List<AwardBean> awardList;
        private Integer signFlag;

        public boolean isCheck() {

            return signFlag == 1;
        }

        public List<AwardBean> getAwardList() {
            return awardList;
        }

        public void setAwardList(List<AwardBean> awardList) {
            this.awardList = awardList;
        }

        public Integer getSignFlag() {
            return signFlag;
        }

        public void setSignFlag(Integer signFlag) {
            this.signFlag = signFlag;
        }

    }
}
