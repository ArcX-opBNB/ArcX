package net.daylong.gamesocket.mrg;

import android.os.Handler;
import android.text.TextUtils;

import net.daylong.gamesocket.SocketLogUtil;
import net.daylong.gamesocket.listener.MyWebSocketListener;
import net.daylong.gamesocket.request.base.BaseMsg;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketMrg {
    private static final String TAG = "WebSocketMrg-TAG->";
    private static WebSocketMrg mInstance = null;
    private OkHttpClient client;
    private Request request;
    private WebSocket mWebSocket;
    public static final Handler HANDLER = new Handler();

    private WebSocketMrg() {
    }

    public static WebSocketMrg getInstance() {
        if (null == mInstance) {
            synchronized (WebSocketMrg.class) {
                if (mInstance == null) {
                    mInstance = new WebSocketMrg();
                }
            }
        }
        return mInstance;
    }

    /**

     */
    public static void release() {
        try {
            if (mInstance != null) {
                mInstance = null;
            }
        } catch (Exception e) {
        }
    }

    private String url;

    public void init(String url) {
        this.url = url;
        if (client != null && isConnect()) {
            return;
        }

        client = new OkHttpClient.Builder()
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        connect();
    }

    /**

     */
    public void connect() {
        if (isConnect() || TextUtils.isEmpty(url)) {
            return;
        }
        request = new Request.Builder().url(url).build();
        mWebSocket = client.newWebSocket(request, createListener());
    }

    /**

     */
    public boolean isConnect() {
        return myWebSocketListener != null && myWebSocketListener.isConnect();
    }

    private MyWebSocketListener myWebSocketListener;

    private WebSocketListener createListener() {
        if (myWebSocketListener == null) {
            myWebSocketListener = new MyWebSocketListener();
        }
        return myWebSocketListener;
    }


    public void sendMsg(BaseMsg baseMsg) {
        boolean b = sendMsg(baseMsg.getCmdMsg());



    }

    public boolean sendMsg(String msg) {


        if (!isConnect() || TextUtils.isEmpty(msg)) {
            if (!isConnect()) {

            }
            return false;
        }
        return mWebSocket.send(msg);
    }

    public void exit() {
        mInstance = null;
    }


}
