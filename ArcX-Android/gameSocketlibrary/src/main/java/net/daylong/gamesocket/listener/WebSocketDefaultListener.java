package net.daylong.gamesocket.listener;

public interface WebSocketDefaultListener {


    /**

     */
    void connect();

    /**

     */
    void reconnect();

    /**

     */
    void connectSuc();

    /**

     */
    void connectFail();

    /**

     *



     */
    void responseError(int cmd, int code, String desc);


    /**

     *
     * @param coin
     */
    void arcadeCoinReturn(Long coin);


}
