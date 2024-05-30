package com.daylong.musiclibrary;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;

import com.daylong.musiclibrary.emums.MediaPlayerType;
import com.daylong.musiclibrary.service.IPlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class AssetMediaPlayer implements
        MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, IPlay {

    public MediaPlayer mediaPlayer; 
    private AssetManager assetManager;
    private List<String> defaultMusicList = new ArrayList<>();
    
    private LinkedBlockingQueue<String> blockingQueueMusic = new LinkedBlockingQueue<String>();
    private Set<String> notLoopingName = new HashSet<>();


    private String prefix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    
    public AssetMediaPlayer(Context context) {
        try {
            assetManager = context.getAssets();
            mediaPlayer = new MediaPlayer();
            
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            
            mediaPlayer.setOnPreparedListener(this);
            
            mediaPlayer.setOnCompletionListener(this);
            notLoopingName.add(MediaPlayerType.RANKING_MVP.getMusicName());
            notLoopingName.add(MediaPlayerType.PRIZE_WHEEL_GRAND.getMusicName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }


    /**

     *
     * @param defaultMusicList
     */
    public void initBgMusic(String[] defaultMusicList) {
        defaultMusicList.clone();
        this.defaultMusicList.addAll(Arrays.asList(defaultMusicList));
    }


    /**

     */
    public void play() {
        
        if (TextUtils.equals(playMusicName, "start")) {
            return;
        }
        if (defaultMusicList != null && defaultMusicList.size() > 0) {
            int num = (int) (System.currentTimeMillis() % defaultMusicList.size());
            play(defaultMusicList.get(num));
        }


    }


    
    public boolean isPlay() {
        return mediaPlayer.isPlaying();
    }


    private float volume = 1.0f;


    private String playMusicName;

    /**

     */
    public void play(String musicName, float volume) {
        try {


            if (mediaPlayer.isPlaying() && playMusicName.equals(musicName)) {
                return;
            }
            playMusicName = musicName;
            this.volume = volume;
            
            mediaPlayer.reset();
            String musicPath;

            if (musicName.startsWith("sound_")) {
                musicPath = "music/" + musicName + ".mp3";
            } else {
                musicPath = "music/" + prefix + "/sound_" + prefix + "_" + musicName + ".mp3";

            }

            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(musicPath);
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            mediaPlayer.setVolume(volume, volume);
            
            mediaPlayer.prepareAsync();
            // music/egypt/sound_egypt_start
            // music/egypt/sound_egypt_start.mp3
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**

     */

    @Override
    public void play(String playPath) {
        blockingQueueMusic.clear();
        try {
            String[] split = playPath.split(",");

            for (String s : split) {
                blockingQueueMusic.put(s);
            }
            if (blockingQueueMusic.size() > 0) {
                String take = blockingQueueMusic.take();
                play(take, 1.0f);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**

     */
    @Override
    public void stop() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }
    }

    @Override
    public void destroy() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            
            mediaPlayer.reset();
            
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    /**

     */
    private boolean isLoopPlay = true;

    /**

     *
     * @param loopPlay
     */
    public void setLoopPlay(boolean loopPlay) {
        isLoopPlay = loopPlay;
    }


    
    @Override
    public void onPrepared(MediaPlayer mp) {
        


        int duration = mp.getDuration();


        mp.setLooping(!notLoopingName.contains(playMusicName) && duration > 7000);

        mp.start();

    }

    @Override
    public void onCompletion(MediaPlayer mp) {


        if (blockingQueueMusic.size() > 0) {
            String take = null;
            try {
                take = blockingQueueMusic.take();
                if (take != null) {
                    play(take, 1.0f);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            if (isLoopPlay) {
                if (defaultMusicList != null && defaultMusicList.size() > 0) {
                    int num = (int) (System.currentTimeMillis() % defaultMusicList.size());
                    play(defaultMusicList.get(num), 1.0f);

                }
            }
        }
    }


    /**

     */
    public void playMusic() {
        mediaPlayer.start();

    }


    public void stopAndSwBg() {
        stop();
    }


    public void exit() {
        stop();
        defaultMusicList.clear();
        blockingQueueMusic.clear();
    }
}
