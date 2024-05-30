package net.daylong.gamesocket.request.base;


import net.daylong.gamesocket.cache.WebSocketCache;

public class BaseParam {


    private long tsmp;
    private int rdAmt;
    private String mcCd ;
    private String arcxPsd;
    private String vsCd;
    private String plm = "android";

    public BaseParam() {

    }

    public long getTsmp() {
        return tsmp;
    }

    public void setTsmp(long tsmp) {
        this.tsmp = tsmp;
    }

    public int getRdQt() {
        return rdAmt;
    }

    public void setRdQt(int rdQt) {
        this.rdAmt = rdQt;
    }

    public String getDeviceId() {
        return mcCd ;
    }

    public void setDeviceId(String deviceId) {
        this.mcCd  = deviceId;
    }

    public String getTidePlayPas() {
        return arcxPsd;
    }

    public void setTidePlayPas(String tidePlayPas) {
        this.arcxPsd = tidePlayPas;
    }

    public String getVsCd() {
        return vsCd;
    }

    public void setVsCd(String vsCd) {
        this.vsCd = vsCd;
    }

    public String getPlm() {
        return plm;
    }

    public void setPlm(String plm) {
        this.plm = plm;
    }


}
