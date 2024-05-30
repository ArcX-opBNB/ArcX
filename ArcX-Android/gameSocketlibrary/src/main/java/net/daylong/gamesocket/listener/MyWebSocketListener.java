package net.daylong.gamesocket.listener;

import net.daylong.gamesocket.SocketLogUtil;
import net.daylong.gamesocket.runnable.HeartBeatRunnable;
import net.daylong.gamesocket.runnable.WebSocketConnectRunnable;
import net.daylong.gamesocket.strategy.response.SocketResponseStrategy;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class MyWebSocketListener extends WebSocketListener {
    private static final String TAG = "WEB->Listener->";

    private boolean isConnect;
    /**

     */
    private HeartBeatRunnable heartBeatRunnable;
    private WebSocketConnectRunnable webSocketConnectRunnable;


    public boolean isConnect() {
        return isConnect;
    }

    public MyWebSocketListener() {
        heartBeatRunnable = new HeartBeatRunnable();
        webSocketConnectRunnable = new WebSocketConnectRunnable();


    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);

        SocketResponseStrategy.getInstance().getWebSocketDefaultStrategy().connectSuc();

        isConnect = response.code() == 101;
        if (isConnect) {
            
            heartBeatRunnable.refresh();
            
            webSocketConnectRunnable.reReconnectNum();
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, final String text) {
        super.onMessage(webSocket, text);
        
        SocketResponseStrategy.getInstance().callback(text);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);

        webSocket.close(1000, null);

    }
    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        SocketResponseStrategy.getInstance().getWebSocketDefaultStrategy().connectFail();
        isConnect = false;
        
        webSocketConnectRunnable.reconnect();


    }
}
