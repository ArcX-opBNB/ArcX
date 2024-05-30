package net.daylong.baselibrary.http.response;


import java.util.List;

public class BasePageDataResponse<T,B> {
    public static final int COUNT = 20;


    private int status;
    private String errorMsg;
    private List<T> list;
    private B data;
    private long time;


    public B getData() {
        return data;
    }

    public void setData(B data) {
        this.data = data;
    }



    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private static final int CODE_SUCCESS = 1;

    public BasePageDataResponse(int status, String errorMsg, List<T> list) {
        this.status = status;
        this.errorMsg = errorMsg;
        this.list = list;
    }

    public BasePageDataResponse() {
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }



    /**

     *
     * @return
     */
    public boolean isSuccess() {
        return CODE_SUCCESS == getStatus();
    }


}
