package com.daylong.httplibrary.bean.response.user;

import android.view.View;

import com.daylong.httplibrary.bean.request.user.UpdateUserInfoRequest;

import net.daylong.baselibrary.view.DrawableUtils;

import java.io.Serializable;
import java.util.List;

public class LoginUserInfoResponse extends UserInfoResponse {


    private Integer sex;
    private PlyLvIfoDTO plyLvIfo;
    private EngIfoDTO engIfo;
    private List<AtbTblnDTO> atbTbln;

    public Integer getSex() {
        return sex;
    }

    public Integer getSexRegId() {
        return DrawableUtils.getDrawableByName(sex == 1 ? "img_gender_n" : "img_gender_f");
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public PlyLvIfoDTO getPlyLvIfo() {
        return plyLvIfo;
    }

    public void setPlyLvIfo(PlyLvIfoDTO plyLvIfo) {
        this.plyLvIfo = plyLvIfo;
    }

    public EngIfoDTO getEngIfo() {
        return engIfo;
    }

    public void setEngIfo(EngIfoDTO engIfo) {
        this.engIfo = engIfo;
    }

    public List<AtbTblnDTO> getAtbTbln() {
        return atbTbln;
    }


    public  long[] getAttributeList() {


        long[] attributes = new long[6];
        for (int i = 0; i < getAtbTbln().size(); i++) {
            AtbTblnDTO atbTblnDTO = getAtbTbln().get(i);
            if (i == 0) {
                attributes[i] = atbTblnDTO.getLv();
            } else {
                attributes[i] = atbTblnDTO.getSdNma();
            }
        }
        long x = attributes[4];
        attributes[4] = attributes[5];
        attributes[5] = x;
        return attributes;

    }


    public void setAtbTbln(List<AtbTblnDTO> atbTbln) {
        this.atbTbln = atbTbln;
    }

    public static class PlyLvIfoDTO implements Serializable {
        private Integer cnAmt;
        private Integer ttAmt;

        public Integer getCnAmt() {
            return cnAmt;
        }

        public void setCnAmt(Integer cnAmt) {
            this.cnAmt = cnAmt;
        }

        public Integer getTtAmt() {
            return ttAmt;
        }

        public void setTtAmt(Integer ttAmt) {
            this.ttAmt = ttAmt;
        }
    }

    public static class EngIfoDTO implements Serializable {
        private Integer cnAmt;
        private Integer ttAmt;
        private Integer lfTm;

        public Integer getCnAmt() {
            return cnAmt;
        }

        public void setCnAmt(Integer cnAmt) {
            this.cnAmt = cnAmt;
        }

        public Integer getTtAmt() {
            return ttAmt;
        }

        public void setTtAmt(Integer ttAmt) {
            this.ttAmt = ttAmt;
        }

        public Integer getLfTm() {
            return lfTm;
        }

        public void setLfTm(Integer lfTm) {
            this.lfTm = lfTm;
        }
    }

    public static class AtbTblnDTO implements Serializable {
        
        private Integer atbTp;
        
        private Integer lv;
        
        private Integer nxLv;
        
        private Integer upFlg;
        
        private Integer cmdTp;
        
        private Integer csAmt;
        private String lvAmt;
        private String nxLvAmt;

        private long sdNma;
        private long sdDma;

        public boolean isCoinPay() {
            return cmdTp == 1;
        }

        public boolean isShowUpdate() {
            return upFlg != 0;
        }

        public int getPd() {
            return (int) ((sdNma * 1.0f / sdDma) * 100);
        }

        public String getPdStr() {
            return sdNma + "/" + sdDma;
        }

        public String getLevel() {
            return "LV" + lv;
        }


        /**

         *
         * @return
         */
        public int getIconRegId() {
            return DrawableUtils.getDrawableByName("img_u_i_u_a_" + atbTp);
        }

        public int showLevel() {
            return upFlg == 1 ? View.VISIBLE : View.GONE;
        }

        /**

         *
         * @return
         */
        public int getPdRegId() {
            return DrawableUtils.getDrawableByName("u_a_i_" + atbTp + "_dp");
        }

        public Integer getAtbTp() {
            return atbTp;
        }

        public void setAtbTp(Integer atbTp) {
            this.atbTp = atbTp;
        }

        public Integer getLv() {
            return lv;
        }

        public void setLv(Integer lv) {
            this.lv = lv;
        }

        public Integer getNxLv() {
            return nxLv;
        }

        public void setNxLv(Integer nxLv) {
            this.nxLv = nxLv;
        }

        public Integer getUpFlg() {
            return upFlg;
        }

        public void setUpFlg(Integer upFlg) {
            this.upFlg = upFlg;
        }

        public Integer getCmdTp() {
            return cmdTp;
        }

        public void setCmdTp(Integer cmdTp) {
            this.cmdTp = cmdTp;
        }

        public String getCsAmt() {
            return String.valueOf(csAmt);
        }

        public void setCsAmt(Integer csAmt) {
            this.csAmt = csAmt;
        }


        public void setLvAmt(String lvAmt) {
            this.lvAmt = lvAmt;
        }

        public void setNxLvAmt(String nxLvAmt) {
            this.nxLvAmt = nxLvAmt;
        }

        public long getSdNma() {
            return sdNma;
        }

        public void setSdNma(long sdNma) {
            this.sdNma = sdNma;
        }

        public long getSdDma() {
            return sdDma;
        }

        public void setSdDma(long sdDma) {
            this.sdDma = sdDma;
        }

        public String getLvAmt() {
            return lvAmt;
        }

        public String getNxLvAmt() {
            return nxLvAmt;
        }
    }

    public UpdateUserInfoRequest getUpdateInfo() {
        return new UpdateUserInfoRequest(getPlyNm(), getSex());
    }
}
