package com.daylong.gamelibrary.meuns;

public enum GameOperateType {

























    ;//


    private int code;
    private String desc;

    GameOperateType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static GameOperateType getOperateState(int code) {

        for (GameOperateType value : GameOperateType.values()) {
            if (value.getCode() == code) {
                return value;
            }


        }

        return null;

    }
}
