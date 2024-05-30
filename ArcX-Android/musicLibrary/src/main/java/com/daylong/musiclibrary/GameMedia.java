package com.daylong.musiclibrary;

import android.content.Context;
import android.os.Handler;

import com.daylong.musiclibrary.bean.DeviceMusicBean;
import com.daylong.musiclibrary.mrg.MediaPlayerMrg;
import com.daylong.musiclibrary.mrg.SoundPoolManager;
import com.daylong.musiclibrary.run.GameMusicOutTimeRun;
import com.daylong.musiclibrary.service.IGamePlay;
import com.daylong.musiclibrary.uitls.LoadMusicJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GameMedia implements IGamePlay {

    private Map<Integer, GameMediaBean> mediaBeanMap = null;
    private Map<Integer, GameMusicOutTimeRun> outTimeRunnable = null;

    private static Handler handler = new Handler();

    public GameMedia(Context context, String fileName) {
        
        mediaBeanMap = new HashMap<>();
        String s = LoadMusicJson.LoadingAssJson(context, fileName);

        try {
            JSONArray jsonArray = new JSONArray(s);

            for (int i = 0; i < jsonArray.length(); i++) {

                GameMediaBean gameMediaBean = new GameMediaBean();
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                int id = jsonObject.optInt("id");

                if (!mediaBeanMap.containsKey(id)) {
                    int type = jsonObject.optInt("type");
                    int outTime = jsonObject.optInt("outTime");
                    String musicName = jsonObject.optString("musicName");
                    String desc = jsonObject.optString("desc");
                    gameMediaBean.setId(id);
                    gameMediaBean.setType(type);
                    if (type != 1) {
                        int raw = context.getResources().getIdentifier(musicName, "raw", "com.tide.play");

                        gameMediaBean.setRawMusic(raw);
                    }
                    gameMediaBean.setMusicName(musicName);
                    gameMediaBean.setDesc(desc);
                    gameMediaBean.setOutTime(outTime);
                    mediaBeanMap.put(id, gameMediaBean);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void play(int musicCode) {

        GameMediaBean gameMediaBean = mediaBeanMap.get(musicCode);


        if (gameMediaBean != null) {
            setOutTime(gameMediaBean);
            if (gameMediaBean.isSoundPool()) {
                SoundPoolManager.getInstance().play(gameMediaBean.getRawMusic());
            } else {
                MediaPlayerMrg.getInstance().play(gameMediaBean.getMusicName());
            }
        }

    }


    public void setOutTime(GameMediaBean gameMediaBean) {

        
        if (gameMediaBean != null && gameMediaBean.getOutTime() != null) {
            if (outTimeRunnable == null) {
                outTimeRunnable = new HashMap<>();
            }

            GameMusicOutTimeRun gameMusicOutTimeRun;

            Integer id = gameMediaBean.getId();
            if (outTimeRunnable.containsKey(id)) {
                gameMusicOutTimeRun = outTimeRunnable.get(gameMediaBean.getId());
                handler.removeCallbacks(gameMusicOutTimeRun, null);
            } else {
                gameMusicOutTimeRun = new GameMusicOutTimeRun(id, this);

            }
            handler.postDelayed(gameMusicOutTimeRun, 2000);
        }

    }


    @Override
    public void stop(int musicCode) {
        GameMediaBean gameMediaBean = mediaBeanMap.get(musicCode);
        if (gameMediaBean != null) {
            if (gameMediaBean.isSoundPool()) {
                SoundPoolManager.getInstance().stop(gameMediaBean.getRawMusic());
            } else {
                MediaPlayerMrg.getInstance().stop();

            }
        }
    }

    public void setData(DeviceMusicBean deviceMusicBean) {


        if (deviceMusicBean.isPlay()) {

            play(deviceMusicBean.getVoiceType());
        } else {
            stop(deviceMusicBean.getVoiceType());

        }

    }
}
