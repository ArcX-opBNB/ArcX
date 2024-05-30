package net.daylong.gamesocket.strategy.response;

import net.daylong.gamesocket.listener.WebSocketDefaultListener;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class WebSocketDefaultStrategy implements WebSocketDefaultListener {


    private final List<WebSocketDefaultListener> webSocketDefaultListenerList = new ArrayList<WebSocketDefaultListener>();

    
    public void register(WebSocketDefaultListener iSocketResponseStrategy) {
        webSocketDefaultListenerList.add(iSocketResponseStrategy);
    }


    public void remover(WebSocketDefaultListener iSocketResponseStrategy) {
        webSocketDefaultListenerList.remove(iSocketResponseStrategy);
    }

    @Override
    public void connect() {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.connect();
        }
    }

    @Override
    public void reconnect() {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.reconnect();
        }
    }

    @Override
    public void connectSuc() {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.connectSuc();
        }
    }

    @Override
    public void connectFail() {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.connectFail();
        }
    }

    @Override
    public void responseError(int cmd, int code, String desc) {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.responseError(cmd, code, desc);
        }
    }

    @Override
    public void arcadeCoinReturn(Long coin) {
        for (WebSocketDefaultListener webSocketDefaultListener : webSocketDefaultListenerList) {
            webSocketDefaultListener.arcadeCoinReturn(coin);
        }
    }
}
