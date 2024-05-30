package net.daylong.baselibrary.http.base;
public class BaseRtcResponse<T> {

    private static final int CODE_SUCCESS = 0;
    private int errcode;
    private String errmsg;
    private T remotesdp;
    private String svrsig;


    public BaseRtcResponse(int errcode, String errmsg, T remotesdp, String svrsig) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.remotesdp = remotesdp;
        this.svrsig = svrsig;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getRemotesdp() {
        return remotesdp;
    }

    public void setRemotesdp(T remotesdp) {
        this.remotesdp = remotesdp;
    }

    public String getSvrsig() {
        return svrsig;
    }

    public void setSvrsig(String svrsig) {
        this.svrsig = svrsig;
    }

    /**

     *
     * @return
     */
    public boolean isSuccess() {
        return CODE_SUCCESS==getErrcode();
    }


}
