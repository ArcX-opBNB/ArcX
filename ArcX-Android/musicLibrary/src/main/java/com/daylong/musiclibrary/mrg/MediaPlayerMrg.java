package com.daylong.musiclibrary.mrg;

import android.content.Context;

import com.daylong.musiclibrary.AssetMediaPlayer;
import com.daylong.musiclibrary.service.IPlay;


/**

 */
public class MediaPlayerMrg implements IPlay {

    private static MediaPlayerMrg instance;
    private AssetMediaPlayer assetMediaPlayer;

    
    private boolean isOpenMusic;

    public void setOpenMusic(boolean openMusic) {
        isOpenMusic = openMusic;
    }

    //    private
    public static synchronized MediaPlayerMrg getInstance() {
        if (instance == null) {
            synchronized (MediaPlayerMrg.class) {
                instance = new MediaPlayerMrg();
            }
        }
        return instance;
    }

    public void init(Context context, String prefix, boolean isOpenMusic) {
        if (assetMediaPlayer == null) {
            assetMediaPlayer = new AssetMediaPlayer(context);
        }
        this.isOpenMusic = isOpenMusic;
        assetMediaPlayer.setPrefix(prefix);

    }

    
    @Override
    public void initBgMusic(String[] bgMusic) {
        assetMediaPlayer.initBgMusic(bgMusic);
    }

    @Override
    public void play() {
        if (!isOpenMusic) {
            return;
        }

        if (assetMediaPlayer != null) {

            assetMediaPlayer.play();
        }
    }

    @Override
    public void play(String playPath) {
        if (!isOpenMusic) {
            stop();
            return;
        }
        if (assetMediaPlayer != null) {

            assetMediaPlayer.play(playPath);
        }
    }

    @Override
    public void stop() {
        if (assetMediaPlayer != null && assetMediaPlayer.isPlay()) {
            assetMediaPlayer.stop();
        }
    }

    @Override
    public void destroy() {
        if (assetMediaPlayer != null) {
            assetMediaPlayer.destroy();
        }

    }

    public void exit() {
        if (assetMediaPlayer != null) {
            assetMediaPlayer.exit();

        }
    }


}
