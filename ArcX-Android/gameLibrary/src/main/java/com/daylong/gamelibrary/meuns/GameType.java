package com.daylong.gamelibrary.meuns;

import java.io.Serializable;

public enum GameType implements Serializable {



    ;

    private int id;
    private String desc;
    private int cmd; 
    private int gameTime; 
    private int toastTime; 

    GameType(int id, String desc, int cmd, int gameTime, int toastTime) {
        this.id = id;
        this.desc = desc;
        this.cmd = cmd;
        this.gameTime = gameTime;
        this.toastTime = toastTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public int getToastTime() {
        return toastTime;
    }

    public void setToastTime(int toastTime) {
        this.toastTime = toastTime;
    }

    public static GameType getGameTypeById(int id) {


        for (GameType gameType : values()) {
            if (gameType.getId() == id) {
                return gameType;
            }

        }

        return null;

    }
}
