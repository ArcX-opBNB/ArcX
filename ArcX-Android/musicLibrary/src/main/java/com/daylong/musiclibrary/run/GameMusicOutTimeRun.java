package com.daylong.musiclibrary.run;


import com.daylong.musiclibrary.GameMedia;

public class GameMusicOutTimeRun implements Runnable {

    private int id;
    private GameMedia gameMedia;

    public GameMusicOutTimeRun(int id, GameMedia gameMedia) {
        this.id = id;
        this.gameMedia = gameMedia;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        gameMedia.stop(id);
    }
}
