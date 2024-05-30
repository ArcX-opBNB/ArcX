package com.daylong.gamelibrary.cache;

import com.daylong.basecache.MMKVManager;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.utils.JsonUtil;

public class UserCache {

    private static final String MUSIC = "music";
    private static UserInfoResponse userInfoResponse;

    public static UserInfoResponse getUserInfo() {
        if (userInfoResponse == null) {
            String userInfo = MMKVManager.getInstance().getUserInfo();
            userInfoResponse = JsonUtil.fromJsonToObject(userInfo, UserInfoResponse.class);
        }
        return userInfoResponse;
    }


    public static long getUserId() {

        return getUserInfo().getUserId();
    }

    public static boolean getMusic() {
        boolean bool = MMKVManager.getInstance().getBool(MUSIC, true);

        return bool;

    }



}
