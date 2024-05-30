package com.daylong.httplibrary.bean.response.wallet;

import android.text.InputType;

import java.io.Serializable;

public class WalletConfigureResponse implements Serializable {


    private MinIfoDTO minIfo;
    private MaxIfoDTO maxIfo;
    private FeeIfoDTO feeIfo;
    private String exFee;


    public String getNetworkFee(int id) {
        if (id == 1) {
            return String.valueOf(getFeeIfo().getSol());
        } else if (id == 2) {
            return String.valueOf(getFeeIfo().getAxc());

        } else if (id == 3) {
            return String.valueOf(getFeeIfo().getUsdt());

        } else {
            return String.valueOf(getFeeIfo().getArcx());

        }
    }


    public int getInputType(int id) {

        if (id == 1 || id == 3) {

            return InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL;
        }
        return InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL;


    }

    public String getMaxInfo(int id) {
        if (id == 1) {
            return String.valueOf(getMaxIfo().getSol());
        } else if (id == 2) {
            return String.valueOf(getMaxIfo().getAxc());

        } else if (id == 3) {
            return String.valueOf(getMaxIfo().getUsdt());

        } else {
            return String.valueOf(getMaxIfo().getArcx());

        }
    }

    /**
     * a
     *
     * @param id

     * @return
     */
    public int getMaxInput(int id, double curBalance) {
        double maxInput = 0;
        if (id == 1) {
            maxInput = getMaxIfo().getSol();
        } else if (id == 2) {
            maxInput = getMaxIfo().getAxc() * 1.0f;

        } else if (id == 3) {
            maxInput = getMaxIfo().getUsdt();

        } else {
            maxInput = getMaxIfo().getArcx() * 1.0f;
        }

        if (curBalance < maxInput) {
            maxInput = curBalance;
        }
        return (int) (maxInput * 100);
    }

    /**
     * a
     *
     * @param id
     * @return
     */
    public int getMinInput(int id) {
        double maxInput = 0;
        if (id == 1) {
            maxInput = getMinIfo().getSol();
        } else if (id == 2) {
            maxInput = getMinIfo().getAxc() * 1.0f;

        } else if (id == 3) {
            maxInput = getMinIfo().getUsdt();

        } else {
            maxInput = getMinIfo().getArcx() * 1.0f;
        }
        return (int) (maxInput * 100);
    }


    public MinIfoDTO getMinIfo() {
        return minIfo;
    }

    public void setMinIfo(MinIfoDTO minIfo) {
        this.minIfo = minIfo;
    }

    public MaxIfoDTO getMaxIfo() {
        return maxIfo;
    }

    public void setMaxIfo(MaxIfoDTO maxIfo) {
        this.maxIfo = maxIfo;
    }

    public FeeIfoDTO getFeeIfo() {
        return feeIfo;
    }

    public void setFeeIfo(FeeIfoDTO feeIfo) {
        this.feeIfo = feeIfo;
    }

    public String getExFee() {
        return exFee;
    }

    public void setExFee(String exFee) {
        this.exFee = exFee;
    }

    public static class MinIfoDTO implements Serializable {
        private Double sol;
        private Double usdt;
        private Integer axc;
        private Integer arcx;

        public Double getSol() {
            return sol;
        }

        public void setSol(Double sol) {
            this.sol = sol;
        }

        public Double getUsdt() {
            return usdt;
        }

        public void setUsdt(Double usdt) {
            this.usdt = usdt;
        }

        public Integer getAxc() {
            return axc;
        }

        public void setAxc(Integer axc) {
            this.axc = axc;
        }

        public Integer getArcx() {
            return arcx;
        }

        public void setArcx(Integer arcx) {
            this.arcx = arcx;
        }
    }

    public static class MaxIfoDTO implements Serializable {
        private Double sol;
        private Double usdt;
        private Integer axc;
        private Integer arcx;

        public Double getSol() {
            return sol;
        }

        public void setSol(Double sol) {
            this.sol = sol;
        }

        public Double getUsdt() {
            return usdt;
        }

        public void setUsdt(Double usdt) {
            this.usdt = usdt;
        }

        public Integer getAxc() {
            return axc;
        }

        public void setAxc(Integer axc) {
            this.axc = axc;
        }

        public Integer getArcx() {
            return arcx;
        }

        public void setArcx(Integer arcx) {
            this.arcx = arcx;
        }
    }

    public static class FeeIfoDTO implements Serializable {
        private Double sol;
        private Double usdt;
        private Integer axc;
        private Integer arcx;

        public Double getSol() {
            return sol;
        }

        public void setSol(Double sol) {
            this.sol = sol;
        }

        public Double getUsdt() {
            return usdt;
        }

        public void setUsdt(Double usdt) {
            this.usdt = usdt;
        }

        public Integer getAxc() {
            return axc;
        }

        public void setAxc(Integer axc) {
            this.axc = axc;
        }

        public Integer getArcx() {
            return arcx;
        }

        public void setArcx(Integer arcx) {
            this.arcx = arcx;
        }
    }
}
