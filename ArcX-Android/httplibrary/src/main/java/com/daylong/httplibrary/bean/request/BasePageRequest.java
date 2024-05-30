package com.daylong.httplibrary.bean.request;

import java.io.Serializable;

public class BasePageRequest implements Serializable {
    private Integer pageNum;
    private Integer pageSize;


    public BasePageRequest(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public BasePageRequest() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
