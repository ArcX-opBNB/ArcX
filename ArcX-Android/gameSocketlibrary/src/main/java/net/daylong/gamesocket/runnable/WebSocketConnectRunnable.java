package net.daylong.gamesocket.runnable;


import net.daylong.gamesocket.mrg.WebSocketMrg;

public class WebSocketConnectRunnable implements Runnable {


    /**

     */
    private int reconnectNum;
    private static final int NEXT_RECONNECT_TIME = 1000 * 5; 

    @Override
    public void run() {
        WebSocketMrg.getInstance().connect();
    }


    public void reconnect() {
        WebSocketMrg.HANDLER.postDelayed(this, reconnectNum == 0 ? 0 : NEXT_RECONNECT_TIME);
        reconnectNum++;
    }


    public void isReconnect() {

    }

    /**

     */
    public void reReconnectNum() {
        if (reconnectNum != 0) {
            this.reconnectNum = 0;
        }
    }
}
