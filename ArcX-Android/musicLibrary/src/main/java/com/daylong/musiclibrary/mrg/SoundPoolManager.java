package com.daylong.musiclibrary.mrg;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Map;

/**

 */
public class SoundPoolManager {
    private static SoundPoolManager soundPoolManager;
    private static SoundPool soundPool;
    private static Map<Integer, Integer> soundEffectMap; 
    private static Map<Integer, Integer> soundEffectPlayIdMap; 


    public static synchronized SoundPoolManager getInstance() {
        if (soundPoolManager == null) {
            synchronized (SoundPoolManager.class) {
                soundEffectPlayIdMap = new HashMap<>();
                soundEffectMap = new HashMap<>();
                soundPoolManager = new SoundPoolManager();
                crateSoundPool();
            }
        }
        return soundPoolManager;
    }

    
    private static void crateSoundPool() {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes.Builder attrBuilder = new AudioAttributes.Builder();
        attrBuilder.setLegacyStreamType(AudioManager.STREAM_MUSIC);
        builder.setAudioAttributes(attrBuilder.build());
        
        builder.setMaxStreams(10);
        soundPool = builder.build();
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundEffectPlayIdMap.put(sampleId, soundPool.play(sampleId, 1, 1, 1, 0, 1));

            }

        });
    }

    private static Context mContext;


    public static void init(Context context) {
        mContext = context;
    }

    /**

     *
     * @param rawId
     */
    public void play(int rawId) {
        play(rawId, false);
    }

    /**

     *
     * @param rawId
     */
    public void play(int rawId, boolean isStop) {
        if (!isOpenMusic()) {
            return;
        }
        if (soundEffectMap.containsKey(rawId)) {
            Integer musicId = soundEffectMap.get(rawId);
            if (musicId != null) {
                

                if (soundEffectPlayIdMap.containsKey(musicId)) {
                    Integer playId = soundEffectPlayIdMap.get(musicId);
                    if (playId != null && isStop) {
                        soundPool.stop(playId);
                    }
                }
                soundEffectPlayIdMap.put(musicId, soundPool.play(musicId, 1, 1, 1, 0, 1));
            }
        } else {
            int musicId = getMusicId(rawId);
            soundEffectMap.put(rawId, musicId);
        }
    }


    /**

     *
     * @param rawId
     * @return
     */
    private int getMusicId(int rawId) {
        if (soundPool == null) {
            crateSoundPool();
        }
        return soundPool.load(mContext, rawId, 1);
    }

    /**

     *
     * @param rawId
     */
    public void stop(int rawId) {
        if (soundEffectMap.containsKey(rawId)) {
            Integer musicId = soundEffectMap.get(rawId);
            if (musicId != null) {
                Integer playId = soundEffectPlayIdMap.get(musicId);
                if (playId != null) {
                    soundPool.stop(playId);

                }
            }
        }
    }


    public void closeSoundEffectPlayIdMap() {
        
        soundPool.release();
        soundEffectPlayIdMap.clear();
    }


    private boolean sound;

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean isOpenMusic() {
        return sound;
    }
}
