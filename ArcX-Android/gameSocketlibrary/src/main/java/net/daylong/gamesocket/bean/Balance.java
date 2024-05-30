package net.daylong.gamesocket.bean;

import java.io.Serializable;

public class Balance implements Serializable {

    private Long goldNum; 
    private Long integralNum; 

    public Long getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(Long goldNum) {
        this.goldNum = goldNum;
    }

    public Long getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Long integralNum) {
        this.integralNum = integralNum;
    }
}
