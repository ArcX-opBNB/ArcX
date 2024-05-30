package com.daylong.basecache;

public class AppCache {

    public static void setBaseUrl(String baseUrl) {
        MMKVManager.getInstance().put(CacheConstants.BASE_URL, baseUrl);
    }

    public static String getBaseUrl() {
        return MMKVManager.getInstance().getString(CacheConstants.BASE_URL);
    }
}
