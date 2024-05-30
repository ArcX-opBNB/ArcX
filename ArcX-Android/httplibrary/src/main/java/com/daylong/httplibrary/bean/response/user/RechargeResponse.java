package com.daylong.httplibrary.bean.response.user;

import com.daylong.basecache.GameCache;
import com.daylong.httplibrary.bean.AwardBean;
import com.daylong.httplibrary.bean.request.PayRequest;

import net.daylong.baselibrary.utils.StringUtils;

import java.io.Serializable;
import java.util.List;

public class RechargeResponse implements Serializable {
    private List<GoldListDTO> goldList;

    public List<GoldListDTO> getGoldList() {
        return goldList;
    }

    public void setGoldList(List<GoldListDTO> goldList) {
        this.goldList = goldList;
    }

    public static class GoldListDTO {
        private Integer commodityId;
        private String iosCommodityId;
        private Integer price;
        private String awardImgUrl;
        private long awardNum;

        public Integer getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(Integer commodityId) {
            this.commodityId = commodityId;
        }

        public String getIosCommodityId() {
            return iosCommodityId;
        }

        public void setIosCommodityId(String iosCommodityId) {
            this.iosCommodityId = iosCommodityId;
        }

        public String getPrice() {
            return "¥" + price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getAwardImgUrl() {
            return awardImgUrl;
        }

        public void setAwardImgUrl(String awardImgUrl) {
            this.awardImgUrl = awardImgUrl;
        }

        public String getAwardNum() {
            return StringUtils.numFormatDot(awardNum);
        }


        public long getAwardNumInt() {
            return awardNum;
        }

        public void setAwardNum(Integer awardNum) {
            this.awardNum = awardNum;
        }


        public AwardBean create() {
            AwardBean awardBean = new AwardBean();
            awardBean.setAwardImgUrl(getAwardImgUrl());
            awardBean.setAwardNum(getAwardNumInt());
            awardBean.setCommodityType(getCommodityId());

            return awardBean;
        }

        public PayRequest playBalance() {
            return new PayRequest(1, GameCache.getGameRoomId(),getCommodityId(),  getAwardNumInt(),  getAwardImgUrl());
        }


    }
}
