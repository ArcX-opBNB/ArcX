package net.daylong.gamesocket.runnable;


import net.daylong.gamesocket.mrg.WebSocketMrg;
import net.daylong.gamesocket.request.HeartRequest;

public class HeartBeatRunnable implements Runnable {


    /**

     */
    private static final int HEART_BEAT_RATE = 10000;

    @Override
    public void run() {

        WebSocketMrg.HANDLER.postDelayed(this, HEART_BEAT_RATE);
        WebSocketMrg.getInstance().sendMsg(new HeartRequest().getCmdMsg());
    }


    public void stop() {
        WebSocketMrg.HANDLER.removeCallbacks(this, null);
    }

    public void start() {
        WebSocketMrg.HANDLER.postDelayed(this, HEART_BEAT_RATE);
    }

    public void refresh() {
        stop();
        start();
    }
}
