package net.daylong.gamesocket.cache;


import com.daylong.basecache.CacheConstants;
import com.daylong.basecache.MMKVManager;

public class WebSocketCache {

    //webSocket
    String WEB_SOCKET_NUM = "wsn"; 
    String version_Code = "pn"; 
    public static WebSocketCache instance;

    //    private
    public static synchronized WebSocketCache getInstance() {
        if (instance == null) {
            synchronized (WebSocketCache.class) {
                instance = new WebSocketCache();
            }
        }
        return instance;
    }

    public void getUserToken() {


    }

    public String getAccessToken() {
        return MMKVManager.getInstance().getAccessToken();
    }


    public String getWebSocketSalt() {
        return MMKVManager.getInstance().getDeviceId();
    }

    public int getSaltNum(String timestampStr) {


        return Character.getNumericValue(timestampStr.charAt(1)) +
                Character.getNumericValue(timestampStr.charAt(3)) +
                Character.getNumericValue(timestampStr.charAt(5)) +
                Character.getNumericValue(timestampStr.charAt(7)) +
                Character.getNumericValue(timestampStr.charAt(8));


    }


    public String getVersionCode() {
        return MMKVManager.getInstance().getString(CacheConstants.SYS_VERSION_CODE);
    }


}
