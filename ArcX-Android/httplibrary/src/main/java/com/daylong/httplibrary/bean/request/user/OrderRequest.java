package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;
import java.util.List;

/**

 */
public class OrderRequest implements Serializable {

    private List<Long> idList;
    private long addressId;

    public OrderRequest(List<Long> idList, long addressId) {
        this.idList = idList;
        this.addressId = addressId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }
}
