package com.daylong.basecache;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class GameCache {

    public static void setGameRoomId(int gameRoomId) {
        MMKVManager.getInstance().put(CacheConstants.GAME_ROOM_ID, gameRoomId);
    }

    public static int getGameRoomId() {
        return MMKVManager.getInstance().getInt(CacheConstants.GAME_ROOM_ID);
    }

    public static void setGameCmd(int cmdId) {
        MMKVManager.getInstance().put(CacheConstants.GAME_ROOM_CMD, cmdId);
    }

    public static int getGameCmd() {
        return MMKVManager.getInstance().getInt(CacheConstants.GAME_ROOM_CMD);
    }

    public static String getCharterDesc() {
        return MMKVManager.getInstance().getString(CacheConstants.GAME_CHARTER_DESC);
    }

    public static void setCharterDesc(String desc) {
        MMKVManager.getInstance().put(CacheConstants.GAME_CHARTER_DESC, desc);
    }


    public static Integer getGameMultiplier() {
        return MMKVManager.getInstance().getInt(CacheConstants.GAME_MULTIPLIER);
    }

    public static void setGameMultiplier(int GameMultiplier) {
        MMKVManager.getInstance().put(CacheConstants.GAME_MULTIPLIER, GameMultiplier);
    }


    public static Integer getGameLastTime() {
        String string = MMKVManager.getInstance().getString(CacheConstants.GAME_LAST_TIME);
        if (TextUtils.isEmpty(string)) {
            return -1;
        }
        try {
            JSONObject jsonObject = new JSONObject(string);
            long curTime = jsonObject.optLong("curTime");
            int gameLastTime = jsonObject.optInt("gameLastTime");

            int time = (int) ((System.currentTimeMillis() - curTime) / 1000);
            return gameLastTime - time;
        } catch (JSONException e) {
            return 0;
        }

    }

    public static void setGameLastTime(int lastTime) {
        if (lastTime == 0) {
            MMKVManager.getInstance().remover(CacheConstants.GAME_LAST_TIME);
            return;
        }

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("curTime", System.currentTimeMillis());
            jsonObject.put("gameLastTime", lastTime);
            MMKVManager.getInstance().put(CacheConstants.GAME_LAST_TIME, jsonObject.toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }


    private static final String MUSIC = "music";

    /**

     *
     * @param isOpen
     */
    public static void setMusic(boolean isOpen) {
        MMKVManager.getInstance().put(MUSIC, isOpen);

    }

    public static boolean getMusic() {
        boolean bool = MMKVManager.getInstance().getBool(MUSIC, true);

        return bool;

    }
}
