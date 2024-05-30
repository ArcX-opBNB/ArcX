package com.daylong.musiclibrary;

public class GameMediaBean {


    private Integer id; 
    private Integer type; 
    private String musicName;
    private Integer rawMusic;
    private Integer outTime; 
    private String desc;

    public Integer getOutTime() {
        return outTime;
    }

    public void setOutTime(Integer outTime) {
        this.outTime = outTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRawMusic() {
        return rawMusic;
    }

    public void setRawMusic(Integer rawMusic) {
        this.rawMusic = rawMusic;
    }

    public boolean isSoundPool() {
        return type != 1;
    }

}
