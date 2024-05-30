package com.daylong.arcx.uitls;

import com.daylong.basecache.MMKVManager;
import com.daylong.httplibrary.bean.response.user.UserInfoResponse;

import net.daylong.baselibrary.utils.JsonUtil;

public class UserCache {


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

}
