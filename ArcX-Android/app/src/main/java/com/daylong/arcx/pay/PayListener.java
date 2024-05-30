package com.daylong.arcx.pay;

import com.daylong.httplibrary.bean.request.PayRequest;

/**

 */
public interface PayListener {


    /**


     */
    void onPaySuc(int payType, String odNo, PayRequest payRequest);

    void onPayFail();

}
