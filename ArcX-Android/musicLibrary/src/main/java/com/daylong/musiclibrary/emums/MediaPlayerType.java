package com.daylong.musiclibrary.emums;

import android.text.TextUtils;

import com.daylong.musiclibrary.R;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;
import com.daylong.musiclibrary.mrg.SoundPoolManager;


public enum MediaPlayerType {
















    //Skill


    //---------------------




    
    , RANKING_MVP(6002, "sound_game_ranking_end_mvp", "mvp")//

    






    //
    ;

    private int id;
    private String musicName;
    private int rawId;
    private String desc;


    public static void playMusic(int id) {
        MediaPlayerType productAwardType = null;
        for (MediaPlayerType value : MediaPlayerType.values()) {
            if (value.getId() == id) {
                productAwardType = value;
                break;
            }
        }
        if (productAwardType != null) {
            productAwardType.play();
        }

    }

    MediaPlayerType(int id, String musicName, String desc) {
        this.id = id;
        this.musicName = musicName;
        this.desc = desc;
    }

    MediaPlayerType(int id, int rawId, String desc) {
        this.id = id;
        this.rawId = rawId;
        this.desc = desc;
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

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getRawId() {
        return rawId;
    }

    public void setRawId(int rawId) {
        this.rawId = rawId;
    }

    public void play() {

        

        if (!TextUtils.isEmpty(musicName)) {
            MediaPlayerMrg.getInstance().play(musicName);
        } else {
            SoundPoolManager.getInstance().play(getRawId());
        }
    }

    public void stop() {
        
        if (!TextUtils.isEmpty(musicName)) {
            MediaPlayerMrg.getInstance().play(musicName);
        } else {
            SoundPoolManager.getInstance().stop(getRawId());
        }
    }
}
