package com.daylong.httplibrary.bean.response;

public class ServiceMsgResponse {

    private long ctId; 
    private Integer usrId; 
    private String usrPic;
    private String ctMsg; 
    private Long sdDt;//sdDt
    public long getCtId() {
        return ctId;
    }

    public void setCtId(long ctId) {
        this.ctId = ctId;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrPic() {
        return usrPic;
    }

    public void setUsrPic(String usrPic) {
        this.usrPic = usrPic;
    }

    public String getCtMsg() {
        return ctMsg;
    }

    public void setCtMsg(String ctMsg) {
        this.ctMsg = ctMsg;
    }

    public Long getSdDt() {
        return sdDt;
    }

    public void setSdDt(Long sdDt) {
        this.sdDt = sdDt;
    }
}
