package com.daylong.paybase;


import com.daylong.paybase.emuns.PayType;

public interface PayListener {


    /**

     *
     * @param type
     */
    void onPayScu(PayType type,String msg);

    /**

     *
     * @param code
     * @param msg
     */
    void onPayError(int code, String msg);

}
