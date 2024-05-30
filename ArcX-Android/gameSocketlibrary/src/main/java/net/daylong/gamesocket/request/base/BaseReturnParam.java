package net.daylong.gamesocket.request.base;

public class BaseReturnParam<T> {

    private int errorCode; 
    private String errorDesc; 
    private String serverTime; 
    private long serverDate; 
    private T serverMsg; 

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public long getServerDate() {
        return serverDate;
    }

    public void setServerDate(long serverDate) {
        this.serverDate = serverDate;
    }

    public T getServerMsg() {
        return serverMsg;
    }

    public void setServerMsg(T serverMsg) {
        this.serverMsg = serverMsg;
    }
}
