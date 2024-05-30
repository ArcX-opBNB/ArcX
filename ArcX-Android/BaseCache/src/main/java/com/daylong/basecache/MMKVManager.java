package com.daylong.basecache;

import android.content.Context;
import android.text.TextUtils;

import com.tencent.mmkv.MMKV;

public class MMKVManager {
    private static final String MMKV_NAME = "cache"; 
    private static MMKV kv;

    private static MMKVManager instance = null;

    public static MMKVManager getInstance() {
        if (instance == null) {

            instance = new MMKVManager();
        }
        return instance;
    }

    public void init(Context context, String versionCode) {
        MMKV.initialize(context);
        kv = MMKV.defaultMMKV(MMKV.SINGLE_PROCESS_MODE, MMKV_NAME);
        MMKVManager.getInstance().put(CacheConstants.SYS_VERSION_CODE, versionCode);


    }

    public void put(String key, Integer num) {
        kv.encode(key, num);
    }

    public void put(String key, boolean val) {
        kv.encode(key, val);
    }

    public boolean getBool(String key, boolean def) {
        return kv.decodeBool(key, def);
    }

    public Integer getInt(String key) {
        return kv.decodeInt(key, 0);
    }

    public void put(String key, String val) {
        kv.encode(key, val);
    }

    public void remover(String key) {
        kv.remove(key);
    }


    public String getString(String key) {
        return kv.decodeString(key, "");
    }


    public void setDeviceId(String deviceId) {
        kv.encode(CacheConstants.DEVICE_ID, deviceId);
    }

    public String getDeviceId() {
        return kv.decodeString(CacheConstants.DEVICE_ID, "");
    }


    public void setUserInfo(String userInfoResponse) {
        kv.encode(CacheConstants.USER_INFO, userInfoResponse);
    }


    public void setUserId(Long userId) {
        kv.encode(CacheConstants.USER_ID, userId);

    }

    public void setAccessToken(String accessToken) {
        kv.encode(CacheConstants.ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        String accesstoken = kv.decodeString(CacheConstants.ACCESS_TOKEN);


        return TextUtils.isEmpty(accesstoken) ? "touristAes" : accesstoken;
    }

    public String getUserInfo() {
        return kv.decodeString(CacheConstants.USER_INFO);

    }

    public void setRefreshToken(String refreshToken) {
        kv.encode(CacheConstants.REFRESH_TOKEN, refreshToken);
    }

    public String getRefreshToken() {
        return kv.decodeString(CacheConstants.ACCESS_TOKEN);
    }


    public void setToken(String accessToken, String refreshToken) {
        setAccessToken(accessToken);
        setRefreshToken(refreshToken);
    }


}
