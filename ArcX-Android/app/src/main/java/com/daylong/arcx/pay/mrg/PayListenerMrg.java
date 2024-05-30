package com.daylong.arcx.pay.mrg;


import com.daylong.httplibrary.bean.request.PayRequest;
import com.daylong.arcx.pay.PayListener;

import java.util.ArrayList;
import java.util.List;

public class PayListenerMrg {

    private static PayListenerMrg mInstance;
    private static List<PayListener> listenersList;

    /**

     *
     * @return
     */
    public static PayListenerMrg getInstance() {
        if (mInstance == null) {
            synchronized (PayListenerMrg.class) {
                if (mInstance == null) {
                    mInstance = new PayListenerMrg();
                    listenersList = new ArrayList<PayListener>();
                }
            }
        }
        return mInstance;
    }


    public void addListeners(PayListener listeners) {
        listenersList.add(listeners);
    }

    public void removerListeners(PayListener listeners) {
        listenersList.remove(listeners);
    }

    public void onPaySuc(int payType, String odNo, PayRequest payRequest) {
        for (PayListener payListener : listenersList) {
            payListener.onPaySuc(payType,odNo,payRequest);

        }

    }

    public void onPayFail() {
        for (PayListener payListener : listenersList) {
            payListener.onPayFail();

        }
    }
}
