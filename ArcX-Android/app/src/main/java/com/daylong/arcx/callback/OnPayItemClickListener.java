package com.daylong.arcx.callback;

import com.daylong.httplibrary.bean.request.UsdTPayRequest;
import com.daylong.httplibrary.bean.response.store.StoreInfoResponse;

public interface OnPayItemClickListener {

    void onItemSpClick(StoreInfoResponse.SpPlyIfoDTO spPlyIfoDTO);
    void onItemCoinClick(StoreInfoResponse.CnTblnDTO cnTblnDTO);
    void onItemPropClick(StoreInfoResponse.PpyIfoDTO.PpyTblnDTO ppyTblnDTO);

}
