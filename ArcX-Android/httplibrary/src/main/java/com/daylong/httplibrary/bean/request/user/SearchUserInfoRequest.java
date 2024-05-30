package com.daylong.httplibrary.bean.request.user;

import java.io.Serializable;

public class SearchUserInfoRequest implements Serializable {
    private Long searchUserId;

    public SearchUserInfoRequest(Long searchUserId) {
        this.searchUserId = searchUserId;
    }

    public Long getSearchUserId() {
        return searchUserId;
    }

    public void setSearchUserId(Long searchUserId) {
        this.searchUserId = searchUserId;
    }
}
