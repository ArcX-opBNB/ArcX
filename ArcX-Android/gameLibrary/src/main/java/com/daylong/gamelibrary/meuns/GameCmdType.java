package com.daylong.gamelibrary.meuns;

public enum GameCmdType {







    


    



    

    




    ;

    private Integer cdm;
    private Integer returnCdm;
    private String desc;


    public static GameCmdType getGameCmdType(int cmd) {
        for (GameCmdType value : GameCmdType.values()) {
            if (value.getCdm() == cmd) {
                return value;
            }


        }
        return null;

    }

    public static GameCmdType getGameReturnCmdType(int cmd) {
        for (GameCmdType value : GameCmdType.values()) {
            if (value.getReturnCdm() == cmd) {
                return value;
            }


        }
        return null;

    }

    GameCmdType(Integer cdm, Integer returnCdm, String desc) {
        this.cdm = cdm;
        this.returnCdm = returnCdm;
        this.desc = desc;
    }

    public Integer getCdm() {
        return cdm;
    }

    public void setCdm(Integer cdm) {
        this.cdm = cdm;
    }

    public Integer getReturnCdm() {
        return returnCdm;
    }

    public void setReturnCdm(Integer returnCdm) {
        this.returnCdm = returnCdm;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
