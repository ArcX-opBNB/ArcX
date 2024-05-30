package com.daylong.paybase;



public interface IPay {

    void pay(RechargeInfoResponse.RechargeItemBean rechargeItemBean);
    void pay(PayRequest payRequest);
}
