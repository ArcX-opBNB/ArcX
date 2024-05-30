package com.daylong.arcx.enums;

import com.daylong.arcx.R;

import java.io.Serializable;

public enum WalletType implements Serializable {
    AXC(2, "AXC", R.drawable.img_balance_axc, "AXC", 100000)//
    , USDT(3, "USDT", R.drawable.img_usdt, "USDT", 100000)//
    , SOLANA(1, "SOL", R.drawable.img_sol, "SOL", 100000)//
    ;


    private int id;
    private String name;
    private int regId;

    private String toName;
    private double ratio;


    public static WalletType getType(int id) {
        WalletType walletType = null;
        for (WalletType value : WalletType.values()) {
            if (value.getId() == id) {
                walletType = value;
                break;
            }

        }
        return walletType;
    }

    WalletType(int id, String name, int regId, String toName, double ratio) {
        this.id = id;
        this.name = name;
        this.regId = regId;
        this.toName = toName;
        this.ratio = ratio;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    /**

     *
     * @return
     */
    public String getExchangeRate() {


        return ratio + " " + toName;
    }
}
