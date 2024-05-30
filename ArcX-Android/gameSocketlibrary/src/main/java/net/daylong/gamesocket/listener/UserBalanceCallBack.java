package net.daylong.gamesocket.listener;

public interface UserBalanceCallBack {
    void userBalance(long goldNum, long integralNum);


    /**

     *
     * @param cnAmt 
     * @param ttAmt 
     * @param cgAmt 
     * @param lfTm 
     */
    void userEnergy(int cnAmt, int ttAmt, int cgAmt, int lfTm);
}
