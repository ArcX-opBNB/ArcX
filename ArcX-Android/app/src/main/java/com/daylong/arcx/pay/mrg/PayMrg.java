package com.daylong.arcx.pay.mrg;

import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.pay.AliPay;



public class PayMrg {
    private static PayMrg mInstance;
    private static AliPay aliPay;

    /**

     *
     * @return
     */
    public static PayMrg getInstance() {
        if (mInstance == null) {
            synchronized (PayMrg.class) {
                if (mInstance == null) {
                    mInstance = new PayMrg();
                    aliPay = new AliPay();
                }
            }
        }
        return mInstance;
    }




    public void aliPay(PayRequest payRequest) {
        aliPay.pay(payRequest);
    }

}
