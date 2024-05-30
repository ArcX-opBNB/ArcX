package net.daylong.baselibrary.http.response;


import java.util.List;

public class BasePageResponse<T> {
    public static final int COUNT = 20;



    private int errorCode;
    private long serverDate;
    private String errorDesc;
    private List<T> serverTbln;
    private String  serverTime;



    private static final int CODE_SUCCESS = 1;

    public long getTime() {
        return serverDate;
    }

    public void setTime(long time) {
        this.serverDate = time;
    }


    public BasePageResponse(int status, String errorMsg, List<T> list) {
        this.errorCode = status;
        this.errorDesc = errorMsg;
        this.serverTbln = list;
    }

    public BasePageResponse() {
    }


    public int getStatus() {
        return errorCode;
    }

    public void setStatus(int status) {
        this.errorCode = status;
    }

    public String getErrorMsg() {
        return errorDesc;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorDesc = errorMsg;
    }

    public List<T> getList() {
        return serverTbln;
    }

    public void setList(List<T> list) {
        this.serverTbln = list;
    }



    /**

     *
     * @return
     */
    public boolean isSuccess() {
        return CODE_SUCCESS == getStatus();
    }


}
