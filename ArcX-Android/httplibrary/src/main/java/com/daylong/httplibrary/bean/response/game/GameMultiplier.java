package com.daylong.httplibrary.bean.response.game;

import java.io.Serializable;
import java.util.List;

public class GameMultiplier implements Serializable {

    private String wdwPct;
    private List<MulTblnDTO> mulTbln;

    public String getWdwPct() {
        return wdwPct;
    }

    public void setWdwPct(String wdwPct) {
        this.wdwPct = wdwPct;
    }

    public List<MulTblnDTO> getMulTbln() {
        return mulTbln;
    }

    public void setMulTbln(List<MulTblnDTO> mulTbln) {
        this.mulTbln = mulTbln;
    }

    public static class MulTblnDTO implements Serializable {
        private Integer mulAmt; 
        private Integer lmFlg; 

        public Integer getMulAmt() {
            return mulAmt;
        }

        public boolean isFlg() {

            return lmFlg == 1;
        }

        public void setMulAmt(Integer mulAmt) {
            this.mulAmt = mulAmt;
        }

        public Integer getLmFlg() {
            return lmFlg;
        }

        public void setLmFlg(Integer lmFlg) {
            this.lmFlg = lmFlg;
        }
    }
}
