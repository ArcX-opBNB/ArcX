package com.daylong.userlibrary.cache;

import com.daylong.basecache.MMKVManager;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.utils.JsonUtil;


public class UserCache {


    private static UserCache instance = null;
    private final String MUSIC = "music";
    private final String SOUND = "sound";
    private final String WALLET_PATH = "WAP";

    private UserInfoResponse userInfo;

    //    private
    public static synchronized UserCache getInstance() {
        if (instance == null) {
            synchronized (UserCache.class) {
                instance = new UserCache();
            }
        }
        return instance;
    }


    public void setUserInfo(UserInfoResponse userInfoResponse) {
        this.userInfo = userInfoResponse;
        MMKVManager.getInstance().setUserInfo(JsonUtil.toJson(userInfoResponse));
    }


    public UserInfoResponse getUserInfo() {

        if (this.userInfo != null) {
            return this.userInfo;
        }
        String userInfoStr = MMKVManager.getInstance().getUserInfo();
        if (userInfoStr != null) {
            this.userInfo = JsonUtil.fromJsonToObject(userInfoStr, UserInfoResponse.class);
            return this.userInfo;
        }
        return null;

    }


    /**

     *
     * @return
     */
    public long getUserId() {
        return userInfo != null ? userInfo.getUserId() : 0;

    }

    public boolean isLogin() {
        return getUserInfo() != null;
    }


    public void setAccessToken(String accessToken) {
        MMKVManager.getInstance().setAccessToken(accessToken);
    }

    public String getAccessToken() {
        return MMKVManager.getInstance().getAccessToken();
    }


    public String getRefreshToken() {
        return MMKVManager.getInstance().getRefreshToken();
    }


    public void setToken(String accessToken, String refreshToken) {
        MMKVManager.getInstance().setToken(accessToken, refreshToken);
    }

    public void exitLogin() {
        MMKVManager.getInstance().setUserInfo("");
        setToken("", "");
        userInfo = null;
    }


    /**

     *
     * @param isOpen
     */
    public void setMusic(boolean isOpen) {
        MMKVManager.getInstance().put(MUSIC, isOpen);

    }

    public boolean getMusic() {
        boolean bool = MMKVManager.getInstance().getBool(MUSIC, true);

        return bool;

    }


    /**

     *
     * @param isOpen
     */
    public void setSound(boolean isOpen) {
        MMKVManager.getInstance().put(SOUND, isOpen);

    }

    public boolean getSound() {
        return MMKVManager.getInstance().getBool(SOUND, true);
    }

    /**

     *
     * @param isOpen
     */
    public void setWalletPath(String isOpen) {
        MMKVManager.getInstance().put(WALLET_PATH, isOpen);

    }

    public String getWalletPath() {
        return MMKVManager.getInstance().getString(WALLET_PATH);
    }

}
